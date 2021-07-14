package br.com.andressa.service

import br.com.andressa.model.Todo
import br.com.andressa.repository.TodoRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class TodoServiceImpl (private val todoRepository: TodoRepository): TodoService {


    override fun getTodos(): List<Todo> {
        return this.todoRepository.getCql(Todo())
    }

    override fun getByIdTodo(id: UUID): Todo? {
        return this.todoRepository.getByIdCql(id)
    }

    override fun addTodo(todo: Todo): Todo {
        return this.todoRepository.saveCql(todo)
    }

    override fun updateTodo(id: UUID, todo: Todo): Todo {
        return this.todoRepository.updateCql(id, todo)
    }

    override fun deleteTodo(id: UUID) {
        return this.todoRepository.deleteCql(id)
    }

}