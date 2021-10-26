package com.example.apiretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofit.databinding.ItemOrderCategoryBinding
import com.example.apiretrofit.models.ProductCategory

class AdapterOrderCategory : RecyclerView.Adapter<AdapterOrderCategory.OrderCategoryViewHolder>(){
    var models : List<ProductCategory> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    inner class OrderCategoryViewHolder(var binding : ItemOrderCategoryBinding): RecyclerView.ViewHolder(binding.root){
        fun populateModel(productCategory: ProductCategory){
            binding.orderCategory.text = productCategory.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderCategoryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_order_category,parent,false)
        var binding = ItemOrderCategoryBinding.bind(view)
        return OrderCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderCategoryViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int = models.size
}