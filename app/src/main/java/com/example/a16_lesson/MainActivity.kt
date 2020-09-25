package com.example.a16_lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private val adap: ListAdapter = ListAdapter(this)
    private var san: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RV.adapter = adap
        RV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        RV.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData(1)
    }

    fun setData(count: Int){
        val models: MutableList<User> = mutableListOf()
        for (i in 0 until count) {
            val model = User()
            model.title = "Title ${i+1}"
            model.description = "Description ${i+1}"
            models.add(model)
        }
        adap.Data(models)
    }


    fun onOptionsButtonClick(view: View, position: Int){

        val optionsMenu = PopupMenu(this, view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options, optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener() {
            when(it.itemId){
                R.id.add -> {
                    adap.addUser(position+1)
                }
                R.id.delete -> {
                    adap.removeUser(position)
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }

}