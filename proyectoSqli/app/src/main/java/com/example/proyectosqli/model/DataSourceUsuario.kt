package com.example.proyectosqli.model

import android.content.ContentValues
import android.content.Context

class DataSourceUsuario(context: Context) {
    //apen/closed
    private val admin = AdminSQLiteOpenHelper(context)

    //val usuer2 = Usuario(nombre="rodir", correo = "gemail.com", password = "123456789")

    //registro
    //insert
    fun registroUsuarioDataSource(usuario: Usuario): Long{

        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", usuario.getNombre())
        registro.put("correo", usuario.getCorreo())
        registro.put("password", usuario.getPassword())
        val dataResult = bd.insert("usuario", null, registro)
        bd.close()
        return dataResult

    }

    //delete
    fun eliminarUsuario(codigo: Int):Int{

        val bd = admin.writableDatabase
        val cant = bd.delete("usuario", "id_usuario=${codigo.toString()}", null)
        bd.close()
        return cant
    }

    //update
    fun actulizarUsuario(usuario: Usuario):Int{
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre", usuario.getNombre())
        registro.put("correo", usuario.getCorreo())
        registro.put("password", usuario.getPassword())
        val cant = bd.update("usuario", registro, "id_usuario=${usuario.getCodigo().toString()}", null)
        bd.close()
        return cant
    }

    //lista
    fun listarUsuarios(): List<Usuario> {
        val db = admin.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuario", null)
        val lista = mutableListOf<Usuario>()

        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Usuario(
                        codigo = cursor.getInt(cursor.getColumnIndexOrThrow("codigo")),
                        nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                        correo = cursor.getString(cursor.getColumnIndexOrThrow("correo")),
                        password = cursor.getString(cursor.getColumnIndexOrThrow("password"))
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        return lista
    }

    // otras operaciones mas ....


}