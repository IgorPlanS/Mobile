package com.impacta_zenith_app

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*
import java.security.KeyStore


class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.login)

        imageViewBanner.setImageResource(R.drawable.banner_soares)
        mensagem_login.setText(R.string.str_Msglogin)
        txt_campo_login.setText(R.string.str_login)
        txt_campo_password.setText(R.string.str_password)
        botao_login.setText(R.string.str_botao_login)
        botao_lembrar.setText(R.string.str_botao_lembrar_login)



        var CheckBotaoLembrar = ""
        botao_lembrar.setOnCheckedChangeListener{
                buttonView, isChecked -> isChecked
            if(isChecked){
                CheckBotaoLembrar = "Ligado"
            }else{
                CheckBotaoLembrar = "Desligado"
            }
        }

        botao_login.setOnClickListener {
            var intent = Intent(this, TelaInicialActivity::class.java)

            val params = Bundle()
            params.putString("Usuario", campo_usuario.text.toString())
            params.putString("Senha", campo_password.text.toString())
            intent.putExtras(params)

            mensagem_erro_login.setText(R.string.str_vazia)
            if(campo_usuario.text.toString().equals("aluno")
                &&campo_password.text.toString().equals("impacta")) {
                startActivity(intent)
            }else {
                mensagem_erro_login.setText(R.string.str_erro_login)
            }

            if (CheckBotaoLembrar.toString().equals("Ligado")){

            }else{
                campo_usuario.setText(R.string.str_vazia)
                campo_password.setText(R.string.str_vazia)
            }

        }


    }



}


