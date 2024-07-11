package com.route.data.datasource


import com.route.data.contract.ProductOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductOnlineDataSourceModule() {

    @Binds
    abstract fun bindProductOnlineDataSource(
        productOnlineDataSourceImpl: ProductOnlineDataSourceImpl
    ): ProductOnlineDataSource
}