package com.example.hoabhjetpack.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hoabhjetpack.R
import com.example.hoabhjetpack.model.StaggeredGridItem
import com.example.hoabhjetpack.component.TodoItem

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
                painterRes = R.drawable.bg_1,
                widthIcon = 0.dp,
                heightIcon = 0.dp,
                colorText = Color.Black
            ),
            StaggeredGridItem(
                icon = R.drawable.timesquare, // Replace with your drawable resource ID
                title = "Pending",
                content = "15 Task",
                height = 120,
                painterRes = R.drawable.bg_2,
                widthIcon = 30.dp,
                heightIcon = 30.dp,
                colorText = Color.White
            ),
            StaggeredGridItem(
                icon = R.drawable.folder, // Replace with your drawable resource ID
                title = "On Going",
                content = "67 Task",
                height = 160,
                painterRes = R.drawable.bg_4,
                widthIcon = 0.dp,
                heightIcon = 0.dp,
                colorText = Color.Black
            ),
            StaggeredGridItem(
                icon = R.drawable.closesquare, // Replace with your drawable resource ID
                title = "Canceled",
                content = "15 Task",
                height = 120,
                painterRes = R.drawable.bg_3,
                widthIcon = 30.dp,
                heightIcon = 30.dp,
                colorText = Color.White
            ),
        )
    }

}