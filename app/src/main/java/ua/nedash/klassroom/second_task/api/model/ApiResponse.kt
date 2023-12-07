package ua.nedash.klassroom.second_task.api.model

data class ApiResponse<T>(
    val data: T? = null,
    val error: String = ""
) : java.io.Serializable