package com.example.hamburgueriaz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var contador = 0
    lateinit var quantidade: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        quantidade = findViewById(R.id.textViewQuantidade)
        quantidade.text = contador.toString()


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



    fun EnviarPedido(view: View) {


        val nome: EditText = findViewById(R.id.editTextNome)
        val bacon: CheckBox = findViewById(R.id.checkBoxBacon)
        val queijo: CheckBox = findViewById(R.id.checkBoxQueijo)
        val onion: CheckBox = findViewById(R.id.checkBoxOnion)
        val resumo: TextView = findViewById(R.id.textViewResumo)
        val valorFinal: TextView = findViewById(R.id.textViewValorFinal)
        val nomeCliente = nome.text.toString()
        val temBacon = bacon.isChecked
        val temQueijo = queijo.isChecked
        val temOnion = onion.isChecked
        val meuEmail = "ivanmayta2585@gmail.com"
        val assunto = "oi"
        val nomeAssunto = nome.text.toString()


        val precoTotal = calcularPreco(temBacon, temQueijo, temOnion, contador)


        val mensagem = """
        Nome do cliente: $nomeCliente
        Tem Bacon? ${if (temBacon) "Sim" else "Não"}
        Tem Queijo? ${if (temQueijo) "Sim" else "Não"}
        Tem Onion Rings? ${if (temOnion) "Sim" else "Não"}
        Quantidade: $contador
        Preço final: R$ %.2f
        """.trimIndent().format(precoTotal)


        resumo.text = mensagem
        valorFinal.text = "R$ %.2f".format(precoTotal)


        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(meuEmail))
            putExtra(Intent.EXTRA_SUBJECT, "Pedido de $nomeAssunto")
            putExtra(Intent.EXTRA_TEXT, mensagem)
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Send Email"))
        } else {
            Toast.makeText(this, "Nenhum app de e-mail encontrado.", Toast.LENGTH_SHORT).show()
        }

    }

    fun calcularPreco(bacon: Boolean, queijo: Boolean, onion: Boolean, quantidade: Int): Double {
        val precoBase = 20.0
        var precoAdicionais = 0.0

        if (bacon) precoAdicionais += 2.0
        if (queijo) precoAdicionais += 2.0
        if (onion) precoAdicionais += 3.0

        return (precoBase + precoAdicionais) * quantidade
    }



}