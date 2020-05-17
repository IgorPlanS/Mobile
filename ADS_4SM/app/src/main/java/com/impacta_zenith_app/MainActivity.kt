package com.impacta_zenith_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*
import java.security.KeyStore


class MainActivity : DebugActivity() {

    private val context: Context get() = this

    private var usuarios = listOf<Usuarios>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)

        imageViewBanner.setImageResource(R.drawable.banner_soares)
        mensagem_login.setText(R.string.str_Msglogin)
        txt_campo_login.setText(R.string.str_login)
        txt_campo_password.setText(R.string.str_password)
        botao_login.setText(R.string.str_botao_login)
        botao_lembrar.setText(R.string.str_botao_lembrar_login)

        botao_login.setOnClickListener {onClickLogin()}

        //Carrega as preferencias
        var lembrar = Prefs.getBoolean("lembrar")
        var usuario = Prefs.getString("lembrarNome")
        var senha = Prefs.getString("lembrarSenha")
        campo_usuario.setText(usuario)
        campo_password.setText(senha)
        botao_lembrar.isChecked = lembrar
    }

    fun onClickLogin() {
        var intent = Intent(this, TelaInicialActivity::class.java)
        val params = Bundle()
        params.putString("Usuario", campo_usuario.text.toString())
        params.putString("Senha", campo_password.text.toString())
        intent.putExtras(params)

        //grava valores digitados nos campos
        val usuario = campo_usuario.text.toString()
        val senha = campo_password.text.toString()

        //verifica e salva valores caso botao de lembrar esteja selecionado
        Prefs.setBoolean("lembrar", botao_lembrar.isChecked)
        if(botao_lembrar.isChecked){
            Prefs.setString("lembrarNome", usuario)
            Prefs.setString("lembrarSenha", senha)
        }
        else{
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha", "")
        }

        //monta logica de login
        val validacao = usuario + senha
        val users = usuarios
        val quantiade_user = (users.size)
        var cont = 0
        var senha_errada = 0

        //valida senha digitada
        for (numero in 1..quantiade_user) {
            val teste = users[cont].toString()
            if (validacao.equals(teste)) {
                startActivity(intent)
                senha_errada += 1
            } else {
            }
            cont += 1
        }

        //verifica que a senha foi digitada errada
        if (senha_errada >= 1){
            mensagem_erro_login.setText("")
        }else{
            mensagem_erro_login.setText(R.string.str_erro_login)
        }

        //marca a posição atual do botao de lembrar senha

    }


    override fun onResume() {
        super.onResume()
        taskUsuarios()
    }

    fun taskUsuarios(){
        Thread{
            this.usuarios = UsuariosService.getUsuarios(context)
        }.start()
    }

}


