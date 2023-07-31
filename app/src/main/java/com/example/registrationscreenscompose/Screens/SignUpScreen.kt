package com.example.registrationscreenscompose.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.registrationscreenscompose.Components.*
import com.example.registrationscreenscompose.R
import com.example.registrationscreenscompose.navigation.Screen

@Composable
fun SignUpScreen(navHostController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),

        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = "Sign Up")

            Spacer(modifier = Modifier.height(20.dp))

            HeadingTextComponent(value = "Let's create an account")

            Spacer(modifier = Modifier.height(16.dp))

            MyTextField(
                labelValue = stringResource(id = R.string.first_name),
                painterResource(id = R.drawable.first_name)
            )

            MyTextField(
                labelValue = stringResource(id = R.string.last_name),
                painterResource(id = R.drawable.first_name)
            )

            MyTextField(
                labelValue = stringResource(id = R.string.email),
                painterResource(id = R.drawable.email)
            )

            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                painterResource(id = R.drawable.password)
            )

            CheckboxComponenet(textValue = "Continue with terms and conditions")

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(value = "Register"){
                Log.i("clicked", "ButtonComponent: Clicked")
                navHostController.navigate(Screen.Login.route)
            }

            DividerTextComponent()

            ClickableLoginTextComponent(initial = "Already have an account? ", secondText = "Login") {
                navHostController.navigate(Screen.Login.route)

            }
        }

    }
}