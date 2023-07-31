package com.example.registrationscreenscompose.Components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registrationscreenscompose.R
import com.example.registrationscreenscompose.ui.theme.*


@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorText,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorText,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField(labelValue: String, painterResource: Painter) {
    val textValue = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .heightIn(40.dp),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorPrimary,
            cursorColor = colorPrimary,
            backgroundColor = BGCOLOR
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },

        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "Profile"
            )
        }
    )
}


@Composable
fun PasswordTextField(labelValue: String, painterResource: Painter) {

    val password = remember { mutableStateOf("") }
    val isPasswordVisible = remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .heightIn(40.dp),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorPrimary,
            cursorColor = colorPrimary,
            backgroundColor = BGCOLOR
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        },

        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "Profile"
            )
        },
        trailingIcon = {
            val iconImage =
                if (isPasswordVisible.value) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }

            val description = if (isPasswordVisible.value) {
                "Hide Password"
            } else "Show Password"

            IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (isPasswordVisible.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun CheckboxComponenet(textValue: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
            })

        ClickableTextComponent(value = textValue)
    }

}

@Composable
fun ClickableTextComponent(value: String) {
    val initialText = "By continuing you accept our"
    val privacyPolicyText = " Privacy Policy"
    val andText = " and "
    val termsAndCondition = "Terms of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = termsAndCondition, annotation = termsAndCondition)
            append(termsAndCondition)
        }
    }
    ClickableText(text = annotatedString, onClick = {})
}

@Composable
fun ButtonComponent(value: String, onClick:() -> Unit) {
    Button(
        onClick = { onClick()

            },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),

        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(colorSecondary, colorPrimary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }


}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorGray,
            thickness = 1.dp
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = "or",
            fontSize = 14.sp,
            color = colorText
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorGray,
            thickness = 1.dp
        )
    }
}

@Composable
fun ClickableLoginTextComponent(initial: String, secondText: String, onTextSelected: () -> Unit) {

    val annotatedString = buildAnnotatedString {
        append(initial)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = secondText, annotation = secondText)
            append(secondText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = {
            onTextSelected()
        }
    )
}

@Composable
fun UnderLineTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorGray,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}


@Preview

@Composable
fun preview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NormalTextComponent(value = "My Title")
        HeadingTextComponent(value = "Create an Account")
        PasswordTextField(labelValue = "Password", painterResource = painterResource(id = R.drawable.password))
    }

}


