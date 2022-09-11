package com.example.grpcspring.adapter.extension

import com.example.grpcspring.adapter.grpc.CityRequest
import com.example.grpcspring.adapter.grpc.CityResponse
import com.example.grpcspring.domain.City

fun CityRequest.toEntity(): City = City(
    name = name,
    ibgeCode = ibgeCode
)

fun City.toResponse(): CityResponse = CityResponse.newBuilder().also {
    it.id = id!!
    it.name = name
    it.ibgeCode = ibgeCode
}.build()
