package com.example.mobile2_parcial1

import android.content.Intent
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

        adapter.onItemClickListener = { obra ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("nombre", obra.nombre)
            intent.putExtra("url", obra.url)
            intent.putExtra("autor", obra.autor)
            intent.putExtra("tecnica", obra.tecnica)
            intent.putExtra("año", obra.año)

            startActivity(intent)

        }
    }

    private fun getListadoObras(): MutableList<Obra>? {
        return mutableListOf(
            Obra(1, "Guernica", "Pablo Picasso", "Óleo sobre lienzo", "1937", "https://upload.wikimedia.org/wikipedia/en/thumb/7/74/PicassoGuernica.jpg/500px-PicassoGuernica.jpg"),
            Obra(2, "Las Meninas", "Diego Velázquez", "Óleo sobre lienzo", "1656", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Las_Meninas_01.jpg/500px-Las_Meninas_01.jpg"),
            Obra(3, "Baile en el Moulin de la Galette", "Pierre-Auguste Renoir", "Óleo sobre lienzo", "1876", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Pierre-Auguste_Renoir%2C_Le_Moulin_de_la_Galette.jpg/500px-Pierre-Auguste_Renoir%2C_Le_Moulin_de_la_Galette.jpg"),
            Obra(4, "La última cena", "Leonardo da Vinci", "Temple y óleo sobre yeso", "1495–1498", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/%C3%9Altima_Cena_-_Da_Vinci_5.jpg/500px-%C3%9Altima_Cena_-_Da_Vinci_5.jpg"),
            Obra(5, "La escuela de Atenas", "Rafael Sanzio", "Fresco", "1511", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/%22The_School_of_Athens%22_by_Raffaello_Sanzio_da_Urbino.jpg/500px-%22The_School_of_Athens%22_by_Raffaello_Sanzio_da_Urbino.jpg"),
            Obra(6, "Impresión, sol naciente", "Claude Monet", "Óleo sobre lienzo", "1872", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Monet_-_Impression%2C_Sunrise.jpg/500px-Monet_-_Impression%2C_Sunrise.jpg"),
            Obra(7, "Campo de trigo con cipreses", "Vincent van Gogh", "Óleo sobre lienzo", "1889", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Vincent_van_Gogh_-_Wheat_Field_with_Cypresses_-_Google_Art_Project.jpg/500px-Vincent_van_Gogh_-_Wheat_Field_with_Cypresses_-_Google_Art_Project.jpg"),
            Obra(8, "Almuerzo sobre la hierba", "Édouard Manet", "Óleo sobre lienzo", "1863", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Edouard_Manet_-_Luncheon_on_the_Grass_-_Google_Art_Project.jpg/500px-Edouard_Manet_-_Luncheon_on_the_Grass_-_Google_Art_Project.jpg"),
            Obra(9, "La playa de Sainte-Adresse", "Claude Monet", "Óleo sobre lienzo", "1867", "https://upload.wikimedia.org/wikipedia/commons/0/01/Claude_Monet_-_The_Beach_at_Sainte-Adresse_-_Google_Art_Project.jpg"),
            Obra(10, "La noche estrellada", "Vincent van Gogh", "Óleo sobre lienzo", "1889", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg/500px-Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg"),
            Obra(11, "El grito", "Edvard Munch", "Óleo, temple y pastel", "1893", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/The_Scream.jpg/500px-The_Scream.jpg"),
            Obra(12, "La creación de Adán", "Miguel Ángel", "Fresco", "1512", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Michelangelo_-_Creation_of_Adam_%28cropped%29.jpg/500px-Michelangelo_-_Creation_of_Adam_%28cropped%29.jpg"),
            Obra(13, "La persistencia de la memoria", "Salvador Dalí", "Óleo sobre lienzo", "1931", "https://upload.wikimedia.org/wikipedia/en/thumb/d/dd/The_Persistence_of_Memory.jpg/500px-The_Persistence_of_Memory.jpg"),
            Obra(14, "El nacimiento de Venus", "Sandro Botticelli", "Temple sobre lienzo", "1486", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Sandro_Botticelli_-_La_nascita_di_Venere_-_Google_Art_Project_-_edited.jpg/500px-Sandro_Botticelli_-_La_nascita_di_Venere_-_Google_Art_Project_-_edited.jpg"),
            Obra(15, "La joven de la perla", "Johannes Vermeer", "Óleo sobre lienzo", "1665", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Meisje_met_de_parel.jpg/500px-Meisje_met_de_parel.jpg"),
            Obra(16, "El estanque de nenúfares", "Claude Monet", "Óleo sobre lienzo", "1899", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Claude_Monet_-_Nymph%C3%A9as_-_Carnegie_Museum_of_Art%2C_Pittsburgh%2C_2019-12-11.jpg/1920px-Claude_Monet_-_Nymph%C3%A9as_-_Carnegie_Museum_of_Art%2C_Pittsburgh%2C_2019-12-11.jpg"),
        )
    }
}
