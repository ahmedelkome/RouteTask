package com.route.data.safe_api

import android.util.Log
import com.route.domain.common.ResultWrapper

suspend fun <T> safeApi(apicall: suspend () -> ResultWrapper<T>): ResultWrapper<T> {
    return try {
        Log.e("TAG", "safeApi: ${apicall.invoke()}", )
        apicall.invoke()

    } catch (e: Exception) {
       return ResultWrapper.Failure(e)
    }


}