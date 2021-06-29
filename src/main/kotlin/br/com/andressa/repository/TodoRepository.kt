package br.com.andressa.repository

import br.com.andressa.model.Todo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TodoRepository: JpaRepository <Todo, Long> {
}