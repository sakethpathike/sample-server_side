package com.saketh.sample.clientStuff

import com.mongodb.client.MongoCollection
import org.bson.Document
import org.litote.kmongo.KMongo

fun mongoClient(): MongoCollection<Document> {
    return KMongo.createClient("mongodb+srv://${System.getenv("USER_NAME")}:${System.getenv("PASSWORD")}@cluster0.2wr7r7n.mongodb.net/?retryWrites=true&w=majority")
        .getDatabase(System.getenv("DATABASE_NAME"))
        .getCollection(System.getenv("COLLECTION_NAME"))
}