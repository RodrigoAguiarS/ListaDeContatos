package com.rodrigo.listadecontatos

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContatosAdapter : RecyclerView.Adapter<ContatosAdapter.ContatosAdapterViewHolder>(){
    private val list: MutableList<Contato> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosAdapterViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContatosAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class ContatosAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(contato: Contato){

        }

    }
}