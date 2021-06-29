package br.com.andressa.controller

import br.com.andressa.model.Todo
import br.com.andressa.repository.TodoRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import javax.inject.Inject
import javax.validation.Valid

@Controller ("/todos")
class TodoController(private val todoRepository: TodoRepository) {

    @Get
    fun getTodos(): List<Todo> {
        return todoRepository.findAll()
    }

    @Post
    fun addTodo (todo: Todo): HttpResponse<Todo> {
       return HttpResponse.created(todoRepository.save(todo))
    }

    @Put ("/{id}")
    fun updateTodo(@PathVariable("id") id: Long, todo: Todo): HttpResponse<Todo> {
        return HttpResponse.ok(todoRepository.update(todo))
    }

    @Delete ("/{id}")
    fun deleteTodo (@PathVariable("id") id: Long): HttpResponse<Todo> {
        todoRepository.deleteById(id)
        return HttpResponse.noContent()
    }

}