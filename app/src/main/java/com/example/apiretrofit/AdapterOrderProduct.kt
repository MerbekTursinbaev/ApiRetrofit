package com.example.apiretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apiretrofit.databinding.ItemOrderCategoryBinding
import com.example.apiretrofit.databinding.ItemOrderProductBinding
import com.example.apiretrofit.models.Product
import com.example.apiretrofit.models.ProductCategory

class AdapterOrderProduct : RecyclerView.Adapter<AdapterOrderProduct.OrderProductViewHolder>() {
    var models: List<Product> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class OrderProductViewHolder(var binding: ItemOrderProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(product: Product) {
            binding.description.text = product.description
            Glide.with(binding.root).load(product.full_image).centerCrop().into(binding.productImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderProductViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_order_product, parent, false)
        var binding = ItemOrderProductBinding.bind(view)
        return OrderProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderProductViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int = models.size
}