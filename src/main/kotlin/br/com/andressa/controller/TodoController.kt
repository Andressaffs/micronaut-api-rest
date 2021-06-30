package br.com.andressa.controller

import br.com.andressa.model.Todo
import br.com.andressa.repository.TodoRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*


@Controller ("/todos")
class TodoController(private val todoRepository: TodoRepository) {

    @Get
    fun getTodos(): HttpResponse<List<Todo>> {
        return HttpResponse.ok(todoRepository.findAll())
    }

    @Get ("/{id}")
    fun getByIdTodo(@PathVariable("id") id: Long): HttpResponse<Todo> {
        return HttpResponse.ok(todoRepository.findById(id).orElse(null))
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