package com.saketh.sample.songDetails

import com.saketh.sample.mongoClient
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.aggregate
import org.litote.kmongo.json


fun Routing.randomSong() {
    get("/randomSong") {
        val randomSongFromDB =
            mongoClient().aggregate<SongIndex>("""{${MongoOperator.sample}:{size:1}}""").toList().json
        call.respond(HttpStatusCode.OK, randomSongFromDB)
    }
}
