package com.example.app_crud

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class conexionDB (context: Context): SQLiteOpenHelper(context, "amigos.db",null,1)  {

    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion ="CREATE TABLE amigos" +"(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT )"
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS amigos"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun anyadirDato(nombre: String, apellido: String) {
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("apellido", apellido)

        val db = this.writableDatabase
        db.insert("amigos", null, datos)
        db.close()
    }

    fun borrarDato(id: Int) : Int {
        val args= arrayOf(id.toString())

        val db = this.writableDatabase
        val borrados = db.delete("amigos", "id = ?", args)
        db.close()
        return borrados
    }

    fun editarDato(id: Int, nombre: String, apellido: String) {
        val args= arrayOf(id.toString())

        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("apellido", apellido)

        val db = this.writableDatabase
        db.update("amigos", datos,"id = ?", args)
        db.close()
    }
}