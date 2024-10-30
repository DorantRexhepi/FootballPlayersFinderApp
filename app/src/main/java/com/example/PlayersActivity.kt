package com.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projekti1.R
import com.example.projekti1.databinding.ActivityPlayersBinding

class PlayersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receiving the intent data
        val image = intent.getIntExtra("image", R.drawable.cristianoronaldo)
        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        val age = intent.getIntExtra("age", R.layout.activity_players)
        val birthday = intent.getStringExtra("birthday")
        val country = intent.getStringExtra("country")
        val team = intent.getStringExtra("team")

        // Setting the received data to views
        binding.ImageProfile.setImageResource(image)
        binding.etnameProfile.text = name
        binding.etsurnameProfile.text = surname
        binding.etageProfile.text = age.toString()
        binding.etbirthdayProfile.text = birthday
        binding.etcountryProfile.text = country
        binding.etteamProfile.text = team

        // Back button functionality
        binding.backButton.setOnClickListener {
            onBackPressed() // This will navigate to the previous activity
        }
    }
}
