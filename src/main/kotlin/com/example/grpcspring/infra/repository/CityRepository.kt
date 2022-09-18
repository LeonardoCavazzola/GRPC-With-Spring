package com.example.grpcspring.infra.repository

import com.example.grpcspring.domain.City
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : ReactiveMongoRepository<City, String>
