package br.fiap.com.luigifelicerm94546

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class Presentation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.presentation_layout)

        val button = findViewById<Button>(R.id.button)
        val criadores = findViewById<TextView>(R.id.creators)

        criadores.text = "Luigi Felice - RM94546\nMarianne Nocce - RM93255\nLuana Ramos - RM94670"

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}