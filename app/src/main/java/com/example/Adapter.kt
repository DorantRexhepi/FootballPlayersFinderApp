package com.example.projekti1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.example.Players
import java.util.*
import kotlin.collections.ArrayList

class Adapter(private val context: Activity, private var arrayList: ArrayList<Players>) :
    ArrayAdapter<Players>(context, R.layout.activity_players, arrayList), Filterable {

    private var filteredList: ArrayList<Players> = arrayList

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item, null)

        val imageView: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.Emri)
        val surname: TextView = view.findViewById(R.id.Mbiemri)

        imageView.setImageResource(filteredList[position].image)
        name.text = filteredList[position].name
        surname.text = filteredList[position].surname

        return view
    }

    override fun getCount(): Int {
        return filteredList.size
    }

    override fun getItem(position: Int): Players? {
        return filteredList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) {
                    filteredList = arrayList
                } else {
                    val filtered = ArrayList<Players>()
                    for (player in arrayList) {
                        // Kontrollo nëse emri ose mbiemri përputhet me tekstin e kërkuar
                        if (player.name.lowercase(Locale.getDefault()).contains(charString.lowercase(Locale.getDefault())) ||
                            player.surname.lowercase(Locale.getDefault()).contains(charString.lowercase(Locale.getDefault()))
                        ) {
                            filtered.add(player)
                        }
                    }
                    filteredList = filtered
                }
                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as ArrayList<Players>
                notifyDataSetChanged()
            }
        }
    }
}