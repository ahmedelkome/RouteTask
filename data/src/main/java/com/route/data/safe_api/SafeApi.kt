package com.route.data.safe_api

import com.route.domain.common.ResultWrapper

suspend fun <T> safeApi(apicall: suspend () -> T): T{
    return try {
        val response = apicall.invoke()
        return response
    } catch (e: Throwable) {
        throw e
    }


}