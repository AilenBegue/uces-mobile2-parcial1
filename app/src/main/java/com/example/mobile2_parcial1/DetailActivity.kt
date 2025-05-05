package com.example.mobile2_parcial1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var btnBackDetail : Button
    private lateinit var ivObraDetail : ImageView
    private lateinit var tvObraDetail : TextView
    private lateinit var tvAutorDetail : TextView
    private lateinit var tvTecnicaDetail : TextView
    private lateinit var tvAñoDetail : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnBackDetail = findViewById(R.id.btnBackDetail)

        ivObraDetail = findViewById(R.id.ivObraDetail)
        tvObraDetail = findViewById(R.id.tvObraDetail)
        tvAutorDetail = findViewById(R.id.tvAutorDetail)
        tvTecnicaDetail = findViewById(R.id.tvTecnicaDetail)
        tvAñoDetail = findViewById(R.id.tvAñoDetail)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombre", "")
        val url = bundle?.getString("url", "")
        val autor = bundle?.getString("autor", "")
        val tecnica = bundle?.getString("tecnica", "")
        val año = bundle?.getString("año", "")

        tvObraDetail.text = nombre
        tvAutorDetail.text = autor
        tvTecnicaDetail.text = tecnica
        tvAñoDetail.text = año

        Glide.with(applicationContext)
            .load(url)
            .into(ivObraDetail)

        btnBackDetail.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}

