package com.vahidmohtasham.globalstror.features.product.data.remote

import com.vahidmohtasham.globalstror.features.product.domain.model.Product

class ProductRemoteDataSource(
    private val api: ProductApi
) {
    suspend fun fetchProducts(): List<Product> {
        return api.getAllProducts().map { it.toDomain() }
    }
}
