package com.example.grpcspring

import io.grpc.BindableService
import io.grpc.ServerBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@Configuration
class Netty {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun startNetty(adapters: List<BindableService>, @Value("\${server.port}") port: String) =
        CommandLineRunner {
            ServerBuilder.forPort(port.toInt())
                .apply { adapters.forEach { addService(it) } }
                .build()
                .start()
                .also { logger.info("Netty initialized with port(s): $port (http)") }
                .awaitTermination()
        }
}


