package com.saketh.sample.songDetails


import com.mongodb.client.MongoClient
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.MongoOperator
import org.litote.kmongo.find
import org.litote.kmongo.json

fun Routing.search() {
      searchResults("/search/{searchName}",  pathParameter = "searchName", globalSearch = true)
}

fun Routing.songSearch() {
    searchResults("/song/{songName}", dbSearchField = "songName", pathParameter = "songName")
}

fun Routing.albumSearch() {
    searchResults("/album/{albumName}", dbSearchField = "albumName", pathParameter = "albumName")
}

fun Routing.searchResults(
    pathWithParameter: String,
    dbSearchField: String="songName",
    pathParameter: String,
    globalSearch: Boolean = false
) {

    get(pathWithParameter) {
        val parameterName = call.parameters[pathParameter].toString()
        val client: MongoClient =
            KMongo.createClient("mongodb+srv://${System.getenv("USER_NAME")}:${System.getenv("PASSWORD")}@cluster0.2wr7r7n.mongodb.net/?retryWrites=true&w=majority")
        val clientResponse =
            client.getDatabase(System.getenv("DATABASE_NAME")).getCollection(System.getenv("COLLECTION_NAME"))
                .find("""{$dbSearchField:{${MongoOperator.regex}:/$parameterName/i}}""").toList().json
        val globalSearchResponse =
            client.getDatabase(System.getenv("DATABASE_NAME")).getCollection(System.getenv("COLLECTION_NAME")).find(
                """{${MongoOperator.or}:[{songName:{${MongoOperator.regex}:/$parameterName/i}},{albumName:{${MongoOperator.regex}:/$parameterName/i}}]}"""
            ).toList().json
        if (!globalSearch) {
            call.respond(clientResponse).also {
                client.close()
            }
        } else {
            call.respond(globalSearchResponse).also {
                client.close()
            }
        }
    }
}