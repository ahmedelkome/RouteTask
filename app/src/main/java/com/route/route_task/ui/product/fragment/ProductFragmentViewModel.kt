package com.route.route_task.ui.product.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        try {
            loadingLiveData.value = true
            viewModelScope.launch {
                val listOfProduct = getProductUseCase.getALlProduct()
                prodcutListLiveData.postValue(listOfProduct)
                loadingLiveData.value = false
            }
        } catch (e: Exception) {
            loadingLiveData.value = false
            errorMessage.value = ViewMessage(
                title = "Error",
                message = e.localizedMessage,
                posTitle = "OK",
                navTitle = "Cancel"
            )
        }
    }
}