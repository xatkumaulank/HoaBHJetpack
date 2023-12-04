package com.example.hoabhjetpack.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hoabhjetpack.R
import com.example.hoabhjetpack.component.*
import com.example.hoabhjetpack.navigation.Screen
import com.example.hoabhjetpack.component.*

@Composable
fun SignupScreen(navController: NavController){
    var useremail by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Spacer(modifier = Modifier.height(100.dp))

                HeadingTextComponent(value = stringResource(id = R.string.login))
                Spacer(modifier = Modifier.height(20.dp))

                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.username),
                    painterResource(id = R.drawable.message),
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.emailId),
                    painterResource = painterResource(id = R.drawable.lock),
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.ic_lock),
                )

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.create),
                    onButtonClicked = {
                        navController.navigate(Screen.HomeScreen.route)
                    },
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()
                AnotherOptionsLogin()

                Spacer(modifier = Modifier.weight(1f))
                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    navController.navigate(Screen.HomeScreen.route)
                })
            }

        }

    }


}