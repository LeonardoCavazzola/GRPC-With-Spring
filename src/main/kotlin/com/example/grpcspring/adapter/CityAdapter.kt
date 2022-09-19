package com.example.grpcspring.adapter

import com.example.grpcspring.adapter.extension.toEntity
import com.example.grpcspring.adapter.extension.toResponse
import com.example.grpcspring.adapter.grpc.CityAdapterGrpcKt
import com.example.grpcspring.adapter.grpc.CityRequest
import com.example.grpcspring.adapter.grpc.CityResponse
import com.example.grpcspring.infra.repository.CityRepository
import com.google.protobuf.Empty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Component

@Component
class CityAdapter(
    private val cityRepository: CityRepository
) : CityAdapterGrpcKt.CityAdapterCoroutineImplBase() {
    override suspend fun save(request: CityRequest): CityResponse = request.toEntity()
        .let { cityRepository.save(it) }
        .toResponse()

    override fun findAll(request: Empty): Flow<CityResponse> = cityRepository.findAll().map { it.toResponse() }
}
