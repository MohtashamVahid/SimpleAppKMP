package com.vahidmohtasham.globalstror.features.product.data.remote


import kotlinx.serialization.Serializable
import com.vahidmohtasham.globalstror.features.product.domain.model.Product
import com.vahidmohtasham.globalstror.features.product.domain.model.Rating

@Serializable
data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingDto
) {
    fun toDomain(): Product {
        return Product(
            id = id,
            title = title,
            price = price,
            description = description,
            image = image,
            rating = Rating(rating.rate, rating.count)
        )
    }

}

@Serializable
data class RatingDto(
    val rate: Double,
    val count: Int
)
