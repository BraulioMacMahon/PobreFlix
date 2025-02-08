package com.example.pobreflix

sealed class Rota(val route: String) {
    object Welcome : Rota("welcome")
    object Login : Rota("login")
    object CreateAccount : Rota("create_account")
    object Home : Rota("home")
    object Search : Rota("search")
    object CardGrid : Rota("card_grid")
    object CardCarousel : Rota("card_carousel")
    object Detail : Rota("detail/{movieId}") { // Define um argumento na rota
        fun createRoute(movieId: Int) = "detail/$movieId" // Função para passar o ID
    }
}
