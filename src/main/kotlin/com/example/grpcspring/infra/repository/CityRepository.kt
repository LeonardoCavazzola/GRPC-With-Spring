package com.example.grpcspring.infra.repository

import com.example.grpcspring.domain.City
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : CoroutineCrudRepository<City, String>
