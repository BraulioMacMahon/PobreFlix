//import android.content.Intent
//import android.net.Uri
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.*
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.AsyncImage
//import com.example.pobreflix.data.MovieViewModel
//import androidx.compose.ui.tooling.preview.Preview
//
//
//@Composable
//fun MovieScreen(viewModel: MovieViewModel) {
//    var searchText by remember { mutableStateOf("") }
//    val movies = remember { mutableStateOf<List<MovieEntity>>(emptyList()) }
//
//    LaunchedEffect(Unit) {
//        viewModel.getMovies { movies.value = it }
//    }
//
//    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//        TextField(
//            value = searchText,
//            onValueChange = {
//                searchText = it
//                viewModel.searchMovies(it) { movies.value = it }
//            },
//            label = { Text("Pesquisar Filme") },
//            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
//        )
//
//        LazyColumn {
//            items(movies.value) { movie ->
//                MovieItem(movie, onDelete = { viewModel.deleteMovie(movie) })
//            }
//        }
//    }
//}
//
//@Composable
//fun MovieItem(movie: MovieEntity, onDelete: () -> Unit) {
//    val context = LocalContext.current // Obtém o contexto da aplicação corretamente
//
//    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            AsyncImage(
//                model = movie.imageUrl,
//                contentDescription = "Imagem do Filme",
//                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(8.dp)),
//                contentScale = ContentScale.Crop
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = movie.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
//            Text(text = "Nota: ${movie.rating}")
//            Text(text = "Lançamento: ${movie.date}")
//
//            Text(
//                text = "Site Oficial",
//                color = Color.Blue,
//                modifier = Modifier.clickable {
//                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.officialLink))
//                    context.startActivity(intent) // Agora funciona corretamente
//                }
//            )
//
//            Button(onClick = onDelete) {
//                Text("Remover")
//            }
//        }
//    }
//}
//
//@Composable
//@Preview
//fun Preview(){
//
//}