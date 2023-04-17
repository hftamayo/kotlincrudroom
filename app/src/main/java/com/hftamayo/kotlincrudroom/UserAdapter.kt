package com.hftamayo.kotlincrudroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import org.w3c.dom.Text

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewMolder>() {
    private var list = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewMolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item_user_view_holder, parent, false)

        return UserViewMolder(view)
    }

    override fun onBindViewHolder(holder: UserViewMolder, position: Int) {
        val user = list[position]
        holder.tvFirstName.text = user.firstName
        holder.tvLastName.text = user.lastName
    }

    override fun getItemCount() = list.size

    fun setData(data: List<User>){
        list.apply {
            clear()
            addAll(data)
        }
    }

    class UserViewMolder(itemView: View): ViewHolder(itemView){
        val tvFirstName: TextView = itemView.findViewById(R.id.tv_first_name)
        val tvLastName: TextView = itemView.findViewById(R.id.tv_last_name)

    }

}