package me.lucifer.mongodbclient.repository

import me.lucifer.mongodbclient.model.Post
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : ReactiveMongoRepository<Post, String>