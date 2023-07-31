package com.example.registrationscreenscompose.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.registrationscreenscompose.Components.*
import com.example.registrationscreenscompose.R
import com.example.registrationscreenscompose.navigation.Screen

@Composable
fun LoginScreen(navHostController: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = "Login")

            Spacer(modifier = Modifier.height(20.dp))

            HeadingTextComponent(value = "Welcome Back")

            MyTextField(labelValue = "email", painterResource = painterResource(id = R.drawable.email))

            PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.password))

            Spacer(modifier = Modifier.height(40.dp))

            UnderLineTextComponent(value = "Forget your password?")

            Spacer(modifier = Modifier.height(40.dp))

            ButtonComponent(value = "Login") {

            }

            Spacer(modifier = Modifier.height(40.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(initial = "Don't have an account? ", secondText = "Register"){
                navHostController.navigate(Screen.SignUp.route)
            }
        }
    }

}

@Preview
@Composable
fun Preview() {
    LoginScreen(navHostController = rememberNavController())
}