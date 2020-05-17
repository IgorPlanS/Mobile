package com.impacta_zenith_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tenho_interesse.*

class TenhoInteresseActivity : DebugActivity() {

    private val context: Context get() = this

    private var tenhointeresse = listOf<TenhoInteresse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenho_interesse)

        supportActionBar?.title = "Tenho Interesse"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerTenhoInteresse?.layoutManager = LinearLayoutManager(context)
        recyclerTenhoInteresse?.itemAnimator = DefaultItemAnimator()
        recyclerTenhoInteresse?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskTenhoInteresse()
    }


    fun taskTenhoInteresse(){
        Thread{
            this.tenhointeresse = TenhoInteresseService.getTenhoInteresse(context)
            runOnUiThread{
                recyclerTenhoInteresse?.adapter = TenhoInteresseAdapter(tenhointeresse) { onClickTenhoInteresse(it) }
            }
        }.start()
    }

    fun onClickTenhoInteresse(tenhointeresse: TenhoInteresse){
        Toast.makeText(context, "Clicou em ${tenhointeresse.cliente}", Toast.LENGTH_LONG).show()
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
