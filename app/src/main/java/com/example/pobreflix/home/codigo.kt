//package com.example.pobreflix
//
//
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.Face
//import androidx.compose.material.icons.rounded.Home
//import androidx.compose.material.icons.rounded.Menu
//import androidx.compose.material.icons.rounded.Notifications
//import androidx.compose.material.icons.rounded.PlayArrow
//import androidx.compose.material.icons.rounded.Search
//import androidx.compose.material.icons.rounded.Settings
//import androidx.compose.material.icons.rounded.Star
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.material3.rememberTopAppBarState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.compose.rememberNavController
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Home(
//    search: () -> Unit,
//    detail: () -> Unit,
//
//    ){
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
//    val navController = rememberNavController()
//
//    Scaffold(
//        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//
//        topBar = {
//            TopAppBar(
//
//                scrollBehavior = scrollBehavior,
//
//                title = {
//                    Image(
//                        painter = painterResource(R.drawable.pobreflix_tipo_),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(80.dp)
//                            .padding(start = 10.dp)
//                    )
//                },
//                navigationIcon = {
//                    Icon(
//                        imageVector = Icons.Rounded.Menu,
//                        contentDescription = null,
//                        modifier = Modifier.padding(start = 15.dp).size(30.dp),
//                        tint = Color(0xff01356d)
//                    )
//                },
//
//                actions = {
//
//
//
//                    IconButton(
//                        onClick = {
//                            search()
//                        },
//
//                        ) {
//                        Icon(
//                            imageVector = Icons.Rounded.Search,
//                            contentDescription = null,
//                            tint = Color(0xff01356d),
//                            modifier = Modifier.size(30.dp)
//                        )
//                    }
//
//                    IconButton(
//                        onClick = {},
//                        modifier = Modifier.padding(end = 10.dp),
//
//                        ) {
//                        Icon(
//                            imageVector = Icons.Rounded.Face,
//                            contentDescription = null,
//                            tint = Color(0xff01356d),
//                            modifier = Modifier.size(30.dp)
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(Color.White),
//
//                )
//        },
//
//        bottomBar = {
//            val shape = RoundedCornerShape(50)
//            BottomAppBar(
//                modifier = Modifier
//                    .size(width = Dp.Infinity, height = 115.dp)
//                    .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
//                    .background(Color.Red),
//                containerColor = Color(0xff01356d)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .fillMaxWidth()
//                        .padding(start = 38.dp),
//                    horizontalArrangement = Arrangement.spacedBy(40.dp),
//
//                    ) {
//
//                    Box(contentAlignment = Alignment.BottomCenter) {
//                        IconButton(
//                            onClick = {}
//                        ) {
//                            Icon(
//                                modifier = Modifier.size(35.dp),
//                                imageVector = Icons.Rounded.Home,
//                                contentDescription = null,
//                                tint = Color(0xffbeedf4)
//                            )
//                        }
//                        Text(
//                            text = stringResource(R.string.home),
//                            fontSize = 11.sp,
//                            color = Color(0xffbeedf4)
//                        )
//                    }
//
//
//
//                    Box(contentAlignment = Alignment.BottomCenter) {
//                        IconButton(
//                            onClick = {}
//                        ) {
//                            Icon(
//                                modifier = Modifier.size(40.dp),
//                                imageVector = Icons.Rounded.PlayArrow,
//                                contentDescription = null,
//                                tint = Color(0xffbeedf4)
//                            )
//                        }
//                        Text(
//                            text = stringResource(R.string.categorias),
//                            fontSize = 11.sp,
//                            color = Color(0xffbeedf4)
//                        )
//                    }
//
//
//                    Box(contentAlignment = Alignment.BottomCenter) {
//                        IconButton(
//                            onClick = {}
//                        ) {
//                            Icon(
//                                modifier = Modifier.size(35.dp),
//                                imageVector = Icons.Rounded.Star,
//                                contentDescription = null,
//                                tint = Color(0xffbeedf4)
//                            )
//                        }
//
//                        Text(
//                            text = stringResource(R.string.favoritos),
//                            fontSize = 11.sp,
//                            color = Color(0xffbeedf4),
//
//                            )
//                    }
//
//
//
//                    Box(contentAlignment = Alignment.BottomCenter) {
//                        IconButton(
//                            onClick = {}
//                        ) {
//                            Icon(
//                                modifier = Modifier.size(30.dp),
//                                imageVector = Icons.Rounded.Settings,
//                                contentDescription = null,
//                                tint = Color(0xffbeedf4)
//                            )
//                        }
//                        Text(
//                            text = stringResource(R.string.defini_es),
//                            fontSize = 11.sp,
//                            color = Color(0xffbeedf4)
//                        )
//                    }
//                }
//
//            }
//        },
//
//        floatingActionButton = {
//            var isDisplayAlert by remember { mutableStateOf(false) }
//            FloatingActionButton(
//                onClick = {isDisplayAlert = true},
//                modifier = Modifier
//                    .clip(RoundedCornerShape(50.dp))
//                    .size(50.dp),
//                containerColor = Color(0xff01356d),
//            ) {
//                if(isDisplayAlert) MyAlertDialog(onDismissRequest = {isDisplayAlert = false})
//                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = null, tint = Color(0xffbeedf4))
//            }
//        }
//    ) {paddingValues ->
//        Surface(modifier = Modifier
//            .padding(paddingValues)
//            .background(Color.Transparent)) {
//
//            Column(modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//
//
//                Column(
//                    modifier = Modifier
//                        .padding(horizontal = 15.dp)
//
//                ) {
//                    val verticalGradient = Brush.verticalGradient(listOf(Color.Green, Color.Transparent))
//                    LazyRow(
//                        modifier = Modifier.padding(bottom = 10.dp),
//                        horizontalArrangement = Arrangement.spacedBy(10.dp)
//                    ) {
//                        items(count = 8){
//                            CardModelCarrocel(detail = {})
//                        }
//                    }
//
//                    HorizontalDivider(color = Color.LightGray)
//
//                    LazyVerticalGrid(
//                        GridCells.Fixed(2),
//                        verticalArrangement = Arrangement.spacedBy(14.dp),
//                        horizontalArrangement = Arrangement.spacedBy(12.dp),
//                        modifier = Modifier.padding(top = 10.dp)
//                    ) {
//
//
//                        items(count = 50){
//                            CardGred(detail = {})
//                        }
//                    }
//                }
//
//            }
//
//
//        }
//    }
//
//}
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun CardGred(
//    id: Int = 0,
//    detail: () -> Unit,
//){
//    val navController = rememberNavController()
//    val shape = RoundedCornerShape(10.dp)
//    Column {
//        Card(
//            onClick = {
//                detail()
//            },
//            modifier = Modifier
//                .width(178.dp)
//                .height(90.dp),
//            contentColor = Color(0xff01356d),
//            shape = shape
//        ) {
//            Column(modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xff01356d))) {
//
//                Image(
//                    painter = painterResource(R.drawable.vingadores_img),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop
//                )
//
//            }
//        }
//        androidx.compose.material3.Text(
//            text = stringResource(R.string.vingadores_ultimato),
//            fontWeight = FontWeight.Bold,
//            fontSize = 15.sp,
//            color = Color.DarkGray,
//            textAlign = TextAlign.Left,
//            modifier = Modifier
//                .padding(start = 10.dp)
//                .width(150.dp),
//        )
//
//        androidx.compose.material3.Text(
//            text = stringResource(R.string.abril_de_2019),
//            fontWeight = FontWeight.Light,
//            textAlign = TextAlign.Left,
//            fontSize = 10.sp,
//            color = Color.DarkGray,
//            modifier = Modifier
//                .padding(start = 10.dp)
//                .width(100.dp),
//        )
//
//
//
//    }
//}
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun CardModelCarrocel(
//    id: Int = 0,
//    detail: () -> Unit
//){
//    val shape = RoundedCornerShape(10.dp)
//    val navController = rememberNavController()
//    Column {
//        Card(
//            onClick = {
//                detail()
//            },
//            modifier = Modifier
//                .width(300.dp)
//                .height(150.dp),
//            contentColor = Color(0xff01356d),
//            shape = shape
//        ) {
//            Column(modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xff01356d))) {
//
//                Image(
//                    painter = painterResource(R.drawable.vingadores_img),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop
//                )
//
//            }
//        }
//        androidx.compose.material3.Text(
//            text = stringResource(R.string.vingadores_ultimato),
//            fontWeight = FontWeight.ExtraBold,
//            fontSize = 18.sp,
//            color = Color.DarkGray,
//            textAlign = TextAlign.Left,
//            modifier = Modifier
//                .width(250.dp)
//                .padding(start = 10.dp),
//        )
//
//        androidx.compose.material3.Text(
//            text = stringResource(R.string.abril_de_2019),
//            fontWeight = FontWeight.Light,
//            fontSize = 10.sp,
//            textAlign = TextAlign.Left,
//            color = Color.DarkGray,
//            modifier = Modifier
//                .padding(start = 10.dp)
//                .width(100.dp),
//        )
//
//
//
//    }
//}
//
