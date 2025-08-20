package com.example.calculadorapoo.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadorapoo.R
import com.example.calculadorapoo.data.ItemModel
import com.example.calculadorapoo.data.adapter.MyItemAdapter

class RecircleirViewButtonImg : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myItemAdapter: MyItemAdapter
    private var currentList = mutableListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recircleir_view_button_img)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.myRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        // Inicializa el adaptador con las funciones de callback
        myItemAdapter = MyItemAdapter(
            onItemClicked = { item ->
                // Lógica cuando se hace click en toda la fila
                Toast.makeText(this, "Item clickeado: ${item.id}", Toast.LENGTH_SHORT).show()
            },
            onButtonClicked = { item, position ->
                // Lógica cuando se hace click en el botón del item
                Toast.makeText(this, "Botón clickeado para: ${item.id}", Toast.LENGTH_SHORT).show()

                // --- MANEJO DEL ESTADO DEL BOTÓN ---
                // Aquí es donde actualizas el estado del item en tu lista original
                // y luego notificas al adaptador.

                // 1. Encuentra el item en tu lista de datos original
                val clickedItem = currentList.find { it.id == item.id } // O usa la 'position' si es seguro

                clickedItem?.let {
                    // 2. Modifica el estado del item
                    it.isButtonEnabled = !it.isButtonEnabled // Ejemplo: alternar estado
                    // O podrías tener una lógica más compleja:
                    //it.buttonText = "Procesando..."
                    //it.isButtonEnabled = false
                    // ... hacer alguna operación asíncrona ...
                    // luego, en el callback de esa operación, actualizar el item de nuevo.
                }

                // 3. Notifica al adaptador sobre el cambio.
                // Si usas ListAdapter, simplemente envía la nueva lista (o una copia actualizada).
                // DiffUtil se encargará de actualizar solo lo necesario.
                // Es crucial crear una NUEVA lista para que DiffUtil detecte los cambios.
                val updatedList = currentList.map { it.copy() }
                myItemAdapter.submitList(updatedList)

                // Si no usas ListAdapter (y directamente RecyclerView.Adapter):
                // myItemAdapter.notifyItemChanged(position)
            }
        )
        recyclerView.adapter = myItemAdapter

        // Carga tus datos iniciales
        loadInitialData()
    }

    private fun loadInitialData() {
        // Simulación de carga de datos
        currentList = mutableListOf(
            ItemModel("1", R.drawable.img, buttonText = "Acción 1", isButtonEnabled = true),
            ItemModel("2", "https://rickandmortyapi.com/api/character/avatar/1.jpeg", buttonText = "Acción 222", isButtonEnabled = false),
            ItemModel("3", null, buttonText = "Acción 3", isButtonEnabled = true, isImageVisible = false) // Sin imagen
        )
        myItemAdapter.submitList(currentList.map { it.copy() }) // Envía una copia para la primera carga
    }
}