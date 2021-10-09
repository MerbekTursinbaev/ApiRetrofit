package com.example.apiretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofit.databinding.ItemSchoolClassBinding
import com.example.apiretrofit.models.User


class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    var models: MutableList<User> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class UsersViewHolder(var binding: ItemSchoolClassBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(model: User) {
            binding.tvName.text = model.status.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_school_class, parent, false)
        var binding = ItemSchoolClassBinding.bind(view)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() : Int = models.size
}