package com.route.data.api

import com.route.data.models.Product
import retrofit2.http.GET

interface WebService {

    @GET("/products")
    suspend fun getAllProducts(): List<Product>
}