package com.example.proyectosqli.ui.usuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.proyectosqli.R
import com.example.proyectosqli.model.Usuario
import com.example.proyectosqli.viewModel.UsuarioViewModel
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistroUsuario.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistroUsuario : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private val viewModel: UsuarioViewModel by viewModels()

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
        return inflater.inflate(R.layout.fragment_registro_usuario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegistrar = view.findViewById<Button>(R.id.btnRegister)
        val tvMensaje = view.findViewById<TextView>(R.id.tvMensaje)

        val txtN = view.findViewById<TextInputEditText>(R.id.etNombre)
        val txtC = view.findViewById<TextInputEditText>(R.id.etCorreo)
        val txtP = view.findViewById<TextInputEditText>(R.id.etPassword)



        btnRegistrar.setOnClickListener {
            viewModel.registroViewModel(Usuario(
                nombre = txtN.text.toString(),
                correo = txtC.text.toString(),
                password = txtP.text.toString()))
        }

        viewModel.mensaje.observe(viewLifecycleOwner, Observer {
            tvMensaje.text = it
        })

        viewModel.usuarios.observe(viewLifecycleOwner, Observer { lista ->
            val texto = lista.joinToString("\n") { "${it.getCodigo()} - ${it.getNombre()} - ${it.getCorreo()}" }
            Toast.makeText(requireContext(), texto.ifEmpty { "Sin usuarios registrados" }, Toast.LENGTH_LONG).show()
        })


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistroUsuario.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistroUsuario().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}