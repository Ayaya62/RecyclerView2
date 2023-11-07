package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapterMahasiswa = MahasiswaAdapter(generatemahasiswa()){
            mahasiswa -> Toast.makeText(this@MainActivity, "You clicked on ${mahasiswa.nama}", Toast.LENGTH_SHORT)
        }

        with(binding){
            rvMahasiswa.apply {
                adapter = adapterMahasiswa
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }

    }

    fun generatemahasiswa(): List<Mahasiswa>{
        return listOf(
            Mahasiswa(nama = "Haerin", nim="12345/AA/21342", ipk = "3", R.drawable.haerin),
            Mahasiswa(nama = "karina", nim="12345/AA/21342", ipk = "4", R.drawable.karina),
            Mahasiswa(nama = "Gaeul", nim="12345/AA/21342", ipk = "3", R.drawable.gaeul),
            Mahasiswa(nama = "Sakura", nim="12345/AA/21342", ipk = "3", R.drawable.sakura)
        )
    }
}