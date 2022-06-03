package com.saketh.sample

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.mainPage(){
    get("/"){
      call.respond("Meep!")
    }
}