package com.rodrigo.listadecontatos

//import android.widget.Toolbar
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rodrigo.listadecontatos.ContatoDetail.Companion.EXTRA_CONTATO


class MainActivity : AppCompatActivity(), ClickItemContatoListener {
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_List)
    }
    private val adapter = ContatoAdapter(this,)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        bindView()
        upDateList()

    }
    private fun initDrawer(){

        val drawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

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

    override fun clickItemContato(contato: Contato) {
        val intent = Intent(this, ContatoDetail::class.java)
        intent.putExtra(EXTRA_CONTATO, contato)
        startActivity(intent)
    }
}