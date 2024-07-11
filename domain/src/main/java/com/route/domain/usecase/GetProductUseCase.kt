package com.route.domain.usecase

import com.route.domain.contract.ProductRepository
import com.route.domain.models.Product
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend fun getALlProduct(): List<Product> {
        return productRepository.getALlProduct()
    }
}