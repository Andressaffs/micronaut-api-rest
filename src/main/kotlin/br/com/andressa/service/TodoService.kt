package br.com.andressa.service

import br.com.andressa.model.Todo

interface TodoService {

    fun getTodos(): List<Todo>
    fun getByIdTodo(id: Long): Todo
    fun addTodo(todo: Todo): Todo
    fun updateTodo(id: Long,todo: Todo)
    fun deleteTodo(id: Long)

}