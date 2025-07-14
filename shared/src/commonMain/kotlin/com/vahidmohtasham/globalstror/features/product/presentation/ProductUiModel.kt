package com.vahidmohtasham.globalstror.features.product.presentation

import com.vahidmohtasham.globalstror.features.product.domain.model.Product

data class ProductUiModel(
    val id: Int,
    val title: String,
    val price: String,
    val image: String
)

fun Product.toUiModel(): ProductUiModel =
    ProductUiModel(id, title, "$price $", image)
