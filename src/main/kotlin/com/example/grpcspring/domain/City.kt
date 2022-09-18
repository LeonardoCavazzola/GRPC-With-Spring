package com.example.grpcspring.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class City(
    val id: String? = null,
    val name: String,
    val ibgeCode: String,
)
