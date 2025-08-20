package com.example.myapplicationproducto.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationproducto.R


class AdapterProducto(private val prductos:List<String>) :
    RecyclerView.Adapter<AdapterProducto.ProductoViewHolder>(){

    class ProductoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textNombreProucto = itemView.findViewById<TextView>(R.id.txtNombre)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_producto, parent, false)
        return ProductoViewHolder(view)

    }

    override fun getItemCount(): Int = prductos.size

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val name = prductos[position]
        holder.textNombreProucto.text = name
    }


}