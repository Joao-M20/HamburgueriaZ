package com.example.hamburgueriaz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var contador = 0
    lateinit var quantidade: TextView

    val nome: EditText = findViewById(R.id.editTextNome)
    val bacon: CheckBox = findViewById(R.id.checkBoxBacon)
    val queijo: CheckBox = findViewById(R.id.checkBoxQueijo)
    val onion: CheckBox = findViewById(R.id.checkBoxOnion)

    val menos: Button = findViewById(R.id.buttonMenos)
    val mais: Button = findViewById(R.id.buttonMais)


    val resumo: TextView = findViewById(R.id.textViewResumo)
    val pedido: Button = findViewById(R.id.buttonPedido)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        quantidade.text = contador.toString()
        quantidade = findViewById(R.id.textViewQuantidade)





    }

    fun somar(view: View) {
        contador++
        quantidade.text = contador.toString()
    }

    fun subtrair(view: View) {
        if(contador == 0){
            Toast.makeText(this, "Não é possivel fazer esta ação", Toast.LENGTH_SHORT).show()

        } else{
            contador--
            quantidade.text = contador.toString()    
        }
    }

    fun EnviarPedido(view: View){
        val nomePedido = nome.text

    }

}