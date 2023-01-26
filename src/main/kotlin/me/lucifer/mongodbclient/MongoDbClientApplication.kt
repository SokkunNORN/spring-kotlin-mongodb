package me.lucifer.mongodbclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongoDbClientApplication

fun main(args: Array<String>) {
	runApplication<MongoDbClientApplication>(*args)
}
