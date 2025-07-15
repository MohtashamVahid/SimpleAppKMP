package com.vahidmohtasham.globalstror.features.product.domain.model

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String,
    val rating: Rating? = null
)

data class Rating(
    val rate: Double,
    val count: Int
)
