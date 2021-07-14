package br.com.andressa.controller

import br.com.andressa.model.Todo
import br.com.andressa.service.TodoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.*


@Controller ("/todos")
class TodoController(private val todoService: TodoService) {

    @Get
    fun getTodos(): HttpResponse<List<Todo>> {
        return HttpResponse.ok(todoService.getTodos())
    }

    @Get ("/{id}")
    fun getByIdTodo(@PathVariable("id") id: UUID): HttpResponse<Todo> {
        return HttpResponse.ok(this.todoService.getByIdTodo(id))
    }

    @Post
    fun addTodo (todo: Todo): HttpResponse<Todo> {
       return HttpResponse.created(this.todoService.addTodo(todo))
    }

    @Put ("/{id}")
    fun updateTodo(@PathVariable("id") id: UUID, todo: Todo): HttpResponse<Todo> {
        todoService.updateTodo(id,todo)
        return HttpResponse.ok(todo)
    }

    @Delete ("/{id}")
    fun deleteTodo (@PathVariable("id") id: UUID): HttpResponse<Todo> {
        todoService.deleteTodo(id)
        return HttpResponse.noContent()
    }

}