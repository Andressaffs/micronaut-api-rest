package br.com.andressa.model

import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.persistence.*


@Entity
@Introspected
data class Todo(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val date: String,

    @Column
    val description: String,

    @Column
    val done: Boolean
)
