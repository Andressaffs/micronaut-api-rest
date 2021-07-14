package br.com.andressa.repository


import br.com.andressa.model.Todo
import java.util.*
import javax.inject.Singleton

@Singleton
interface TodoRepository {

    fun getCql(todo: Todo): List<Todo>
    fun getByIdCql(id: UUID): Todo?
    fun saveCql(todo: Todo): Todo
    fun updateCql (id: UUID,todo: Todo): Todo
    fun deleteCql(id: UUID)

}