package com.saketh.sample.songDetails

import com.saketh.sample.clientStuff.mongoClient
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.find
import org.litote.kmongo.json

fun Routing.search() {
    get("/search/{searchName}") {
        val searchName = call.parameters["searchName"].toString()
        val response = mongoClient().find(
            """{${MongoOperator.or}:[{songName:{${MongoOperator.regex}:/$searchName/i}},{albumName:{${MongoOperator.regex}:/$searchName/i}}]}"""
        ).toList().json
        try {
            call.respond(HttpStatusCode.OK, response)
        } catch (_: Exception) {
            call.respond(
                HttpStatusCode.NotFound,
                "Meep! Please Recheck The Spelling Of The Album/Song You Are Searching For\uD83E\uDDD0"
            )
        }
    }
}

fun Routing.songSearch() {
    get("/song/{songName}") {
        val songName = call.parameters["songName"].toString()
        val response = mongoClient().find("""{songName:{${MongoOperator.regex}:/$songName/i}}""").toList().json
        try {
            call.respond(HttpStatusCode.OK, response)
        } catch (e: Exception) {
            call.respond(
                HttpStatusCode.NotFound,
                "Meep! Please Recheck The Spelling Of The Song You Are Searching For\uD83E\uDDD0"
            )
        }
    }
}

fun Routing.albumSearch() {
    get("/album/{albumName}") {
        val albumName = call.parameters["albumName"].toString()
        val response = mongoClient().find("""{albumName:{${MongoOperator.regex}:/$albumName/i}}""").toList().json
        try {
            call.respond(HttpStatusCode.OK, response)
        } catch (e: Exception) {
            call.respond(
                HttpStatusCode.NotFound,
                "Meep! Please Recheck The Spelling Of The Album You Are Searching For\uD83E\uDDD0"
            )
        }
    }
}