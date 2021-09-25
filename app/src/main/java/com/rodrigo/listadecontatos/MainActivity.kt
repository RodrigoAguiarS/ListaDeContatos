package com.rodrigo.listadecontatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
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
                    "(84) 98706-1013",
                    "img_png"
                )
            )
        )
    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
        //return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itMenu1 -> {
                showToast("Clicou no Menu1")
                return true
            }
            R.id.itMenu2 -> {
                showToast("Clicou no Menu2")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}