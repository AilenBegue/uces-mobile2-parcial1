package com.example.mobile2_parcial1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterObra(val context: Context) : ListAdapter<Obra, AdapterObra.ViewHolder>(DiffCallBack){

    lateinit var onItemClickListener: (Obra) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre: TextView = view.findViewById(R.id.tvObra)
        private val autor: TextView = view.findViewById(R.id.tvAutor)
        private val tecnica: TextView = view.findViewById(R.id.tvTecnica)
        private val año: TextView = view.findViewById(R.id.tvAño)
        private val imagenObra: ImageView = view.findViewById(R.id.imageViewObra)

        fun bind(obra: Obra) {
            nombre.text = obra.nombre
            autor.text = obra.autor
            tecnica.text = obra.tecnica
            año.text = "Año: " + obra.año

            Glide.with(context)
                .load(obra.url)
                .into(imagenObra)

            view.setOnClickListener {
                onItemClickListener(obra)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obra = getItem(position)
        holder.bind(obra)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Obra>() {
        override fun areItemsTheSame(oldItem: Obra, newItem: Obra): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Obra, newItem: Obra): Boolean {
            return oldItem == newItem
        }
    }
}