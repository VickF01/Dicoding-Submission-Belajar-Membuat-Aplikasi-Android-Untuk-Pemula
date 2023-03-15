package com.example.submissionapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionapplication.databinding.ItemRowBinding

class ListLaptopAdapter(private val listLaptop: ArrayList<Laptop>) : RecyclerView.Adapter<ListLaptopAdapter.ListViewHolder>() {
    class ListViewHolder (var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listLaptop.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (laptop_name,
            laptop_highlights,
            laptop_picture,
            laptop_cpu,
            laptop_os,
            laptop_ram,
            laptop_storage,
            laptop_screen,
            laptop_gpu,
            laptop_features,
            laptop_price) = listLaptop[position]
        holder.binding.laptopName.text = laptop_name
        holder.binding.laptopHighlights.text = laptop_highlights
        Glide.with(holder.itemView.context).load(laptop_picture).into(holder.binding.laptopPic)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailLaptop::class.java)
            intent.putExtra(DetailLaptop.EXTRA_NAME, laptop_name)
            intent.putExtra(DetailLaptop.LAPTOP_HIGHLIGHTS, laptop_highlights)
            intent.putExtra(DetailLaptop.LAPTOP_PICTURE, laptop_picture)
            intent.putExtra(DetailLaptop.LAPTOP_CPU, laptop_cpu)
            intent.putExtra(DetailLaptop.LAPTOP_OS, laptop_os)
            intent.putExtra(DetailLaptop.LAPTOP_RAM, laptop_ram)
            intent.putExtra(DetailLaptop.LAPTOP_STORAGE, laptop_storage)
            intent.putExtra(DetailLaptop.LAPTOP_SCREEN, laptop_screen)
            intent.putExtra(DetailLaptop.LAPTOP_GPU, laptop_gpu)
            intent.putExtra(DetailLaptop.LAPTOP_FEATURES, laptop_features)
            intent.putExtra(DetailLaptop.LAPTOP_PRICE, laptop_price)
            holder.itemView.context.startActivity(intent)
        }
    }
}