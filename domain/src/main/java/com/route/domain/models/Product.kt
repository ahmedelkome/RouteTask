package com.route.domain.models

data class Product(

    val images: List<String?>? = null,
    val rating: Double? = null,
    val description: String? = null,
    val title: String? = null,
    val discountPercentage: Double? = null,
    val price: Double? = null,
    )