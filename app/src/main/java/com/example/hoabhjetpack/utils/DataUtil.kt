package com.example.hoabhjetpack.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hoabhjetpack.R
import com.example.hoabhjetpack.component.StaggeredGridItem
import com.example.hoabhjetpack.component.TodoItem
import com.example.hoabhjetpack.utils.Constants

object DataUtil {

    fun generateTodoList(): List<TodoItem> {
        return List(4) {
            TodoItem(
                title = "Cleaning Clothes",
                date = System.currentTimeMillis(),
                startTime =  System.currentTimeMillis(),
                endTime = System.currentTimeMillis() + 3600000,
                des = "Creating this month's work plan",
                status = Constants.TODO_INPROGESS,
                type = "Urgent",
                tag = "Home"
            )
        }

    }
    fun generateList(): List<StaggeredGridItem> {
        return listOf(
            StaggeredGridItem(
                icon = R.drawable.imac, // Replace with your drawable resource ID
                title = "Completed",
                content = "86 Task",
                height = 160,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF7DC8E7),
                        Color(0xB87DC8E7) // Using alpha for rgba(125, 200, 231, 0.69)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1f, 1f),

                    ),
                widthIcon = 0.dp,
                heightIcon = 0.dp,
                colorText = Color.Black
            ),
            StaggeredGridItem(
                icon = R.drawable.timesquare, // Replace with your drawable resource ID
                title = "Pending",
                content = "15 Task",
                height = 120,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF7D88E7),
                        Color(0xB97D88E7) // Using alpha for rgba(125, 136, 231, 0.74)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1f, 1f),
                ),
                widthIcon = 30.dp,
                heightIcon = 30.dp,
                colorText = Color.White
            ),
            StaggeredGridItem(
                icon = R.drawable.folder, // Replace with your drawable resource ID
                title = "On Going",
                content = "67 Task",
                height = 160,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF81E89E),
                        Color(0x5981E89E) // Using alpha for rgba(129, 232, 158, 0.35)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1f, 1f),
                ),
                widthIcon = 0.dp,
                heightIcon = 0.dp,
                colorText = Color.Black
            ),
            StaggeredGridItem(
                icon = R.drawable.closesquare, // Replace with your drawable resource ID
                title = "Canceled",
                content = "15 Task",
                height = 120,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFE77D7D),
                        Color(0xB8E77D7D) // Using alpha for rgba(231, 125, 125, 0.71)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1f, 1f),
                ),
                widthIcon = 30.dp,
                heightIcon = 30.dp,
                colorText = Color.White
            ),
        )
    }

}