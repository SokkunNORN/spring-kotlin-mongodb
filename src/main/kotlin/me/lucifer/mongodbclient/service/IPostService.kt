package me.lucifer.mongodbclient.service

import me.lucifer.mongodbclient.model.Post
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IPostService {
    fun findAll (): Flux<Post>
    fun save (): Mono<Post>
}