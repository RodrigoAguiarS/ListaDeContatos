package com.rodrigo.listadecontatos


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class ContatoDetail : AppCompatActivity() {
    private var contato: Contato? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_detail)
        iniToolbar()
        getExtras()
        bindViews()
    }

    private fun iniToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    private fun getExtras(){
        contato = intent.getParcelableExtra(EXTRA_CONTATO)
    }

    private fun bindViews(){
        findViewById<TextView>(R.id.txtNome).text = contato?.nome
        findViewById<TextView>(R.id.txtTelefone).text = contato?.telefone
    }
    companion object{
      const val EXTRA_CONTATO: String = "EXTRA_CONTATO"
    }
    override fun onSupportNavigateUp(): Boolean{
        finish()
        return true
    }
}