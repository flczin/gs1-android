package br.fiap.com.luigifelicerm94546

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = BeachAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val name = findViewById<EditText>(R.id.nameBeach)
        val city = findViewById<EditText>(R.id.city)
        val state = findViewById<EditText>(R.id.state)
        val textView = findViewById<TextView>(R.id.titulo)
        val btnClear = findViewById<Button>(R.id.clearList)

        textView.text = "Guia das Praias"

        btnClear.setOnClickListener {
            itemsAdapter.clearList()
        }

        button.setOnClickListener {
            if (name.text.isEmpty() || city.text.isEmpty() || state.text.isEmpty()) {
                if (name.text.isEmpty()) {
                    name.error = "Preencha um valor"
                }
                if (city.text.isEmpty()) {
                    city.error = "Preencha um valor"
                }
                if (state.text.isEmpty()) {
                    state.error = "Preencha um valor"
                }
                return@setOnClickListener
            }


            val beachName = name.text.toString().lowercase().split(" ")
                .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
            val cityName = city.text.toString().lowercase().split(" ")
                .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
            val stateName = state.text.toString().lowercase().split(" ")
                .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }


            val item = BeachModel(
                name = beachName,
                city = cityName,
                state = stateName,
                onRemove = {
                    itemsAdapter.removeItem(it)
                    showRemoveDialog(beachName)
                }
            )

            itemsAdapter.addItem(item)
            showAddDialog(beachName)
            name.text.clear()
            city.text.clear()
            state.text.clear()
            name.clearFocus()
            city.clearFocus()
            state.clearFocus()
        }
    }

    private fun showAddDialog(itemName: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Praia '$itemName' adicionado com sucesso!")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    private fun showRemoveDialog(itemName: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Praia '$itemName' removido com sucesso!")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}

