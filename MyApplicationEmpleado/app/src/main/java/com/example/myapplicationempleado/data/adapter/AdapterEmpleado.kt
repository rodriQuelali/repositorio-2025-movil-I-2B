package com.example.myapplicationempleado.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationempleado.R
import com.example.myapplicationempleado.data.Empleado

class AdapterEmpleado(private val listEmpleado:List<Empleado>):
    RecyclerView.Adapter<AdapterEmpleado.EmpleadoViewHolder>() {

    class EmpleadoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val textViewSalario: TextView = itemView.findViewById(R.id.tvSalario)
        val textViewFecha: TextView = itemView.findViewById(R.id.tvFechaIngreso)
        val textViewQuinqueno: TextView = itemView.findViewById(R.id.tvQuinquenio)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterEmpleado.EmpleadoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_empleado, parent, false)
        return EmpleadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterEmpleado.EmpleadoViewHolder, position: Int) {
        val name = listEmpleado[position].getNombre()
        val salario = listEmpleado[position].getSalario()
        val fecchaIngreso = listEmpleado[position].getFechaIngreso()
        val quinqueno = listEmpleado[position].calacularQuienqueno()
        holder.textViewNombre.text = name
        holder.textViewSalario.text = salario.toString()
        holder.textViewFecha.text = fecchaIngreso
        holder.textViewQuinqueno.text = quinqueno
    }

    override fun getItemCount(): Int = listEmpleado.size

}