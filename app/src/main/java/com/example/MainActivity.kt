package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.projekti1.PlayersListActivity
import com.example.projekti1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Gjej butonin dhe vendos një listener për klikime
        val buttonViewPlayers = findViewById<Button>(R.id.button_view_players)
        buttonViewPlayers.setOnClickListener {
            // Kur butoni klikohet, hap aktivitetin PlayersListActivity
            val intent = Intent(this, PlayersListActivity::class.java)
            startActivity(intent)
        }
    }
}
