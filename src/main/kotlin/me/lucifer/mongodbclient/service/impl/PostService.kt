package me.lucifer.mongodbclient.service.impl

import me.lucifer.mongodbclient.model.Post
import me.lucifer.mongodbclient.service.IPostService
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PostService(
    private val template: ReactiveMongoTemplate
): IPostService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun findAll(): Flux<Post> {
        return template.findAll(Post::class.java)
    }

    override fun save(): Mono<Post> {
        val post = Post(
            title = "First post from spring kotlin with mongodb",
            description = "The first start spring kotlin with mongodb.",
            postImages = mutableListOf()
        )
        return template.save(post)
    }
}