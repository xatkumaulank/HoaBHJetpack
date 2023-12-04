package com.example.hoabhjetpack.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hoabhjetpack.R
import com.example.hoabhjetpack.navigation.Screen

@Composable
fun SplashScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
            )

            Text(
                text = stringResource(id = R.string.app_name),
                color = colorResource(id = R.color.base_color), // Set the correct color
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(
                    Font(R.font.hindsiliguriregular, FontWeight.Normal),
                ),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )

            Text(
                text = stringResource(id = R.string.plan_what_you),
                color = Color.Gray, // Set the correct color
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.hindsiliguriregular, FontWeight.Normal),
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(56.dp)
                    .background(
                        color = colorResource(id = R.color.base_color),
                        shape = RoundedCornerShape(14.dp) // Set the corner radius as needed
                    )
                    .clickable {
                        navController.navigate(Screen.LoginScreen.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = Color.White, // Set the correct color
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(
                        Font(R.font.hindsiliguriregular, FontWeight.Normal),
                    )
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 60.dp)
                    .height(56.dp)
                    .background(Color.White)
                    .clickable {
                        navController.navigate(Screen.SignupScreen.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.signup),
                    color = colorResource(id = R.color.base_color_text),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(
                        Font(R.font.hindsiliguriregular, FontWeight.Normal),
                    )
                )
            }
        }
    }

}

@Preview
@Composable
fun SplashScreenPreview() = SplashScreen(NavController(LocalContext.current))