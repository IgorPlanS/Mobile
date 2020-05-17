package com.impacta_zenith_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_agendamentos.*

class AgendamentosActivity : DebugActivity() {

    private val context: Context get() = this

    private var agendamentos = listOf<Agendamento>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendamentos)

        supportActionBar?.title = "Agendamentos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerAgendamentos?.layoutManager = LinearLayoutManager(context)
        recyclerAgendamentos?.itemAnimator = DefaultItemAnimator()
        recyclerAgendamentos?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskAgendamentos()
    }

    fun taskAgendamentos(){
        Thread{
            this.agendamentos = AgendamentoService.getAgendamento(context)
            runOnUiThread{
                recyclerAgendamentos?.adapter = AgendamentoAdapter(agendamentos) { onClickAgendamento(it) }
            }
        }.start()
    }

    fun onClickAgendamento(agendamento: Agendamento){
        Toast.makeText(context, "Clicou em ${agendamento.cliente}", Toast.LENGTH_LONG).show()
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
