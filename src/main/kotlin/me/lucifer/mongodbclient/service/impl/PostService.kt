package me.lucifer.mongodbclient.service.impl

import me.lucifer.mongodbclient.model.Post
import me.lucifer.mongodbclient.repository.PostRepository
import me.lucifer.mongodbclient.service.IPostService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PostService(
    private val template: PostRepository
): IPostService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun findAll(): Flux<Post> = template.findAll()
    override fun findById(id: String): Mono<Post> {
        return template.findById(id)
    }

    override fun save(request: Post) = template.save(request)

    override fun delete(id: String): Mono<Void> {
        return template.deleteById(id)
    }
}