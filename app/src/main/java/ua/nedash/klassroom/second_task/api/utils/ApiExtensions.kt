package ua.nedash.klassroom.second_task.api.utils

import com.google.gson.Gson
import retrofit2.Response
import ua.nedash.klassroom.second_task.api.model.ApiResponse
import ua.nedash.klassroom.second_task.api.model.ErrorResponse
import java.net.UnknownHostException

suspend fun <T> makeApiRequest(call: suspend () -> Response<T>): ApiResponse<T> {
    return try {
        val response = call.invoke()
        val result = response.body()

        if (response.isSuccessful && result != null) {
            ApiResponse(data = result)
        } else {
            val errorBody = response.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)

            ApiResponse(error = errorResponse.errors[0])
        }
    } catch (e: Exception) {
        when (e) {
            is UnknownHostException ->
                ApiResponse(error = "Check your internet connection")

            is javax.net.ssl.SSLHandshakeException ->
                ApiResponse(error = "Check your date settings")

            else ->
                ApiResponse(error = "Something went wrong")
        }
    }
}
