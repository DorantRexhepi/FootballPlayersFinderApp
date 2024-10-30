package com.example.projekti1

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Players
import com.example.PlayersActivity
import com.example.projekti1.databinding.ActivityPlayersListBinding

class PlayersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayersListBinding
    private lateinit var playersArrayList: ArrayList<Players>
    private lateinit var playerAdapter: Adapter  // Përdor Adapter.kt ekzistues

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Krijimi i një liste të përbashkët për të gjitha të dhënat e lojtarëve
        playersArrayList = arrayListOf(
            Players(R.drawable.angeldimaria, "Angel Di", "Maria", 34, "14/02/1988", "Argentina", "Juventus Fc"),
            Players(R.drawable.arberzeneli, "Arber", "Zeneli", 27, "25/02/1995", "Kosovo", "Reims"),
            Players(R.drawable.cristianoronaldo, "Cristiano", "Ronaldo", 34, "05/02/1985", "Portugal", "ManchesterUnited"),
            Players(R.drawable.erlinghaland, "Erling", "Haland", 22, "21/07/2000", "Norway", "ManchesterCity"),
            Players(R.drawable.edonzherova, "Edon", "Zhegrova", 25, "31/03/1999", "Kosovo", "Lille OSC"),
            Players(R.drawable.granitxhaka, "Granit", "Xhaka", 30, "27/09/1992", "Switzerland", "Arsenal"),
            Players(R.drawable.karimbenzea, "Karim", "Benzema", 34, "19/12/1987", "France", "Real Madrid"),
            Players(R.drawable.kylianmbappe, "Kylian", "Mbappe", 23, "20/12/1998", "France", "Paris PSG"),
            Players(R.drawable.leonardobonucci, "Leonardo", "Bonucci", 34, "01/05/1987", "Italy", "Juventus Fc"),
            Players(R.drawable.lionelmessi, "Lionel", "Messi", 35, "24/06/1987", "Argentina", "Paris PSG"),
            Players(R.drawable.luissuarez, "Luis", "Suarez", 35, "24/01/1987", "Uruguay", "Atletico Madrid"),
            Players(R.drawable.milotrashica, "Milot", "Rashica", 26, "28/06/1996", "Kosovo", "Galatasaray"),
            Players(R.drawable.mohamadsalah, "Mohamad", "Salah", 30, "15/06/1992", "Egypt", "Liverpool"),
            Players(R.drawable.neymarjr, "Neymar", "Jr", 29, "05/02/1992", "France", "Juventus Fc"),
            Players(R.drawable.paulpogba, "Paul", "Pogba", 30, "15/03/1993", "Argentina", "Roma"),
            Players(R.drawable.paulodybala, "Paulo", "Dybala", 29, "15/11/1993", "Brazil", "Paris PSG"),
            Players(R.drawable.pedri, "Pedri", "", 20, "25/11/2002", "Spain", "Fc Barcelona"),
            Players(R.drawable.robertlewandowski, "Robert", "Lewandowski", 34, "21/08/1988", "Poland", "Fc Barcelona"),
            Players(R.drawable.tonikroos, "Toni", "Kroos", 32, "04/01/1990", "Germany", "Real Madrid Fc"),
            Players(R.drawable.vedatmuriqi, "Vedat", "Muriqi", 28, "24/04/1994", "Kosovo", "RDC Mallorca"),
            Players(R.drawable.xherdanshaqiri, "Xherdan", "Shaqiri", 31, "10/10/1991", "Switzerland", "Chicago Fire FC")
        )

        // Inicimi i Adapter-it të personalizuar
        playerAdapter = Adapter(this, playersArrayList)
        binding.listview.adapter = playerAdapter

        // Funksionaliteti i kërkimit me SearchView
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (query != null && query.isNotEmpty()) {
                    playerAdapter.filter.filter(query)
                } else {
                    Toast.makeText(this@PlayersListActivity, "Lojtari nuk u gjet", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                playerAdapter.filter.filter(newText)
                return false
            }
        })

        // Kur klikon në një lojtar në listë
        binding.listview.setOnItemClickListener { _, _, position, _ ->
            val selectedPlayer = playerAdapter.getItem(position) // Merr lojtarin e filtruar
            val intent = Intent(this, PlayersActivity::class.java).apply {
                putExtra("name", selectedPlayer?.name)
                putExtra("surname", selectedPlayer?.surname)
                putExtra("age", selectedPlayer?.age)
                putExtra("birthday", selectedPlayer?.birthday)
                putExtra("country", selectedPlayer?.country)
                putExtra("team", selectedPlayer?.team)
                putExtra("image", selectedPlayer?.image)
            }
            startActivity(intent)
        }
    }
}