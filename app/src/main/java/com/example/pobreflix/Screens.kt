package com.example.pobreflix

sealed class Screens(val screen: String) {
    data object Home: Screens("screens/home")
    data object Detail: Screens("screens/detail")
    data object Welcome: Screens("screens/welcome")
    data object Search: Screens("screens/search")
    data object Login: Screens("screens/login")
    data object CreateAcount: Screens("screens/createacount")
}