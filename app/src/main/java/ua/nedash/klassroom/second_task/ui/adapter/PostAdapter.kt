package ua.nedash.klassroom.second_task.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ua.nedash.klassroom.databinding.ItemPostBinding
import ua.nedash.klassroom.glideLoadMessageImage
import ua.nedash.klassroom.glideLoadUserImage
import ua.nedash.klassroom.second_task.api.model.PostDto

class PostAdapter :
    PagingDataAdapter<PostDto.Post, PostAdapter.PostViewHolder>(PostDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(getItem(position)!!)

    class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: PostDto.Post) {
            with(binding) {
                ivUser.glideLoadUserImage(post.userPic!!)

                post.photo.let {
                    if (!it.isNullOrEmpty()) {
                        ivMessagePhoto.visibility = View.VISIBLE
                        ivMessagePhoto.glideLoadMessageImage(it)
                    }
                }

                tvUsername.text = post.userName
                tvDate.text = post.date
                tvMessage.text = post.message
            }
        }

    }

    private object PostDiffCallback : DiffUtil.ItemCallback<PostDto.Post>() {
        override fun areItemsTheSame(oldItem: PostDto.Post, newItem: PostDto.Post): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PostDto.Post, newItem: PostDto.Post): Boolean =
            oldItem == newItem
    }
}