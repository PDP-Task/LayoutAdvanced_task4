package com.example.layoutadvancedrecycleitemclick_task4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layoutadvancedrecycleitemclick_task4.R
import com.example.layoutadvancedrecycleitemclick_task4.User
import kotlinx.android.synthetic.main.item_list.view.*

class Adapter(
    var context: Context,
    private val itemList: ArrayList<User>,
    var onMyItemClickListener: OnMyItemClickListener
) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun itemInitialized(user: User) {
            itemView.tv_name.text = user.name
            itemView.tv_age.text = user.age
            itemView.setOnClickListener {
                onMyItemClickListener.myItemClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(myItemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemInitialized(itemList[position])
    }

    override fun getItemCount() = itemList.size

    interface OnMyItemClickListener {
        fun myItemClick(user: User)
    }
}
