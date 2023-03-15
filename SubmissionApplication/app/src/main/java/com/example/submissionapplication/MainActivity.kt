package com.example.submissionapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvLaptop: RecyclerView
    private val list = ArrayList<Laptop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvLaptop = binding.rvLaptop
        rvLaptop.setHasFixedSize(true)

        list.addAll(getData())
        showRecyclerView()
    }

    private fun showRecyclerView() {
        rvLaptop.layoutManager = LinearLayoutManager(this)
        val listLaptopAdapter = ListLaptopAdapter(list)
        rvLaptop.adapter = listLaptopAdapter
    }

    private fun getData(): ArrayList<Laptop> {
        val laptop_name = resources.getStringArray(R.array.laptop_name)
        val laptop_highlights = resources.getStringArray(R.array.laptop_highlights)
        val laptop_picture = resources.getStringArray(R.array.laptop_picture)
        val laptop_cpu = resources.getStringArray(R.array.laptop_cpu)
        val laptop_os = resources.getStringArray(R.array.laptop_os)
        val laptop_ram = resources.getStringArray(R.array.laptop_ram)
        val laptop_storage = resources.getStringArray(R.array.laptop_storage)
        val laptop_screen = resources.getStringArray(R.array.laptop_screen)
        val laptop_gpu = resources.getStringArray(R.array.laptop_gpu)
        val laptop_features = resources.getStringArray(R.array.laptop_features)
        val laptop_price = resources.getIntArray(R.array.laptop_price)
        val listLaptop = ArrayList<Laptop>()
        for (i in laptop_name.indices) {
            val laptop = Laptop(laptop_name[i], laptop_highlights[i], laptop_picture[i], laptop_cpu[i], laptop_os[i], laptop_ram[i], laptop_storage[i], laptop_screen[i], laptop_gpu[i], laptop_features[i], laptop_price[i])
            listLaptop.add(laptop)
        }
        return listLaptop
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}