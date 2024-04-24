package com.example.citaveterinaria.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.citaveterinaria.R
import java.util.Calendar


class CreateAppointmentActivity : AppCompatActivity() {
    val selectCalendar = Calendar.getInstance()
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
    /**Creando metodo para el calendario de consulta que posee la APP*/
    fun onClickScheduledDate(v: View?) {
        val etScheduleDate = findViewById<EditText>(R.id.txtFechaCita)
        val year = selectCalendar.get(Calendar.YEAR)
        val month = selectCalendar.get(Calendar.MONTH)
        val dayofMont = selectCalendar.get(Calendar.DAY_OF_MONTH)
        val listener = DatePickerDialog.OnDateSetListener{datePicker, y,m,d->
            selectCalendar.set(y,m,d)
            etScheduleDate.setText("$y-$m-$d")
            /**Al poner aqui el metodo display, tendra la accion de seleccionar una fecha y que aparesca la hora de consulta disponible*/
            displayRadioButtons()

        }
        DatePickerDialog(this, listener, year, month, dayofMont).show()

    }

    /**Creando metodo para los radioButton para que sea dinamico al momento de seleccionar la hora*/
    private fun displayRadioButtons() {
        val radioGroup = findViewById<RadioGroup>(R.id.rgOpcioneHora)

        /**Arreglo de la hora de atencion*/
        val hours = arrayOf("8:00 AM", "8:30 AM","9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM","11:00 AM", "11:30 AM",
            "12:00 AM","1:00 PM", "1:30 PM","2:00 PM", "2:30 PM","3:00 PM", "3:30 PM","4:00 PM", "4:30 PM",
            "5:00 PM", "5:30 PM","6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM","8:00 PM")

        /**Limpiando seccion*/
        radioGroup.removeAllViews()


        hours.forEach {
            val  radioButton = RadioButton(this)
            radioButton.id = View.generateViewId()
            radioButton.text = it
            radioGroup.addView(radioButton)
        }

    }





}