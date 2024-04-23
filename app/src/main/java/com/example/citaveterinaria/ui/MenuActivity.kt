package com.example.citaveterinaria.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.citaveterinaria.R
import com.example.citaveterinaria.util.PreferenceHelper
import com.example.citaveterinaria.util.PreferenceHelper.set

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /**Accion del boton registrar consulta*/
        val btnReservarCita = findViewById<Button>(R.id.consultaBtn)
        btnReservarCita.setOnClickListener{
            goCreateAppointment()

        }
        /**Accion del boton de salida*/
        val btnsalir = findViewById<Button>(R.id.salirBtn)
        btnsalir.setOnClickListener(){
            clearSessionPreference()
            goLogin()

        }
    }

    /**Metodo para llamar al formulario de login al cerras sesion  */
    private  fun goLogin(){
        val i =Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }

    private fun goCreateAppointment(){
        val i = Intent(this,CreateAppointmentActivity::class.java)
        startActivity(i)
    }
    private fun clearSessionPreference(){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = false
    }
}