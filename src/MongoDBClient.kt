package com.saketh.sample

import com.mongodb.client.MongoCollection
import org.bson.Document
import org.litote.kmongo.KMongo

fun mongoClient(): MongoCollection<Document> {
    return KMongo.createClient("mongodb+srv://$USER_NAME:$PASSWORD@cluster0.2wr7r7n.mongodb.net/?retryWrites=true&w=majority")
        .getDatabase(DATABASE_NAME)
        .getCollection(COLLECTION_NAME)
}