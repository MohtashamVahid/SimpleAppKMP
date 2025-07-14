package com.vahidmohtasham.globalstror.features.product.data.remote

import com.vahidmohtasham.globalstror.features.product.domain.model.Product
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String
) {
    fun toDomain(): Product = Product(id, title, price, description, image)
}
