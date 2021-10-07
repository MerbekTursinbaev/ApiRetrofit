package com.example.apiretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofit.databinding.ItemSchoolClassBinding
import com.example.apiretrofit.models.SchoolClass


class SchoolClassAdapter : RecyclerView.Adapter<SchoolClassAdapter.SchoolClassViewHolder>() {

    var models: MutableList<SchoolClass> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class SchoolClassViewHolder(var binding: ItemSchoolClassBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(model: SchoolClass) {
            binding.tvName.text = model.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolClassViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_school_class, parent, false)
        var binding = ItemSchoolClassBinding.bind(view)
        return SchoolClassViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SchoolClassViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() : Int = models.size
}