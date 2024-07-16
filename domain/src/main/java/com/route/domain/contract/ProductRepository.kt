package com.route.domain.contract

import com.route.domain.common.ResultWrapper
import com.route.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getALlProduct(): Flow<ResultWrapper<List<Product>>>
}