package me.lucifer.mongodbclient.config.mongodb

import com.mongodb.reactivestreams.client.MongoClients
import me.lucifer.mongodbclient.model.Post
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
class MongoDBConfig: AbstractReactiveMongoConfiguration() {

    @Bean
    fun mongoClient ()= MongoClients.create("mongodb://fiu-user:fiu-password@localhost:27017/fiu-db?authSource=admin")

    @Bean
    override fun reactiveMongoTemplate(
        databaseFactory: ReactiveMongoDatabaseFactory,
        mongoConverter: MappingMongoConverter
    ): ReactiveMongoTemplate = ReactiveMongoTemplate(mongoClient(), databaseName)

    override fun getDatabaseName() = "fiu-db"

}