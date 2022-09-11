package com.example.grpcspring.infra.repository

import com.example.grpcspring.domain.City
import kotlinx.coroutines.flow.Flow
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : JpaRepository<City, String>
