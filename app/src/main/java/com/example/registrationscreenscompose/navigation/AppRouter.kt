package com.example.registrationscreenscompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.registrationscreenscompose.Screens.LoginScreen
import com.example.registrationscreenscompose.Screens.SignUpScreen


sealed class Screen(val route:String){
    object SignUp:Screen(route = "signup_screen")
    object Login:Screen(route = "login_screen")

}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController =navController , startDestination = Screen.SignUp.route ){
        composable(
            route = Screen.SignUp.route
        ){
            SignUpScreen(navController)
        }
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navHostController = navController)
        }

    }
}