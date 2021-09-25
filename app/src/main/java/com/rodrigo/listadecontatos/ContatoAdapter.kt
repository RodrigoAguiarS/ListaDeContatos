package com.rodrigo.listadecontatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatoAdapter : RecyclerView.Adapter<ContatoAdapter.ContatosAdapterViewHolder>(){

    private val list: MutableList<Contato> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contato_item, parent, false)
        return ContatosAdapterViewHolder(view)
    }
    override fun onBindViewHolder(holder: ContatosAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }
    override fun getItemCount(): Int {
        return list.size
    }
    fun upDateList(list: List<Contato>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    class ContatosAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        private val txtTelefone: TextView = itemView.findViewById(R.id.txtTelefone)
        private val imgFoto: ImageView = itemView.findViewById(R.id.imgFoto)

        fun bind(contato: Contato){
            txtNome.text = contato.nome
            txtTelefone.text = contato.telefone
        }
    }
}