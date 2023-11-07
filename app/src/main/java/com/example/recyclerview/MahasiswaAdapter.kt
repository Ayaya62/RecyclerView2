package com.example.recyclerview

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.MahasiswaBinding

typealias onClickMahasiswa = (Mahasiswa) -> Unit

class MahasiswaAdapter (private val listMahasiswa: List<Mahasiswa>,
    private val onClickMahasiswa: onClickMahasiswa) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>(){

        inner class MahasiswaViewHolder(private val binding: MahasiswaBinding
        ):
                RecyclerView.ViewHolder(binding.root){
                    fun bind(data:Mahasiswa){
                        with(binding){
                            namaMahasiswa.text = data.nama
                            nim.text = data.nim
                            ipk.text = data.ipk

                            itemView.setOnClickListener(){
                                onClickMahasiswa(data)
                            }
                        }
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val binding = MahasiswaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return MahasiswaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        holder.bind(listMahasiswa[position])
    }

}