package com.route.data.contract

import com.route.domain.models.Product
import kotlinx.coroutines.flow.Flow


interface ProductOnlineDataSource {
    suspend fun getAllProduct(): List<Product>
}