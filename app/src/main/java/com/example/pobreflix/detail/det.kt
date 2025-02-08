//package com.example.pobreflix.detail
//
//import androidx.compose.ui.layout.ContentScale
//import coil.compose.AsyncImage
//
//package com.example.pobreflix.detail
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.ScrollState
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.ArrowBack
//import androidx.compose.material.icons.rounded.Star
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.pobreflix.R
//import com.example.pobreflix.ExpandingText
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Detail(
//    goToBack: () -> Unit
//){
//
//    Scaffold(
//        containerColor = Color.White,
//        topBar = {
//            TopAppBar(
//
//                navigationIcon = {
//                    IconButton(
//                        onClick = {
//                            goToBack()
//                        }
//                    ) {
//                        Icon(
//                            imageVector = Icons.Rounded.ArrowBack,
//                            contentDescription = null,
//                            tint = Color(0xff01356d)
//                        )
//                    }
//                },
//
//                title = {
//                    Image(
//                        painter = painterResource(R.drawable.pobreflix_tipo_),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(80.dp)
//                            .padding(start = 10.dp, top = 5.dp)
//                    )
//                },
//
//                colors = TopAppBarDefaults.topAppBarColors(Color.White),
//
//                )
//        }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier.padding(paddingValues),
//            horizontalAlignment = Alignment.CenterHorizontally,
//
//            ) {
//
//
//
//    }
//}
//
//
//movie?.let { movie ->
//    AsyncImage(
//        model = movie.imageResId, // Agora a imagem vem de uma URL
//        contentDescription = movie.title,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier.fillMaxWidth()
//    )
//    Text(text = movie.title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
//    Text(text = movie.releaseDate, fontSize = 15.sp)
//    ExpandingText(movie.description)
//} ?: Text(text = "Carregando...", modifier = Modifier.padding(16.dp))