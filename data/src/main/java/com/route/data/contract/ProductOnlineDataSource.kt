package com.route.data.contract

import com.route.domain.models.Product


interface ProductOnlineDataSource {
    suspend fun getAllProduct():List<Product>
}