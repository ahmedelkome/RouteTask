package com.route.domain.contract

import com.route.domain.models.Product

interface ProductRepository {

    suspend fun getALlProduct(): List<Product>
}