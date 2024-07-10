package com.route.data.repos

import com.route.data.contract.ProductOnlineDataSource
import com.route.domain.contract.ProductRepository
import com.route.domain.models.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productOnlineDataSource: ProductOnlineDataSource
) : ProductRepository {
    override suspend fun getALlProduct(): List<Product> {
        return productOnlineDataSource.getAllProduct()
    }
}