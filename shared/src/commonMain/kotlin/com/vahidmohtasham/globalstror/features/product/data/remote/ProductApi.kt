package com.vahidmohtasham.globalstror.features.product.data.remote

interface ProductApi {
    suspend fun getAllProducts(): List<ProductDto>
}
