package com.impacta_zenith_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : DebugActivity() {

    private val context: Context get() = this

    private var listausuarios = listOf<Usuarios>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        txt_campo_login.setText(R.string.str_login)
        txt_campo_password.setText(R.string.str_password)
        botao_cadastro.setText(R.string.str_botao_cadastro)
        supportActionBar?.title = "Cadastro de Administrador"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        botao_cadastro.setOnClickListener{
            val usuarios = Usuarios()
            val users = listausuarios
            usuarios.id = (users.size.toLong())+1
            usuarios.password = campo_password.text.toString()
            usuarios.usuario = campo_usuario.text.toString()
            taskAtualizar(usuarios)

        }
    }

    private fun taskAtualizar(usuarios: Usuarios){
        // Thread para salvar a discilpina
        Thread {
            UsuariosService.save(usuarios)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }

    override fun onResume() {
        super.onResume()
        taskUsuarios()
    }

    fun taskUsuarios(){
        Thread{
            this.listausuarios = UsuariosService.getUsuarios(context)
        }.start()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_telas, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if(id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
