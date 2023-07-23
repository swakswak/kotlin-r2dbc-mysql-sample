package com.example.kotlinr2dbcmysql.api

data class TodoItemDto(
    val id: Long?,
    val text: String,
    val done: Boolean = false
)
