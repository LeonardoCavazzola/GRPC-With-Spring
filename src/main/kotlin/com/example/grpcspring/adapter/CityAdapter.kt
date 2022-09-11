package com.example.grpcspring.adapter

import com.example.grpcspring.adapter.extension.toEntity
import com.example.grpcspring.adapter.extension.toResponse
import com.example.grpcspring.adapter.grpc.CityAdapterGrpcKt
import com.example.grpcspring.adapter.grpc.CityRequest
import com.example.grpcspring.adapter.grpc.CityResponse
import com.example.grpcspring.infra.repository.CityRepository
import org.springframework.stereotype.Component

@Component
class CityAdapter(
    private val cityRepository: CityRepository
) : CityAdapterGrpcKt.CityAdapterCoroutineImplBase() {

    override suspend fun save(request: CityRequest): CityResponse =
        request.toEntity()
            .let(cityRepository::save)
            .toResponse()
}
