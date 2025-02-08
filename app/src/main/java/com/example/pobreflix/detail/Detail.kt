package com.example.pobreflix.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pobreflix.R
import com.example.pobreflix.ExpandingText
import com.example.pobreflix.data.MovieEntity
import com.example.pobreflix.viewmodel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detail(
    movieId: Int, // Recebe o ID do filme
    goToBack: () -> Unit,
    viewModel: MovieViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var movie by remember { mutableStateOf<MovieEntity?>(null) }

    LaunchedEffect(movieId) {
        viewModel.getMovieById(movieId) { fetchedMovie ->
            movie = fetchedMovie
        }
    }
    Surface(Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { goToBack() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(0xff01356d)
                        )
                    }
                },
                title = {
                    Image(
                        painter = painterResource(R.drawable.pobreflix_tipo_),
                        contentDescription = "Logo do Pobreflix",
                        modifier = Modifier.size(80.dp),
                        colorFilter = ColorFilter.lighting(multiply = Color.White, MaterialTheme.colors.primary)
                    )
                }
            )
            Column() {
                movie?.let { movie ->
                    Column(
                        Modifier.verticalScroll(ScrollState(0)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(Modifier.fillMaxWidth().height(300.dp)){
                            AsyncImage(
                                model = movie.imageResId, // Agora a imagem vem de uma URL
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Row(modifier =  Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(start = 30.dp, top = 20.dp)) {
                                Text(
                                    text = movie.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp,
                                    textAlign = TextAlign.Left,
                                    color = Color.DarkGray,
                                    modifier = Modifier.width(290.dp)

                                )

                                Text(
                                    text = movie.releaseDate,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Left,
                                    color = Color.DarkGray,
                                    modifier = Modifier
                                        .padding(start = 5.dp)
                                        .width(150.dp)
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(70.dp),
                                contentAlignment = Alignment.Center
                            ) {

                                val degrade = Brush.horizontalGradient(listOf(Color(0xffECC440), Color(0xffFFFA8A), Color(0xffDDAC17), Color(0xffFFFF95)))

                                IconButton(
                                    onClick = {}
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Star,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(33.dp)
                                            .clickable {  },
                                        tint = Color(0xfffff100)
                                    )
                                }
                            }

                        }

                        Column(
                            modifier = Modifier
                                .width(340.dp)
                                .padding(top = 15.dp, bottom = 30.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(25.dp)
                        ){
                            val shape = RoundedCornerShape(20)

                            ExpandingText(movie.description)

                            val context = LocalContext.current
                            val url = "https://sisa.unimetro.org/"
                            Button(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    context.startActivity(intent)},
                                colors = ButtonDefaults.buttonColors(Color(0xff01356d)),
                                shape = shape
                            ) {
                                Text(
                                    text = "Ver Trailer...",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }


                } ?: Text(text = "Carregando...", modifier = Modifier.padding(16.dp))
            }
        }
    }
}


