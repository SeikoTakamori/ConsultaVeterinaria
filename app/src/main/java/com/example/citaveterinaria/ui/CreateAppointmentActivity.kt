package com.example.citaveterinaria.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.citaveterinaria.R


class CreateAppointmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_appointment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /**Realizar accion de los dos formularios creado en registrar consulta*/
        val btnNext = findViewById<Button>(R.id.btnSiguiente)
        val btnConfirmar = findViewById<Button>(R.id.btnEnviar)
        val cvNext = findViewById<CardView>(R.id.cv_siguiente)
        val cvConfirmar = findViewById<CardView>(R.id.cv_enviarF)

        btnNext.setOnClickListener{
            cvNext.visibility = View.GONE
            cvConfirmar.visibility = View.VISIBLE
        }
        btnConfirmar.setOnClickListener{
            Toast.makeText(applicationContext, "Cita realizada correctamente", Toast.LENGTH_SHORT).show()
            finish()


        }

        /**Creando las opciones que contendran los spinner*/
        val  spEspecieAnimal = findViewById<Spinner>(R.id.spPaciente)
        val  spVeterinarioAsign = findViewById<Spinner>(R.id.spVeterinario)

        /**Arreglo que contiene las especie de animales para la cita*/
        val opcionEspAnimal = arrayOf("Perro","Gato","Hamster","Cabra","Vaca","Ave", "Otros")
        spEspecieAnimal.adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, opcionEspAnimal)

        /**Arreglo de los veterinarios que trabajan en la clinica*/
        val opcionVeterinario = arrayOf("Dr. Genesis Marbely López", "E.Otoniel Josué Pérez","E.Josué Elián García")
        spVeterinarioAsign.adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, opcionVeterinario)


    }
}