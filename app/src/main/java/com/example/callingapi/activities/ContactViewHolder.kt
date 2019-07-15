package com.example.callingapi.activities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.callingapi.model.Post
import kotlinx.android.synthetic.main.data_retrofit.view.*

class ContactViewHolder(
    val view: View,
    private val onClick: (post: Post) -> Unit
) : RecyclerView.ViewHolder(view) {
    fun setData(post: Post) {
        view.apply {
            view.txtUserId.text = post.userId.toString()
            view.txtId.text = post.id.toString()
            view.txtTitle.text = post.title.toString()
            view.txtbody.text = post.body.toString()
        }
        view.setOnClickListener { onClick(post) }
    }
}