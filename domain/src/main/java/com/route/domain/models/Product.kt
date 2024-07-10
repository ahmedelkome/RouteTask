package com.route.domain.models


data class Product(
	val images: List<String?>? = null,
	val thumbnail: String? = null,
	val minimumOrderQuantity: Int? = null,
	val rating: Double? = null,
	val returnPolicy: String? = null,
	val description: String? = null,
	val weight: Int? = null,
	val warrantyInformation: String? = null,
	val title: String? = null,
	val tags: List<String?>? = null,
	val discountPercentage: Double? = null,
	val reviews: List<ReviewsItem?>? = null,
	val price: Double? = null,
	val meta: Meta? = null,
	val shippingInformation: String? = null,
	val id: Int? = null,
	val availabilityStatus: String? = null,
	val category: String? = null,
	val stock: Int? = null,
	val sku: String? = null,
	val brand: String? = null,
	val dimensions: Dimensions? = null
)
