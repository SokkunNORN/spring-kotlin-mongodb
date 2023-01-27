package me.lucifer.mongodbclient.service.impl

import com.mongodb.client.result.DeleteResult
import me.lucifer.mongodbclient.model.Post
import me.lucifer.mongodbclient.service.IPostService
import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PostService(
    private val template: ReactiveMongoTemplate
): IPostService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun findAll(): Flux<Post> = template.findAll(Post::class.java)
    override fun findById(id: String): Mono<Post> {
        return template.findById(id, Post::class.java)
    }

    override fun save(request: Post) = template.save(request)

    override fun delete(id: String): Mono<DeleteResult> {
        return id.removeById()
    }

    private fun String.removeById(): Mono<DeleteResult> {
        return template.remove(Query.query(Criteria.where("id").`is`(this)), Post::class.java)
    }
}