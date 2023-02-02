package me.lucifer.mongodbclient.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/webflux")
class TestWebFluxController {

    @GetMapping
    fun find (): Mono<List<String>> {
        val comment1 = Comment(
            "Comment to Web-flex"
        )
        val comment2 = Comment(
            "Hello, Web-flex"
        )
        val value = Mono.just(listOf("Comment to Web-flex", "Hello, Web-flex"))
        return value
    }

    @PostMapping
    fun save (@RequestBody request: Comment) = request
}

data class Comment(
    val text: String,
    val publishedAt: LocalDateTime? = LocalDateTime.now()
)