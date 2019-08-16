package com.example.testdaltonico

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val MY_REQUEST_CODE1 = 100
    val MY_REQUEST_CODE2 = 200
    val MY_REQUEST_CODE3 = 300

    var img1 = 1
    var img2 = 2
    var img3 = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            100 ->{
                when (resultCode){
                    1->{
                        val param = data?.extras
                        respTeste1.text = param?.getString("DADOS_RESPOSTA")
                    }
                }
            }
            200 ->{
                when (resultCode){
                    2->{
                        val param = data?.extras
                        respTeste2.text = param?.getString("DADOS_RESPOSTA")
                    }
                }
            }
            300 ->{
                when (resultCode){
                    3->{
                        val param = data?.extras
                        respTeste3.text = param?.getString("DADOS_RESPOSTA")
                    }
                }
            }
        }
    }


    fun abrir(v: View){
        var i = Intent(this, Main2Activity::class.java)
        var dados = Bundle()

        when(v.id) {
            R.id.btnTeste1 -> {
                dados.putString("teste", img1.toString())
                i.putExtras(dados)
                startActivityForResult(i, MY_REQUEST_CODE1)
            }
            R.id.btnTeste2 -> {
                dados.putString("teste", img2.toString())
                i.putExtras(dados)
                startActivityForResult(i, MY_REQUEST_CODE2)
            }
            R.id.btnTeste3 -> {
                dados.putString("teste", img3.toString())
                i.putExtras(dados)
                startActivityForResult(i, MY_REQUEST_CODE3)
            }

        }

    }
    fun verificar(v:View){
        if(respTeste1.text.toString() == "29" && respTeste2.text.toString() == "74" && respTeste3.text.toString() == "2"){
            resultado.text = "Voce nao e daltonico"
            clearFindViewByIdCache()
        }else{
            resultado.text = "Voce e daltonico"
        }
    }
}
