package com.route.data.safe_api

import com.route.domain.common.ResultWrapper

suspend fun <T> safeApi(apicall: suspend () -> ResultWrapper<T>): ResultWrapper<T> {
    return try {
        apicall.invoke()
    } catch (e: Exception) {
        return ResultWrapper.Failure(e)
    }
}