package br.com.andressa.repository

import br.com.andressa.model.Todo
import java.util.*
import javax.inject.Singleton
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement

@Singleton
class ToDoRepositoryImpl(private val cqlSession: CqlSession) : TodoRepository {

    override fun getCql(todo: Todo): List<Todo> {
        val all = cqlSession.execute(SimpleStatement.newInstance("SELECT*FROM todo.Todo"))
        return all.map {
            Todo(
                    it.getUuid("id"),
                    it.getString("date")!!,
                    it.getString("description")!!,
                    it.getBoolean("done")
            )
        }.toList()

    }

    override fun getByIdCql(id: UUID): Todo? {
        val result = cqlSession.execute(SimpleStatement.newInstance("SELECT*FROM todo.Todo WHERE id=?"))
        return result.map { todo ->
            Todo(
                    todo.getUuid("id")!!,
                    todo.getString("date")!!,
                    todo.getString("description")!!,
                    todo.getBoolean("done")!!
            )
        }.firstOrNull()

    }

    override fun saveCql(todo: Todo): Todo {
        cqlSession.execute(
                SimpleStatement.newInstance(
                        "INSERT INTO todo.Todo(id, date, description, done) values (?,?,?,?)",
                        UUID.randomUUID(),
                        todo.date,
                        todo.description,
                        todo.done
                )
        )
        return todo
    }

    override fun updateCql(id: UUID, todo: Todo): Todo {
        cqlSession.execute(
                SimpleStatement.newInstance("UPDATE todo.Todo SET date=?, description=?, done=? WHERE id=?",

                        todo.date,
                        todo.description,
                        todo.done,
                        id

                )
        )
        return todo
    }

    override fun deleteCql(id: UUID) {
        cqlSession.execute(
                SimpleStatement.newInstance("DELETE FROM todo.Todo WHERE id=?",
                        id
                )
        )
    }
}