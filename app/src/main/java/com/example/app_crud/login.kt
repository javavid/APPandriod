package com.example.app_crud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val botonI : Button = findViewById(R.id.Ingresar)
        botonI.setOnClickListener{crud()}

        val botonR : Button = findViewById(R.id.Registrar)
        botonR.setOnClickListener{registro()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Thread.sleep(2*1000)
    }

    private fun registro() {
        startActivity(Intent(this, Registrar::class.java))
    }

    private fun crud() {

        val user : EditText = findViewById(R.id.User)
        val passw : EditText = findViewById(R.id.Password)

        val us : String = user.text.toString()
        val pass : String = passw.text.toString()

        var usuario = "edjt"
        var contrase = "programador"

        if (us != usuario && pass != contrase)
        {
            user.text.clear()
            passw.text.clear()
            Toast.makeText(this, " DATOS INCORRECTOS ", Toast.LENGTH_SHORT).show()

        }else if (us != usuario){
            user.text.clear()
            Toast.makeText(this, " USUARIO INCORRECTO ", Toast.LENGTH_SHORT).show()

        }else if (pass != contrase){
            passw.text.clear()
            Toast.makeText(this, " CONTRASEÑA INCORRECTO ", Toast.LENGTH_SHORT).show()

        }else if (us == usuario && pass == contrase)
        {

            startActivity(Intent(this, CRUD::class.java))
        }


    }
}