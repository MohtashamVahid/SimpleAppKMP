package com.vahidmohtasham.globalstror.features.product.data.remote.repository

import com.vahidmohtasham.globalstror.features.product.data.remote.ProductRemoteDataSource
import com.vahidmohtasham.globalstror.features.product.domain.model.Product
import com.vahidmohtasham.globalstror.features.product.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val remoteDataSource: ProductRemoteDataSource
) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> {
        return remoteDataSource.fetchProducts()
    }
}
