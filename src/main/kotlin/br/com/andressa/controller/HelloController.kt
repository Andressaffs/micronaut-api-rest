package br.com.andressa.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloController {

    @Get
    fun hello(): String {
        return "hello world!"

    }

}