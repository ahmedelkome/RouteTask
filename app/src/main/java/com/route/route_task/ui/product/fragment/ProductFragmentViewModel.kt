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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductFragmentViewModel @Inject
constructor(
    private val getProductUseCase: GetProductUseCase,

    ) : ViewModel() {
    var loadingLiveData = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<ViewMessage>()
    var prodcutListLiveData = MutableLiveData<List<Product>>()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    fun getAllProducts() {
        loadingLiveData.postValue(true)
        viewModelScope.launch(dispatcher) {
            getProductUseCase.getALlProduct().collect {
                when (it) {
                    is ResultWrapper.Failure -> {
                        loadingLiveData.postValue(false)
                        errorMessage.postValue(
                            ViewMessage(
                                title = "Error",
                                message = it.e.localizedMessage
                            )
                        )
                    }

                    ResultWrapper.Loading -> {
                        loadingLiveData.postValue(true)
                    }

                    is ResultWrapper.Success -> {
                        loadingLiveData.postValue(false)
                        prodcutListLiveData.postValue(it.data)
                    }
                }
            }
        }
    }
}

/* */