package br.com.andressa.model

import io.micronaut.core.annotation.Introspected
import java.util.*


@Introspected
data class Todo(

    val id: UUID? = null,
    val date: String? = "",
    val description: String? ="",
    val done: Boolean = false
)
