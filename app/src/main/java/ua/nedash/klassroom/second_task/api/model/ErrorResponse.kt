package ua.nedash.klassroom.second_task.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorResponse(
    @SerializedName("errors")
    val errors: List<String>
) : Parcelable