package com.example.pobreflix.search


import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pobreflix.R
import com.example.pobreflix.data.MovieEntity
import com.example.pobreflix.viewmodel.MovieViewModel
import androidx.compose.material3.*
import androidx.compose.ui.res.stringResource
import com.example.pobreflix.myColor
import androidx.compose.material3.TextField
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    goToBack: () -> Unit,
    goToDetail: (MovieEntity) -> Unit,
    movieViewModel: MovieViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val movies by movieViewModel.movies.collectAsState()
    val context = LocalContext.current
    val factory =
        remember { MovieViewModel.MovieViewModelFactory(context.applicationContext as Application) }
    val viewModel: MovieViewModel = viewModel(factory = factory)
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    val allMovies by viewModel.movies.collectAsState(initial = emptyList())

    // Filtra os filmes com base no texto digitado
    val filteredMovies = allMovies.filter { movie ->
        movie.title.contains(searchQuery.text, ignoreCase = true)
    }

    Surface(Modifier.fillMaxSize()) {

        Column(Modifier.fillMaxSize()) {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(R.drawable.logo_preto),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp),
                        colorFilter = ColorFilter.lighting(multiply = Color.White, MaterialTheme.colors.primary)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = goToBack) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(0xff01356d),
                            modifier = Modifier.size(25.dp)
                        )
                    }
                },
                actions = {
                    val shape = RoundedCornerShape(5.dp)
                    TextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        maxLines = 1,
                        shape = shape,
                        textStyle = TextStyle(color = Color.DarkGray),
                        modifier = Modifier.padding(8.dp).size(300.dp, 50.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFF1F1F1),
                            unfocusedContainerColor = Color.Transparent,
                            focusedLabelColor = myColor,
                            unfocusedLabelColor = myColor,
                            unfocusedTextColor = myColor,
                            cursorColor = MaterialTheme.colors.primary,
                            unfocusedIndicatorColor = myColor,
                            focusedIndicatorColor = myColor
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                modifier = Modifier.size(25.dp),
                                tint = Color(0xff01356d)
                            )

                        }
                    )

                }
            )
            // Campo de Pesquisa
            Row(
                Modifier
                    .horizontalScroll(ScrollState(0))
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                val shape = RoundedCornerShape(10.dp)
                Button(onClick = {}, shape = shape) { Text(text = "Terror") }
                Button(onClick = {}, shape = shape) { Text(text = "Romance") }
                Button(onClick = {}, shape = shape) { Text(text = "Ação") }
                Button(onClick = {}, shape = shape) { Text(text = "Comédia") }
                Button(onClick = {}, shape = shape) { Text(text = "Fição Cientifica") }
            }
            // Lista de Filmes Filtrados
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(filteredMovies) { movie ->
                    MovieItem(goToDetail = {goToDetail(movie)}, movie = movie)
                }
            }
        }
    }

}




@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieItem(movie: MovieEntity, goToDetail: () -> Unit) {
    Column() {
        Card(
            onClick = { goToDetail() },
            modifier = Modifier
                .fillMaxWidth()
            ,
            contentColor = Color(0xff01356d),
            shape = RoundedCornerShape(10.dp)
        ) {
            AsyncImage(
                model = movie.imageResId, // Agora a imagem vem de uma URL
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = movie.title,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(start = 10.dp)
                .width(150.dp)
        )
        Text(
            text = movie.releaseDate,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Left,
            fontSize = 10.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 10.dp)
                .width(100.dp)
        )
    }
}
