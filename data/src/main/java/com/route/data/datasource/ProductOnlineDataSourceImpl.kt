package com.route.data.datasource

import com.route.data.api.WebService
import com.route.data.contract.ProductOnlineDataSource
import com.route.data.safe_api.safeApi
import com.route.domain.common.ResultWrapper
import com.route.domain.models.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductOnlineDataSourceImpl @Inject constructor(
    private val webService: WebService
) : ProductOnlineDataSource {
    override suspend fun getAllProduct(): ResultWrapper<List<Product>> {
        val productList = webService.getAllProducts().products?.filterNotNull()!!.map {
            it.toProduct()
        }
        return safeApi {
            ResultWrapper.Success(productList)
        }
    }
}
