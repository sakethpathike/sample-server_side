package com.saketh.sample.clientStuff

import com.mongodb.client.MongoCollection
import io.github.cdimascio.dotenv.dotenv
import org.bson.Document
import org.litote.kmongo.KMongo

fun mongoClient(): MongoCollection<Document> {
    return KMongo.createClient("mongodb+srv://${envData("USER_NAME")}:${envData("PASSWORD")}@cluster0.2wr7r7n.mongodb.net/?retryWrites=true&w=majority")
        .getDatabase(envData("DATABASE_NAME").toString())
        .getCollection(envData("COLLECTION_NAME").toString())
}

fun envData(variableName:String): String? {
    return System.getenv(variableName)
}