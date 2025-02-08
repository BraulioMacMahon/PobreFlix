package com.example.pobreflix.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// 1. Criar a API Service
interface MovieApiService {
    @GET("movies") // Ajuste conforme o endpoint real da API
    suspend fun getMovies(): List<MovieEntity>

    @GET("movies/search") // Endpoint para busca
    suspend fun searchMovies(@Query("query") query: String): List<MovieEntity>
}

object RetrofitInstance {
    private const val BASE_URL = "https://api.exemplo.com/" // Substitua pela URL real

    val api: MovieApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }
}

class MovieRepository(private val movieDao: MovieDao, private val api: MovieApiService) {

    private val firestore = FirebaseFirestore.getInstance()

    suspend fun insertMovie(movie: MovieEntity) {
        movieDao.insertMovie(movie) // Insere localmente
        firestore.collection("movies").document(movie.id.toString()).set(movie)
    }

    suspend fun getAllMovies(): List<MovieEntity> {
        return try {
            // Primeiro tenta buscar da API
            val moviesFromApi = api.getMovies()
            movieDao.insertMovies(moviesFromApi) // Atualiza localmente
            moviesFromApi
        } catch (apiException: Exception) {
            try {
                // Se API falhar, tenta buscar do Firestore
                val snapshot = firestore.collection("movies").get().await()
                val moviesFromFirebase = snapshot.documents.mapNotNull { it.toObject<MovieEntity>() }
                movieDao.insertMovies(moviesFromFirebase) // Atualiza localmente
                moviesFromFirebase
            } catch (firebaseException: Exception) {
                // Se Firestore falhar, retorna do banco local
                movieDao.getAllMovies()
            }
        }
    }

    suspend fun getSearchMovies(query: String): List<MovieEntity> {
        return try {
            // Busca na API primeiro
            val moviesFromApi = api.searchMovies(query)
            moviesFromApi
        } catch (apiException: Exception) {
            try {
                // Se API falhar, tenta Firestore
                val snapshot = firestore.collection("movies")
                    .whereGreaterThanOrEqualTo("title", query)
                    .get().await()

                snapshot.documents.mapNotNull { it.toObject<MovieEntity>() }
            } catch (firebaseException: Exception) {
                // Se Firestore falhar, busca localmente
                movieDao.searchMovies(query)
            }
        }
    }

    suspend fun getMovieById(id: Int): MovieEntity? {
        return try {
            // Primeiro tenta buscar localmente
            movieDao.getMovieById(id) ?: run {
                // Se não encontrar no banco local, busca no Firestore
                val document = firestore.collection("movies").document(id.toString()).get().await()
                document.toObject<MovieEntity>()
            }
        } catch (e: Exception) {
            null // Se tudo falhar, retorna null
        }
    }
}
