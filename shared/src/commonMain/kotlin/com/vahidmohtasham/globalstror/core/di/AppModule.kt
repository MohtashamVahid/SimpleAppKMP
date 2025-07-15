package com.vahidmohtasham.globalstror.core.di

import com.vahidmohtasham.globalstror.core.network.KtorClientFactory
import com.vahidmohtasham.globalstror.core.network.ProductApiImpl
import com.vahidmohtasham.globalstror.features.product.data.remote.ProductApi
import com.vahidmohtasham.globalstror.features.product.data.remote.ProductRemoteDataSource
import com.vahidmohtasham.globalstror.features.product.data.remote.repository.ProductRepositoryImpl
import com.vahidmohtasham.globalstror.features.product.domain.repository.ProductRepository
import com.vahidmohtasham.globalstror.features.product.domain.usecase.GetAllProductsUseCase
 import org.koin.core.module.Module
import org.koin.dsl.module


// shared/src/commonMain/di/SharedModule.kt
val sharedModule = module {
   single { KtorClientFactory().create() }
   single<ProductApi> { ProductApiImpl(get()) }
   single { ProductRemoteDataSource(get()) }
   single<ProductRepository> { ProductRepositoryImpl(get()) }

   single { GetAllProductsUseCase(get()) }

}

