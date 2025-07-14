package com.vahidmohtasham.globalstror.features.product.domain.usecase

import com.vahidmohtasham.globalstror.features.product.domain.model.Product
import com.vahidmohtasham.globalstror.features.product.domain.repository.ProductRepository

class GetAllProductsUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> = repository.getAllProducts()
}
