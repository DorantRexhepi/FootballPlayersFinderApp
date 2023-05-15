package com.example.projekti1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projekti1.databinding.ActivityPlayersListBinding


class PlayersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayersListBinding
    private lateinit var playersArrayList : ArrayList<Players>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = listOf(
            R.drawable.angeldimaria,
            R.drawable.arberzeneli,
            R.drawable.cristianoronaldo,
            R.drawable.erlinghaland,
            R.drawable.granitxhaka,
            R.drawable.karimbenzea,
            R.drawable.kylianmbappe,
            R.drawable.leonardobonucci,
            R.drawable.lionelmessi,
            R.drawable.luissuarez,
            R.drawable.milotrashica,
            R.drawable.mohamadsalah,
            R.drawable.neymarjr,
            R.drawable.paulpogba,
            R.drawable.paulodybala,
            R.drawable.pedri,
            R.drawable.robertlewandowski,
            R.drawable.tonikroos,
            R.drawable.vedatmuriqi,
            R.drawable.xherdanshaqiri
        )

        val name = listOf(
            "Angel Di","Arber", "Cristiano", "Erling", "Granit",
            "Karim", "Kylian", "Leonardo", "Lionel", "Luis",
            "Milot", "Mohamad", "Neymar", "Paul", "Paulo",
            "Pedri", "Robert", "Toni", "Vedat", "Xherdan",
        )


        val surname = listOf(
            "Maria", "Zeneli", "Ronaldo", "Haland", "Xhaka",
            "Benzema", "Mbappe", "Bonucci", "Messi", "Suarez",
            "Rashica", "Salah", "Jr", "Pogba", "Dybala","",
            "Lewandowski", "Kroos",  "Muriqi", "Shaqiri",
        )

        val age = listOf(
            34, 27, 34, 22, 30,
            34, 23, 34, 35, 35,
            26, 30, 29, 30, 29,
            20, 34, 32, 28, 31,
        )

        val birthday = listOf(
            "14/02/1988", "25/02/1995", "05/02/1985", "21/07/2000", "27/09/1992",
            "19/12/1987", "20/12/1998", "01/05/1987", "24/06/1987", "24/01/1987",
            "28/06/1996", "15/06/1992", "05/02/1992","15/03/1993", "15/11/1993",
            "25/11/2002", "21/08/1988", "04/01/1990", "24/04/1994", "10/10/1991",
        )

        val country = listOf(
            "Argentina", "Kosovo", "Portugal", "Norway", "Switzerland",
            "France", "France", "Italy", "Argentina", "Uruguay",
            "Kosovo", "Egypt", "France", "Argentina", "Brazil",
            "Spain", "Poland","Germany", "Kosovo", "Switzerland",
        )

        val team = listOf(
            "Juventus Fc","Reims","ManchesterUnited", "ManchesterCity", "Arsenal",
            "Real Madrid", "Paris PSG", "Juventus Fc", "Paris PSG", "Atletico Madrid",
            "Galatasaray", "Liverpool", "Juventus Fc", "Roma", "Paris PSG",
            "Fc Barcelona", "Fc Barcelona", "Real Madrid Fc","RDC Mallorca", "Chicago Fire FC",
        )

        //------------------------------------------------------------------------------------------
        //search view
        val playerAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,
            name
        )

        binding.listview.adapter = playerAdapter;

        binding.searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (name.contains(query)){
                    playerAdapter.filter.filter(query)
                } else {
                    Toast.makeText(this@PlayersListActivity, "Lojtari nuk gjindet", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }
            override fun onQueryTextChange(newText : String?): Boolean {
                playerAdapter.filter.filter(newText)
                return false
            }

        })
        //------------------------------------------------------------------------------------------

        playersArrayList = ArrayList()

        for (i in name.indices) {

            val players = Players(image[i], name[i], surname[i], age[i], birthday[i], country[i], team[i])
            playersArrayList.add(players)
        }


        binding.listview.isClickable = true
        binding.listview.adapter= Adapter(this, playersArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val surname = surname[position]
            val age = age[position]
            val birthday = birthday[position]
            val country = country[position]
            val team = team[position]
            val image = image[position]

            val i = Intent(this, PlayersActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("surname", surname)
            i.putExtra("age", age)
            i.putExtra("birthday", birthday)
            i.putExtra("country", country)
            i.putExtra("team", team)
            i.putExtra("image", image)
            startActivity(i)
        }
    }
}