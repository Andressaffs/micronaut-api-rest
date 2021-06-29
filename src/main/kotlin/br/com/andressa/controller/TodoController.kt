package br.com.andressa.controller

import br.com.andressa.model.Todo
import br.com.andressa.repository.TodoRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.inject.Inject

@Controller ("/todos")
class TodoController(private val todoRepository: TodoRepository) {

    @Get
    fun getTodos(): List<Todo> {
        return todoRepository.findAll()
    }

    @Post
    fun addTodo (todo: Todo): Todo {
        return todoRepository.save(todo)
    }
}