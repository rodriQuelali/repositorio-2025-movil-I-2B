package com.example.proyectosqli.model



import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper(
    context: Context,
    name: String = "administracion",
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1) :
    SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        //vamos crear mi tabla.
        db?.execSQL("create table usuario(id_usuario int primary key, nombre text, correo text, passeord text)")
    }

    override fun onUpgrade(
        p0: SQLiteDatabase?,
        p1: Int,
        p2: Int
    ) {

    }
}