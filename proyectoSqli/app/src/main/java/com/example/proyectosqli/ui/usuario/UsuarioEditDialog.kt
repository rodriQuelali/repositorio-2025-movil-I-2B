package com.example.proyectosqli.ui.usuario

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.proyectosqli.R
import com.example.proyectosqli.model.Usuario


class UsuarioEditDialog(
    private val usuario: Usuario,
    private val onGuardar: (Usuario) -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = requireActivity().layoutInflater.inflate(R.layout.dialog_editar_usuario, null)
        val etNombre = view.findViewById<EditText>(R.id.etNombre)
        val etCorreo = view.findViewById<EditText>(R.id.etCorreo)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)

        etNombre.setText(usuario.getNombre())
        etCorreo.setText(usuario.getCorreo())
        etPassword.setText(usuario.getPassword())

        return AlertDialog.Builder(requireContext())
            .setTitle("Editar usuario")
            .setView(view)
            .setPositiveButton("Guardar") { _, _ ->
                val actualizado = Usuario(
                    codigo = usuario.getCodigo(),
                    nombre = etNombre.text.toString(),
                    correo = etCorreo.text.toString(),
                    password = etPassword.text.toString()
                )
                onGuardar(actualizado)
            }
            .setNegativeButton("Cancelar", null)
            .create()
    }
}