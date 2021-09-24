package com.rodrigo.listadecontatos

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContatosAdapter : RecyclerView.Adapter<ContatosAdapter.ContatosAdapterViewHolder>(){
    private val list: MutableList<Contatos> = MutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContatosAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    class ContatosAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}