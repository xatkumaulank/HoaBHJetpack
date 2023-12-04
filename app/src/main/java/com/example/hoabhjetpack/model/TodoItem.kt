package com.example.hoabhjetpack.component

data class TodoItem (
    val title: String,
    val date: Long,
    val startTime: Long,
    val endTime: Long,
    val des: String,
    val status: Int,
    val type: String,
    val tag: String
)