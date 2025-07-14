package com.vahidmohtasham.globalstror.features.product.domain.repository

import com.vahidmohtasham.globalstror.features.product.domain.model.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
}
