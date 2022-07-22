package com.saketh.sample

import com.saketh.sample.songDetails.*
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }
    routing {
        mainPage()
        randomSong()
        albums()
        search()
        songSearch()
        albumSearch()
        unreleased()
    }
}