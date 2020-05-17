package com.impacta_zenith_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_fale_conosco.*

class FaleConoscoActivity : DebugActivity() {

    private val context: Context get() = this

    private var faleconosco = listOf<FaleConosco>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fale_conosco)

        supportActionBar?.title = "Fale Conosco"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerFaleConosco?.layoutManager = LinearLayoutManager(context)
        recyclerFaleConosco?.itemAnimator = DefaultItemAnimator()
        recyclerFaleConosco?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskFaleConosco()
    }

    fun taskFaleConosco(){
        Thread{
            this.faleconosco = FaleConoscoService.getFaleConosco(context)
            runOnUiThread{
                recyclerFaleConosco?.adapter = FaleConoscoAdapter(faleconosco) { onClickFaleConosco(it) }
            }
        }.start()
    }

    fun onClickFaleConosco(faleconosco: FaleConosco){
        Toast.makeText(context, "Clicou em ${faleconosco.cliente}", Toast.LENGTH_LONG).show()
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