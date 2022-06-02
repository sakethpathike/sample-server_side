package com.saketh.sample.songDetails

import com.saketh.sample.clientStuff.mongoClient
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.find
import org.litote.kmongo.json

fun Routing.albums() {
    get("/albums/{name}") {
        if (call.parameters["name"] == "amdgmaaf" ||
            call.parameters["name"] == "1"
        ) {
            call.respond(
                HttpStatusCode.OK,
                mongoClient().find("""{albumName:"All My Demons Greeting Me As A Friend"}""").toList().json
            )
        } else if (
            call.parameters["name"] == "ioadk" ||
            call.parameters["name"] == "2" ||
            call.parameters["name"] == "step1"
        ) {

            call.respond(
                HttpStatusCode.OK,
                mongoClient().find("""{albumName:"Infections Of A Different Kind – Step 1"}""").toList().json
            )
        } else if (call.parameters["name"] == "adkoh" ||
            call.parameters["name"] == "step2" ||
            call.parameters["name"] == "3"
        ) {
            call.respond(
                HttpStatusCode.OK,
                mongoClient().find("""{albumName:"A Different Kind Of Human – Step 2"}""").toList().json
            )
        } else if (call.parameters["name"] == "tgwct" ||
            call.parameters["name"] == "4"
        ) {
            call.respond(HttpStatusCode.OK, mongoClient().find("""{albumName:"The Gods We Can Touch"}""").toList().json)
        } else {
            call.respond(
                HttpStatusCode.NotFound,
                "Meep! Please Recheck The Spelling Of The Album You Are Searching For\uD83E\uDDD0"
            )
        }
    }
}