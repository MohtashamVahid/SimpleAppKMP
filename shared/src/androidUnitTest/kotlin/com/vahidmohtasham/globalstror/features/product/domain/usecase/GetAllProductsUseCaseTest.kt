package com.vahidmohtasham.globalstror.features.product.domain.usecase

import com.vahidmohtasham.globalstror.features.product.domain.model.Product
import com.vahidmohtasham.globalstror.features.product.domain.repository.ProductRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class GetAllProductsUseCaseTest {

    private val repository = mockk<ProductRepository>()

    private val useCase = GetAllProductsUseCase(repository)

    @Test
    fun `invoke should return list of products`() = runBlocking {

        val products = listOf(
            Product(1, "Test Product", 10.0, "Description", "ImageUrl")
        )

        coEvery { repository.getAllProducts() } returns products

        val result = useCase()

        assertEquals(products, result)
    }
}
