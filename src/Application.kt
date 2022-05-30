package com.saketh.sample

import com.mongodb.client.MongoCollection
import com.saketh.sample.songDetails.*
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import org.bson.Document
import org.litote.kmongo.KMongo

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }
    routing {
        randomSong()
        albums()
        search()
        songSearch()
        albumSearch()
    }
}