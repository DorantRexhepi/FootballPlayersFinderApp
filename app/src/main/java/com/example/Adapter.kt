package com.example.projekti1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class Adapter (private val context: Activity, private val arrayList: ArrayList<Players>) : ArrayAdapter<Players>(context,
    R.layout.activity_players,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item, null)

        val imageView : ImageView = view.findViewById(R.id.image)
        val name : TextView = view.findViewById(R.id.Emri)
        val surname : TextView = view.findViewById(R.id.Mbiemri)

        imageView.setImageResource(arrayList[position].image)
        name.text = arrayList[position].name
        surname.text = arrayList[position].surname

        return view
    }
}