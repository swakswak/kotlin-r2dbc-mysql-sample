package com.example.kotlinr2dbcmysql.api

import com.example.kotlinr2dbcmysql.infrastructure.TodoEntity
import com.example.kotlinr2dbcmysql.infrastructure.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.* // ktlint-disable no-wildcard-imports
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/todos")
class TodoController(private val todoRepository: TodoRepository) {

    @GetMapping
    suspend fun getAllTodos(): Flow<TodoItemDto> = todoRepository.findAll().map { it.toDto() }

    @GetMapping("/{id}")
    suspend fun getTodoById(@PathVariable id: Long): TodoItemDto {
        val entity = todoRepository.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found")
        return entity.toDto()
    }

    @PostMapping
    suspend fun createTodo(@RequestBody todoItemDto: TodoItemDto): TodoItemDto {
        val entity = TodoEntity(null, todoItemDto.text)
        val savedEntity = todoRepository.save(entity)
        return savedEntity.toDto()
    }

    @PutMapping("/{id}")
    suspend fun updateTodoStatus(@PathVariable id: Long, @RequestBody todoItemDto: TodoItemDto): TodoItemDto {
        val entity =
            todoRepository.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found")
        val updatedEntity = entity.copy(text = todoItemDto.text, done = todoItemDto.done)
        val savedEntity = todoRepository.save(updatedEntity)
        return savedEntity.toDto()
    }

    @DeleteMapping("/{id}")
    suspend fun deleteTodo(@PathVariable id: Long) {
        todoRepository.deleteById(id)
    }
}

fun TodoEntity.toDto() = TodoItemDto(id, text, done)
