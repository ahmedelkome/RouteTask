package com.route.data.datasource

import com.route.data.api.WebService
import com.route.data.contract.ProductOnlineDataSource
import com.route.domain.models.Product
import javax.inject.Inject

class ProductOnlineDataSourceImpl @Inject constructor(
    private val webService: WebService
) : ProductOnlineDataSource {
    override suspend fun getAllProduct(): List<Product> {
        val productList = webService.getAllProducts().map {
            it.toProduct()
        }
        return try {
            productList
        } catch (e: Exception) {
            throw e
        }
    }

}