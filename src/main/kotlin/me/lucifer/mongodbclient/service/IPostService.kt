package me.lucifer.mongodbclient.service

import com.mongodb.client.result.DeleteResult
import me.lucifer.mongodbclient.model.Post
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IPostService {
    fun findAll (): Flux<Post>
    fun findById(id: String): Mono<Post>
    fun save (request: Post): Mono<Post>
    fun delete(id: String): Mono<Void>
}