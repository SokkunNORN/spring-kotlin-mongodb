package me.lucifer.mongodbclient.model

import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalTime

@Document(collection = "posts")
data class Post(
    @Id
    val id: String = "",

    var title: String,

    var description: String,

    var postImages: MutableList<String> = mutableListOf(),

    val createdDate: LocalTime = LocalTime.now(),

    var updatedAt: LocalTime = LocalTime.now()
)
