package com.example.app_crud

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CRUD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crud)

        var amigosDBHelper = conexionDB(this)
        val botonInsertar: Button =findViewById(R.id.insertar)


        val campoId: EditText =findViewById(R.id.ID)
        val campoNombre: EditText =findViewById(R.id.Nombre)
        var nombre=campoNombre.text
        val campoApellido: EditText =findViewById(R.id.Apellido)
        var apellido=campoApellido.text
        val campoRespuesta: TextView =findViewById(R.id.lblRespuesta)

        botonInsertar.setOnClickListener {
            if (campoNombre.text.isNotBlank() && campoApellido.text.isNotBlank()){
                amigosDBHelper.anyadirDato(campoNombre.text.toString(), campoApellido.text.toString())
                campoId.text.clear()
                campoNombre.text.clear()
                campoApellido.text.clear()
                Toast.makeText(this, "Insert EXITOSO", Toast.LENGTH_SHORT).show()

            }else {
                Toast.makeText(this, "No se almacenaron los datos", Toast.LENGTH_LONG).show()

            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Thread.sleep(2*1000)
    }


}