package com.example.pobreflix

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.example.pobreflix.data.MovieEntity
import com.example.pobreflix.viewmodel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    search: () -> Unit,
    detail: (MovieEntity) -> Unit,
    movieViewModel: MovieViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val movies by movieViewModel.movies.collectAsState()

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {

            TopAppBar(
                scrollBehavior = scrollBehavior,
                modifier = Modifier
                    .height(80.dp),

                title = {
                    Image(
                        painter = painterResource(R.drawable.pobreflix_tipo_),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(start = 10.dp),
                        colorFilter = ColorFilter.lighting(multiply = Color.White, MaterialTheme.colors.primary)
                    )
                },
                actions = {
                    IconButton(onClick = { search() }) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Unspecified)
            )

        },
        bottomBar = {

            BottomApp()

        },
        floatingActionButton = {
            var isDisplayAlert by remember { mutableStateOf(false) }
            FloatingActionButton(
                onClick = {isDisplayAlert = true},
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .size(50.dp),
                containerColor = Color(0xff01356d),
            ) {
                if(isDisplayAlert) MyAlertDialog("Indisponivel",onDismissRequest = {isDisplayAlert = false})
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = null, tint = Color(0xffbeedf4))
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(movies.take(4)) { movie ->
                        CardModelCarrocel(detail = { detail(movie) }, movie = movie)
                    }
                }

                HorizontalDivider(color = Color.LightGray)

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(150.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
                            .fillMaxSize()
                    ) {
                        items(movies) { movie ->
                            CardGred(detail = { detail(movie) }, movie = movie)
                        }
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardGred(movie: MovieEntity, detail: () -> Unit) {

    Column(modifier = Modifier.padding(15.dp)) {
        Card(
            onClick = { detail() },
            modifier = Modifier
                .width(178.dp)
                .height(90.dp),
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardModelCarrocel(movie: MovieEntity, detail: () -> Unit) {
    Column {
        Card(
            onClick = { detail() },
            modifier = Modifier
                .width(300.dp)
                .height(150.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            val painter = rememberImagePainter(
                data = movie.imageResId,
                builder = {
                }
            )
            val painterState = painter.state
            Image(painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            if (painterState is AsyncImagePainter.State.Loading){
                CircularProgressIndicator(Modifier.size(10.dp))
            }
        }
        Text(
            text = movie.title,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .width(250.dp)
                .padding(start = 10.dp)
        )
        Text(
            text = movie.releaseDate,
            fontWeight = FontWeight.Light,
            fontSize = 10.sp,
            textAlign = TextAlign.Left,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(start = 10.dp)
                .width(100.dp)
        )

    }

}

@Composable
fun BottomApp(modifier: Modifier = Modifier){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .clip(RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp))
        .background(Color(0xff01356d)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        Box (
            modifier = Modifier.padding(end = 25.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier.padding(bottom = 5.dp)
            ) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Rounded.Home,
                    contentDescription = null,
                    tint = Color(0xffbeedf4)
                )
            }
            Text(
                text = stringResource(R.string.home),
                fontSize = 11.sp,
                color = Color(0xffbeedf4),

                )
        }



        Box(
            modifier = Modifier.padding(end = 25.dp),
            contentAlignment = Alignment.BottomCenter) {
            IconButton(
                modifier = Modifier.padding(bottom = 5.dp),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(60.dp),
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = null,
                    tint = Color(0xffbeedf4),

                    )
            }
            Text(
                text = stringResource(R.string.categorias),
                fontSize = 11.sp,
                color = Color(0xffbeedf4)
            )
        }


        Box(
            modifier = Modifier.padding(end = 25.dp),
            contentAlignment = Alignment.BottomCenter) {
            IconButton(
                modifier = Modifier.padding(bottom = 5.dp),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Rounded.Star,
                    contentDescription = null,
                    tint = Color(0xffbeedf4)
                )
            }

            Text(
                text = stringResource(R.string.favoritos),
                fontSize = 11.sp,
                color = Color(0xffbeedf4),

                )
        }



        Box(
            contentAlignment = Alignment.BottomCenter) {
            IconButton(
                modifier = Modifier.padding(bottom = 5.dp),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Rounded.Settings,
                    contentDescription = null,
                    tint = Color(0xffbeedf4)
                )
            }
            Text(
                text = stringResource(R.string.defini_es),
                fontSize = 11.sp,
                color = Color(0xffbeedf4)
            )
        }
    }
}



