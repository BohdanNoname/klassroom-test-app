package ua.nedash.klassroom.second_task.api.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostDto(
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("page")
    val page: String?,
    @SerializedName("posts")
    val posts: List<Post>
) : Parcelable {
    @Parcelize
    data class Post(
        @SerializedName("id")
        val id: Long?,
        @SerializedName("user_name")
        val userName: String?,
        @SerializedName("user_id")
        val userId: String?,
        @SerializedName("user_pic")
        val userPic: String?,
        @SerializedName("message")
        val message: String?,
        @SerializedName("photo")
        val photo: String?,
        @SerializedName("date")
        val date: String?
    ) : Parcelable
}