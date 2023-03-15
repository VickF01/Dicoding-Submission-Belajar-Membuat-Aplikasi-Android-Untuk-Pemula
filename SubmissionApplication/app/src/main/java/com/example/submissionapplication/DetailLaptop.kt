package com.example.submissionapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.example.submissionapplication.databinding.ActivityDetailLaptopBinding
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class DetailLaptop : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val LAPTOP_HIGHLIGHTS = "laptop_highlights"
        const val LAPTOP_PICTURE = "laptop_picture"
        const val LAPTOP_CPU = "laptop_cpu"
        const val LAPTOP_OS = "laptop_os"
        const val LAPTOP_RAM = "laptop_ram"
        const val LAPTOP_STORAGE = "laptop_storage"
        const val LAPTOP_SCREEN = "laptop_screen"
        const val LAPTOP_GPU = "laptop_gpu"
        const val LAPTOP_FEATURES = "laptop_features"
        const val LAPTOP_PRICE = "laptop_price"
    }

    private lateinit var binding: ActivityDetailLaptopBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailLaptopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val laptop_name = intent.getStringExtra(EXTRA_NAME)
        val laptop_highlights = intent.getStringExtra(LAPTOP_HIGHLIGHTS)
        val laptop_picture = intent.getStringExtra(LAPTOP_PICTURE)
        val laptop_cpu = intent.getStringExtra(LAPTOP_CPU)
        val laptop_os = intent.getStringExtra(LAPTOP_OS)
        val laptop_ram = intent.getStringExtra(LAPTOP_RAM)
        val laptop_storage = intent.getStringExtra(LAPTOP_STORAGE)
        val laptop_screen = intent.getStringExtra(LAPTOP_SCREEN)
        val laptop_gpu = intent.getStringExtra(LAPTOP_GPU)
        val laptop_features = intent.getStringExtra(LAPTOP_FEATURES)
        val laptop_price = intent.getIntExtra(LAPTOP_PRICE, 0)

        binding.laptopNameDetail.text = laptop_name
        binding.laptopHighlightsDetail.text = laptop_highlights
        Glide.with(applicationContext).load(laptop_picture).into(binding.laptopPictureDetail)
        binding.laptopCpuDetail.text = laptop_cpu
        binding.laptopOsDetail.text = laptop_os
        binding.laptopRamDetail.text = laptop_ram
        binding.laptopStorageDetail.text = laptop_storage
        binding.laptopScreenDetail.text = laptop_screen
        binding.laptopGpuDetail.text = laptop_gpu
        binding.laptopFeaturesDetail.text = laptop_features
        binding.laptopPrice.text = formatRupiah(laptop_price.toDouble())

        binding.actionShare.setOnClickListener {
            val shareLaptop = Intent(Intent.ACTION_SEND)
            shareLaptop.putExtra(Intent.EXTRA_TEXT, "Hey, this $laptop_name is a good laptop for me!")
            shareLaptop.type = "text/plain"
            startActivity(Intent.createChooser(shareLaptop, "Sent To:"))
        }
    }
    private fun formatRupiah(number: Double): String{
        val localeID = Locale("in", "ID");
        val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}