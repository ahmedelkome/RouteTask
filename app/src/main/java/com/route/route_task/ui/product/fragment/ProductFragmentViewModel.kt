package com.route.route_task.ui.product.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.common.ResultWrapper
import com.route.domain.models.Product
import com.route.domain.usecase.GetProductUseCase
import com.route.route_task.ui.models.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductFragmentViewModel @Inject
constructor(
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {
    var loadingLiveData = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<ViewMessage>()
    var prodcutListLiveData = MutableLiveData<List<Product>>()
    fun getAllProducts() {
        loadingLiveData.value = true
        viewModelScope.launch {
            val result = getProductUseCase.getALlProduct()
            when (result) {
                is ResultWrapper.Failure -> {
                    loadingLiveData.value = false
                    errorMessage.value = ViewMessage(
                        "Error", message = result.e.localizedMessage
                    )
                }

                ResultWrapper.Loading -> {
                    loadingLiveData.value = true
                }

                is ResultWrapper.Success -> {
                    prodcutListLiveData.value = result.data
                    loadingLiveData.value = false
                }
            }
        }
    }
}