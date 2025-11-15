package com.example.proyectosqli.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectosqli.R
import com.example.proyectosqli.model.Usuario

class UsuarioAdapter(private var listUsuario: List<Usuario>,
                     private val onEditar : (Usuario)-> Unit,
                     private val onEliminar : (Usuario)->Unit) :
    RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>(){

    class UsuarioViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val txtNombre = itemView.findViewById<TextView>(R.id.tvNombreUsuario)
        val txtCorreo = itemView.findViewById<TextView>(R.id.tvCorreoUsuario)
        val btnEditar = itemView.findViewById<Button>(R.id.btnEditar)
        val tbnEliminar = itemView.findViewById<Button>(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsuarioAdapter.UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario,parent,false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioAdapter.UsuarioViewHolder, position: Int) {
        holder.txtNombre.text = listUsuario[position].getNombre()
        holder.txtCorreo.text = listUsuario[position].getCorreo()

        holder.btnEditar.setOnClickListener { onEditar(listUsuario[position]) }
        holder.tbnEliminar.setOnClickListener { onEliminar(listUsuario[position]) }
    }

    override fun getItemCount(): Int = listUsuario.size

    //actulizar de lista
    fun updateLista(newList: List<Usuario>){
        listUsuario = newList
        notifyDataSetChanged()
    }

}