package com.route.domain.usecase

import com.route.domain.common.ResultWrapper
import com.route.domain.contract.ProductRepository
import com.route.domain.models.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend fun getALlProduct(): ResultWrapper<List<Product>> {
        return productRepository.getALlProduct()
    }
}