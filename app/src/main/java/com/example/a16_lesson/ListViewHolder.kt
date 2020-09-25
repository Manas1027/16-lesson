package com.example.a16_lesson

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.tvTitle
    private val surname: TextView = itemView.tvDescripton

    fun populateModel(obyekt: User, position: Int, activity: MainActivity){
        name.text = obyekt.title
        surname.text = obyekt.description

        itemView.btnOptions.setOnClickListener{
            activity.onOptionsButtonClick(itemView.btnOptions, position)

        }
    }
}