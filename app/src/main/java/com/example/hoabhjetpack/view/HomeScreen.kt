package com.example.hoabhjetpack.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hoabhjetpack.component.*
import com.example.hoabhjetpack.R


@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                HeadingTextComponent(value = "Hi, Steven")
                Spacer(modifier = Modifier.weight(1f))
                MyAvatar(res = R.drawable.img_avt)
            }
            H1TextComponent(value = "Let’s make this day productive")
            HeadingTextComponent(value = "My Task")

            StaggeredGridView()

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HeadingTextComponent(value = "Today Task")
                UnderLinedTextComponent(value = "View all")
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(30.dp))
            TodoItemList()

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() = HomeScreen(NavController(LocalContext.current))
