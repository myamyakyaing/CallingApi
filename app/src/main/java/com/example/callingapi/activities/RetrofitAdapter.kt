package com.example.callingapi.activities

import android.content.Context
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.callingapi.R
import com.example.callingapi.model.Post

class RetrofitAdapter(private val onClick: (post: Post) -> Unit)
    : RecyclerView.Adapter<ContactViewHolder>() {
    var postList : List<Post> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.data_retrofit, parent, false)
        return ContactViewHolder(view, onClick = onClick)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.setData(postList[position])
//        holder.txt_Uid.text = postList.get(position).userId.toString()
//        holder.txt_id.text = postList.get(position).id.toString()
//        holder.txt_title.text = postList.get(position).title.toString()
//        holder.txt_body.text = postList.get(position).body.toString()
//        holder.itemView.setOnClickListener {
//            if (position == 0) {
//                var intent = Intent(context, SelectedIdActivity::class.java)
//                context.startActivity(intent)
//            }
//        }

    }
    fun setPostListItems(postList: List<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }
}