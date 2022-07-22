package com.saketh.sample.songDetails

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.*

fun Routing.unreleased() {
    get("/unreleased") {
        val client =
            KMongo.createClient("mongodb+srv://${System.getenv("USER_NAME")}:${System.getenv("PASSWORD")}@cluster0.2wr7r7n.mongodb.net/?retryWrites=true&w=majority")
        val response =
            client.getDatabase(System.getenv("DATABASE_NAME")).getCollection(System.getenv("UNRELEASED_COLLECTION"))
        call.respond(response.find().toList().json).also { client.close() }
/*
        call.respond(response.find("""{songName:"${MongoOperator.regex}:/${call.request.queryParameters["search"]}/i"}""").toList().json).also { client.close()}
*/
    }
}