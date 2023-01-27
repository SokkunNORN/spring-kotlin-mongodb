package me.lucifer.mongodbclient.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalTime

@Document(collection = "posts")
data class Post(
    @Id
    val id: String? = null,

    var title: String,

    var description: String,

    var postImages: MutableList<String> = mutableListOf(),

    val createdDate: LocalTime = LocalTime.now(),

    var updatedAt: LocalTime = LocalTime.now()
)
