package com.example.citaveterinaria.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.citaveterinaria.R
import com.example.citaveterinaria.util.PreferenceHelper
import com.example.citaveterinaria.util.PreferenceHelper.get
import com.example.citaveterinaria.util.PreferenceHelper.set


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
        /**Cargando preferencias al inicio y cierre de sesion*/
        val preferences = PreferenceHelper.defaultPrefs(this)
        if (preferences["Sesion",false])
            goMenu()

        /**Accion de mi link de registro*/
        val tvGtRegister = findViewById<TextView>(R.id.tv_gtRegister)
        tvGtRegister.setOnClickListener{
            goRegister()

        }
        /**Accion del boton entrar*/
        val btnGoMenu = findViewById<Button>(R.id.loginBtn)
        btnGoMenu.setOnClickListener{
            goMenu()
        }




    }

/**Metodo para llamar al formulario registro  */
    private fun goRegister(){
        val i = Intent(this, RegisterActivity::class.java)
        createSessionPreference()
        startActivity(i)
        finish()
    }
    private fun  goMenu(){
        val i = Intent(this, MenuActivity::class.java)
        startActivity(i)
    }
    /**Metodo para cerra sesion en la pantalla de menu */
    private fun createSessionPreference(){
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["Session"] = true
    }

}