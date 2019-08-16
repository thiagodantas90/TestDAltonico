package com.example.testdaltonico

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //imagemTeste.setImageResource(R.drawable.vinteenove)

        var dados = intent.extras
        var texto = dados?.getString("teste")
        if(texto.equals("1")){
            imagemTeste.setImageResource(R.drawable.vinteenove)
        }else if(texto.equals("2")){
            imagemTeste.setImageResource(R.drawable.setentaequatro)
        }else if(texto.equals("3")){
            imagemTeste.setImageResource(R.drawable.dois)
        }

    }
    fun cancelar(v:View){
        var i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()

    }
    fun confirmar(v:View){
        var dados = intent.extras
        var i = Intent()

        var chave = dados?.getString("teste")?.toInt()
        i.putExtra("DADOS_RESPOSTA",resposta.text.toString())
        if(chave!=null){
            setResult(chave, i)
        }
        finish()
     }
}



