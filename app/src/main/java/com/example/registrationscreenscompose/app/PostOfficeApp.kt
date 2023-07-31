package com.example.registrationscreenscompose.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.registrationscreenscompose.Screens.LoginScreen
import com.example.registrationscreenscompose.Screens.SignUpScreen
import com.example.registrationscreenscompose.navigation.Screen

@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White

    ) {
       /* Crossfade(targetState = AppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                else -> {
                    SignUpScreen()
                }
            }
        }

        SignUpScreen()*/
    }
}