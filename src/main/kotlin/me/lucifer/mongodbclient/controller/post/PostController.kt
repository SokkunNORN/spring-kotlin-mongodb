package me.lucifer.mongodbclient.controller.post

import me.lucifer.mongodbclient.model.Post
import me.lucifer.mongodbclient.service.IPostService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/post")
class PostController(
    private val service: IPostService
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun findAll () = service.findAll()

    @PostMapping
    fun save (@RequestBody request: Post): Mono<Post> {
        return service.save(request)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: String) = service.delete(id)
}