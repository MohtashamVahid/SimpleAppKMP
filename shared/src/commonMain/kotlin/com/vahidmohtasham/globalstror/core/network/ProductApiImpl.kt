package com.vahidmohtasham.globalstror.core.network

import com.vahidmohtasham.globalstror.features.product.data.remote.ProductApi
import com.vahidmohtasham.globalstror.features.product.data.remote.ProductDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class ProductApiImpl(
    private val httpClient: HttpClient
) : ProductApi {
    override suspend fun getAllProducts(): List<ProductDto> {
        val response: HttpResponse = httpClient.get("https://fakestoreapi.com/products")
        return response.body()
    }
}
