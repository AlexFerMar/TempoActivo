package com.example.tiempoactivo


import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var tiempoInicio: Long = 0
    var tiempoPausa: Long = 0
    var tiempoUso: Long = 0
    lateinit var tvTiempoUsado :TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tiempoInicio = System.currentTimeMillis()

        tvTiempoUsado = findViewById(R.id.tvTiempoUsado)
    }

    override fun onPause() {
        super.onPause()
        tiempoPausa = System.currentTimeMillis()
        tiempoUso = (tiempoPausa - tiempoInicio)/1000

    }

    override fun onResume() {
        super.onResume()
        tiempoInicio = System.currentTimeMillis()

        tvTiempoUsado.setText("Tiempo de Uso: $tiempoUso s")

        Log.i("Tiempo de uso","$tiempoUso Segundos" )

    }
}