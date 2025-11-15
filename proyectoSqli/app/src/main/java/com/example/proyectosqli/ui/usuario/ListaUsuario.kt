package com.example.proyectosqli.ui.usuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectosqli.R
import com.example.proyectosqli.adapter.UsuarioAdapter
import com.example.proyectosqli.model.Usuario
import com.example.proyectosqli.viewModel.UsuarioViewModel
import kotlin.getValue
import kotlin.text.ifEmpty

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListaUsuario.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaUsuario : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

//global de todos mis metod de mi viewModelUsuario
    private val viewModel: UsuarioViewModel by viewModels()
    private lateinit var adapterUsuario: UsuarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_usuario, container, false)


        val rViewRecircley = view.findViewById<RecyclerView>(R.id.recyclerUsuarios)
        rViewRecircley.layoutManager = LinearLayoutManager(requireContext())


        adapterUsuario = UsuarioAdapter(emptyList(),
            onEditar = {usuario -> mostrarDialogEditar(usuario)},
            onEliminar = { usuario -> viewModel.eliminarUsuario(usuario.getCodigo())}
        )

        rViewRecircley?.adapter = adapterUsuario

        viewModel.mensaje.observe(viewLifecycleOwner, Observer {
            //tvMensaje.text = it
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })

        viewModel.usuarios.observe(viewLifecycleOwner, Observer { lista ->
            adapterUsuario.updateLista(lista)
        })

        viewModel.cargarUsuarioViewModel()
        return view
    }

    private fun mostrarDialogEditar(usuario: Usuario){
        val dialog = UsuarioEditDialog(usuario){ actulizar ->
            viewModel.actulizarUsuario(actulizar)
        }
        dialog.show(parentFragmentManager, "editarUsuario")

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListaUsuario.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListaUsuario().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}