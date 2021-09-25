package com.rodrigo.listadecontatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rvList: RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.rv_List)
    }
    private val adapter = ContatoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
        upDateList()
    }
    private fun bindView(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)

    }
    private fun upDateList(){
        adapter.upDateList(
            arrayListOf(
                Contato(
                    "Rodrigo Aguiar",
                    "84 987061013",
                    "img_png"
                )
            )
        )
    }
}