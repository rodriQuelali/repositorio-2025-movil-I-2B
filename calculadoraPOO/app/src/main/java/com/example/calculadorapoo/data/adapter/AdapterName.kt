package com.example.calculadorapoo.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadorapoo.R
import com.example.calculadorapoo.data.Pais
import com.example.calculadorapoo.view.RecircleyViewHome

class AdapterName(private val names:List<Pais>) :
    RecyclerView.Adapter<AdapterName.NameViewHolder>() {

    class NameViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        //para mic conexion ami view pero de  mis objetos: EDtitext, Button,etc..
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterName.NameViewHolder {
        // es para conexiona mi view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_name,parent,false)
        return NameViewHolder(view)

    }

    override fun onBindViewHolder(holder: AdapterName.NameViewHolder, position: Int) {
        // Optener los datos o asignar los datos hacia mi view
        val name = names[position].getNombre()
        holder.textViewName.text = name
    }

    override fun getItemCount(): Int = names.size


}