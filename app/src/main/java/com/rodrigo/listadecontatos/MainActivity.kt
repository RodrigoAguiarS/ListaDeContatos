package com.rodrigo.listadecontatos

//import android.widget.Toolbar

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
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
        fetchListContact()
        bindView()


    }
    private fun fetchListContact(){
        val list = arrayListOf(
            Contato(
                "Rodrigo Aguiar",
                "(84) 98706-1013",
                "img_png"
            )
        )
        getInstanceSharedPreference().edit{
            putString("contato", Gson().toJson(list))

        }
    }
    private fun getInstanceSharedPreference(): SharedPreferences{
        return getSharedPreferences("com.rodrigo.listadecontatos.PREFERENCES", MODE_PRIVATE)
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
        upDateList()

    }
    private fun getListContatos(): List<Contato> {
        val list = getInstanceSharedPreference().getString("contato","[]")
        val turnsType = object : TypeToken<List<Contato>>() {}.type
        return Gson().fromJson(list, turnsType)

    }
    private fun upDateList(){
        adapter.upDateList(getListContatos())
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