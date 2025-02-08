package com.example.pobreflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pobreflix.createacount.CreateUserAcount
import com.example.pobreflix.detail.Detail
import com.example.pobreflix.ui.theme.PobreFlixTheme
import com.example.pobreflix.login.Login
import com.example.pobreflix.search.Search
import com.example.pobreflix.welcome.Welcome

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            PobreFlixTheme() {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Rota.Welcome.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(Rota.Welcome.route) {
                            Welcome(login = { navController.navigate(Rota.Login.route) })
                        }

                        composable(Rota.Login.route) {
                            Login(
                                onNavigateToSignUp = { navController.navigate(Rota.CreateAccount.route) },
                                onLoginSuccess = { navController.navigate(Rota.Home.route) },
                                enterWithEnvited = { navController.navigate(Rota.Home.route) }
                            )
                        }

                        composable(Rota.CreateAccount.route) {
                            CreateUserAcount(
                                login = { navController.navigate(Rota.Login.route) },
                                onSignUpSuccess = { navController.navigate(Rota.Login.route) }
                            )
                        }

                        composable(Rota.Home.route) {
                            Home(
                                search = { navController.navigate(Rota.Search.route) },
                                detail = { movie ->
                                    movie.id?.let { id -> // Certifica que o ID não é nulo
                                        navController.navigate(Rota.Detail.createRoute(id))
                                    }
                                }
                            )
                        }


                        composable(
                            route = Rota.Detail.route,
                            arguments = listOf(navArgument("movieId") {
                                type = NavType.IntType
                            }) // Define o argumento como Int
                        ) { backStackEntry ->
                            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0 // Pega o ID
                            Detail(
                                goToBack = { navController.popBackStack() },
                                movieId = movieId,

                            )
                        }

                        composable(route = Rota.Search.route) {
                            Search(goToBack = { navController.popBackStack() },
                                goToDetail = { movie ->
                                    movie.id?.let { id -> // Certifica que o ID não é nulo
                                        navController.navigate(Rota.Detail.createRoute(id))
                                    }
                            }
                            )
                        }


                        composable(
                            route = Rota.CardGrid.route,
                            ) {
                            CardGred(
                                detail = { navController.navigate(Rota.Detail.route) },
                                movie = TODO()
                            )
                        }

                        composable(Rota.CardCarousel.route) {
                            CardModelCarrocel(
                                detail = { navController.navigate(Rota.Detail.route) },
                                movie = TODO()
                            )
                        }
                    }
                }
            }
        }
    }
}




