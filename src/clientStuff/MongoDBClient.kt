package com.saketh.sample.clientStuff

import com.mongodb.client.MongoCollection
import org.bson.Document
import org.litote.kmongo.KMongo

fun mongoClient(): MongoCollection<Document> {
    return KMongo.createClient("mongodb+srv://saketh:9ZHvOnEP9BhLYCr3@cluster0.2wr7r7n.mongodb.net/?retryWrites=true&w=majority")
        .getDatabase("allsongs")
        .getCollection("songDetails")
}