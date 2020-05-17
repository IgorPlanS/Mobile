package com.impacta_zenith_app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*
import android.os.Handler
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.menu_lateral_cabecalho.*


class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        imageViewBannerInicial.setImageResource(R.drawable.banner_soares)
        botao_FaleConosco.setText(R.string.str_FaleConosco)
        botao_TenhoInteresse.setText(R.string.str_TenhoInteresse)
        botao_Agendamentos.setText(R.string.str_Agendamentos)

        progressBar.visibility = View.GONE
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Tela Inicio"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var args = intent.extras
        val Usuario = args?.getString("Usuario")

        Toast.makeText(this, "Bem vindo $Usuario", Toast.LENGTH_LONG).show()
        mensagem_BemVindo.setText("Bem vindo $Usuario")

        botao_FaleConosco.setOnClickListener {
            val intent = Intent(this, FaleConoscoActivity::class.java)
            startActivity(intent)
        }
        botao_TenhoInteresse.setOnClickListener {
            val intent = Intent(this, TenhoInteresseActivity::class.java)
            startActivity(intent)
        }
        botao_Agendamentos.setOnClickListener {
            val intent = Intent(this, AgendamentosActivity::class.java)
            startActivity(intent)
        }

        configuraMenuLateral()

        //usuario_menu.setText(Usuario)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)

        // vincular evento de buscar
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                // ação enquanto está digitando
                return false
            }
            override fun onQueryTextSubmit(query: String?): Boolean {
                // ação  quando terminou de buscar e enviou
                Toast.makeText(this@TelaInicialActivity,query,Toast.LENGTH_LONG).show()
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if(id == R.id.action_buscar){
            Toast.makeText(this, "Clicou em buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar){
            Toast.makeText(this, "Clicou em atualizar", Toast.LENGTH_LONG).show()
            progressBar.visibility = View.VISIBLE
            Handler().postDelayed({
                progressBar.visibility = View.GONE
            },10000)
        }else if (id == R.id.action_config){
            Toast.makeText(this, "Clicou em config", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.action_adicionar){
            Toast.makeText(this, "Clicou em adicionar", Toast.LENGTH_LONG).show()
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }else if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(
            this,
            Layout_menu_lateral,
            toolbar,
            R.string.nav_open,
            R.string.nav_close)
        Layout_menu_lateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_cadastro -> {
                Toast.makeText(this, "Clicou em cadastro", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CadastroActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_chat -> {
                Toast.makeText(this, "Clicou em chat", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, FaleConoscoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_localizacao -> {
                Toast.makeText(this, "Clicou em localizações", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LocalizacoesActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_configuracoes -> {
                Toast.makeText(this, "Clicou em configurações", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ConfiguracoesActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Clicou em Sair", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        Layout_menu_lateral.closeDrawer(GravityCompat.START)
        return true
    }

}
