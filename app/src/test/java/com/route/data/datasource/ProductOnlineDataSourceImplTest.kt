package com.route.data.datasource

import com.route.data.api.WebService
import com.route.data.contract.ProductOnlineDataSource
import com.route.data.models.ProductResponse
import com.route.domain.common.ResultWrapper
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

//Arrange
//
//Act
//
//Assert

class ProductOnlineDataSourceImplTest {

    lateinit var productOnlineDataSource: ProductOnlineDataSource
    lateinit var webService: WebService

    @Before
    fun setUp() {
        webService = mockk<WebService>()
        productOnlineDataSource = ProductOnlineDataSourceImpl(webService)
    }

    @Test
    fun `getAllProducts returns success when webservice return data`() = runBlocking {
        val productResponse = ProductResponse(products = listOf())
        coEvery { webService.getAllProducts() } returns productResponse
        val result = productOnlineDataSource.getAllProduct()
        coVerify(atLeast = 1) { webService.getAllProducts() }
        val list = ResultWrapper.Success(result)
        assert(list is ResultWrapper.Success)
    }

    @Test
    fun `getAllProducts returns failure when webservice throw exception`() = runBlocking {

        val message = "test failed"

        coEvery { webService.getAllProducts() } throws Exception(message)

        val result = productOnlineDataSource.getAllProduct()

        coVerify(atLeast = 1) { webService.getAllProducts() }

        val error = (result as ResultWrapper.Failure).e
        val error_message = ResultWrapper.Failure(error)
        assertEquals(message, error_message.e.cause!!.localizedMessage)
    }
}