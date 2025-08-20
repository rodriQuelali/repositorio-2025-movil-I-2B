package com.example.calculadorapoo.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.calculadorapoo.R
import com.example.calculadorapoo.data.ItemModel

class MyItemAdapter(
    private val onItemClicked: (ItemModel) -> Unit,
    private val onButtonClicked: (ItemModel, Int) -> Unit // Pasa el item y su posición
) : ListAdapter<ItemModel, MyItemAdapter.ItemViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false) // Usa tu layout de item
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onButtonClicked, position)

        // Listener para el click en todo el item (opcional)
        holder.itemView.setOnClickListener {
            onItemClicked(item)
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.itemImageView)
        private val buttonTextView: TextView = itemView.findViewById(R.id.itemButtonTextView) // Si tienes un TextView asociado al botón
        private val actionButton: Button = itemView.findViewById(R.id.itemActionButton)

        fun bind(
            item: ItemModel,
            onButtonClickedCallback: (ItemModel, Int) -> Unit,
            position: Int // La posición actual del item
        ) {
            // 1. Cargar la Imagen
            if (item.isImageVisible) {
                imageView.visibility = View.VISIBLE
                Glide.with(itemView.context)
                    .load(item.imageUrl) // URL, URI, o ID de recurso
                    .placeholder(item.imagePlaceholder) // Placeholder mientras carga
                    .error(R.drawable.ic_launcher_background) // Imagen de error si falla la carga
                    .into(imageView)
            } else {
                imageView.visibility = View.GONE // O podrías poner un placeholder fijo
            }


            // 2. Configurar el Estado del Botón
            actionButton.text = item.buttonText
            actionButton.isEnabled = item.isButtonEnabled

            // 3. Manejar el Click del Botón
            // Es importante quitar listeners anteriores para evitar múltiples llamadas en vistas recicladas
            actionButton.setOnClickListener(null) // Limpiar listener anterior
            if (item.isButtonEnabled) {
                actionButton.setOnClickListener {
                    // Notificar a la Activity/Fragment que el botón fue clickeado
                    // para que la lógica de negocio (y la actualización del estado del item)
                    // se maneje allí.
                    onButtonClickedCallback(item, position)
                }
            }
        }
    }
}

// DiffUtil para calcular diferencias y animar cambios eficientemente
class ItemDiffCallback : DiffUtil.ItemCallback<ItemModel>() {
    override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem.id == newItem.id // Compara por un identificador único
    }

    override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem == newItem // Compara todos los campos (si ItemModel es data class)
    }
}
