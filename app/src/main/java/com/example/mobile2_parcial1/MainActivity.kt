package com.example.mobile2_parcial1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewMain: RecyclerView
    private lateinit var adapter: AdapterObra

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewMain = findViewById(R.id.recyclerViewMain)
        recyclerViewMain.layoutManager = LinearLayoutManager(this)

        adapter = AdapterObra(applicationContext)
        recyclerViewMain.adapter = adapter

        adapter.submitList(getListadoObras())
    }

    private fun getListadoObras(): MutableList<Obra>? {
        return mutableListOf(
            Obra(1, "Las Meninas", "Diego Velázquez", "Óleo sobre lienzo", "1656", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Las_Meninas_01.jpg/500px-Las_Meninas_01.jpg")
        )
    }
}
