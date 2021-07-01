package br.com.andressa.service

import br.com.andressa.model.Todo
import br.com.andressa.repository.TodoRepository
import io.micronaut.http.HttpResponse
import javax.inject.Singleton

@Singleton
class TodoServiceImpl (private val todoRepository: TodoRepository): TodoService {

    override fun getTodos(): List<Todo> {
        return this.todoRepository.findAll()
    }

    override fun getByIdTodo(id: Long): Todo {
        return this.todoRepository.findById(id).orElse(null)
    }

    override fun addTodo(todo: Todo): Todo {
        return this.todoRepository.save(todo)
    }

    override fun updateTodo(id: Long, todo: Todo) {
        if (!this.todoRepository.existsById(id)){
            return print("404 - Not Found")
        } else
            todoRepository.update(todo)
    }

    override fun deleteTodo(id: Long) {
        if (!this.todoRepository.existsById(id)){
            return print("404 - Not Found")
        } else
            todoRepository.deleteById(id)
    }

}