package com.saketh.sample.songDetails

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.aggregate
import org.litote.kmongo.json

fun Routing.randomSong() {
    get("/randomSong") {
        val client= KMongo.createClient("mongodb+srv://${System.getenv("USER_NAME")}:${System.getenv("PASSWORD")}@cluster0.2wr7r7n.mongodb.net/?retryWrites=true&w=majority")
        val clientResponse  = client.getDatabase(System.getenv("DATABASE_NAME")).getCollection(System.getenv("COLLECTION_NAME"))
                .aggregate<SongIndex>("""{${MongoOperator.sample}:{size:1}}""").toList().json
        call.respond(clientResponse).also {
            client.close()
        }
    }
}