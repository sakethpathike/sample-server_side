package com.saketh.sample.songDetails

import com.mongodb.client.MongoClient
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.find
import org.litote.kmongo.json

fun Routing.albums() {
    get("/albums/{name}") {
        val client: MongoClient =
            KMongo.createClient("mongodb+srv://${System.getenv("USER_NAME")}:${System.getenv("PASSWORD")}@cluster0.2wr7r7n.mongodb.net/?retryWrites=true&w=majority")
        val clientResponse =
            client.getDatabase(System.getenv("DATABASE_NAME")).getCollection(System.getenv("COLLECTION_NAME"))
        if (call.parameters["name"] == "amdgmaaf" || call.parameters["name"] == "1") {
            call.respond(HttpStatusCode.OK,
                clientResponse.find("""{albumName:"All My Demons Greeting Me As A Friend"}""").toList().json.also {
                    client.close()
                })
        } else if (call.parameters["name"] == "ioadk" || call.parameters["name"] == "2" || call.parameters["name"] == "step1") {
            call.respond(HttpStatusCode.OK,
                clientResponse.find("""{albumName:"Infections Of A Different Kind – Step 1"}""").toList().json.also {
                    client.close()
                })

        } else if (call.parameters["name"] == "adkoh" || call.parameters["name"] == "step2" || call.parameters["name"] == "3") {
            call.respond(HttpStatusCode.OK,
                clientResponse.find("""{albumName:"A Different Kind Of Human – Step 2"}""").toList().json.also {
                    client.close()
                })
        } else if (call.parameters["name"] == "tgwct" || call.parameters["name"] == "4") {
            call.respond(HttpStatusCode.OK,
                clientResponse.find("""{albumName:"The Gods We Can Touch"}""").toList().json.also {
                    client.close()
                })
        } else {
            call.respond(
                HttpStatusCode.NotFound,
                "Meep! Please Recheck The Spelling Of The Album You Are Searching For\uD83E\uDDD0"
            )
        }
    }
}