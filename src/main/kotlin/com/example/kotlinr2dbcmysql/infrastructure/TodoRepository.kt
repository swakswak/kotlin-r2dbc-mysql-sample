package com.example.kotlinr2dbcmysql.infrastructure

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

@Table("todo_items")
data class TodoEntity(
    @Id
    val id: Long?,
    val text: String,
    val done: Boolean = false
)

interface TodoRepository : CoroutineCrudRepository<TodoEntity, Long>