package com.example.apiretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apiretrofit.databinding.FragmentCatalogBinding
import com.example.apiretrofit.databinding.ItemProductCatalogBinding
import com.example.apiretrofit.models.Product

class AdapterFragmentCatalog : RecyclerView.Adapter<AdapterFragmentCatalog.FragmentCatalogViewHolder>() {

    var models : List<Product> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    inner class FragmentCatalogViewHolder(var binding: ItemProductCatalogBinding): RecyclerView.ViewHolder(binding.root){
        fun populateModel(product: Product){
            binding.description.text = product.name
            binding.score.text = product.price.toString()
            Glide.with(binding.root).load(product.full_image).centerCrop().into(binding.productImage)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentCatalogViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_catalog, parent, false)
        var binding = ItemProductCatalogBinding.bind(view)
        return FragmentCatalogViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FragmentCatalogViewHolder, position: Int) {
        holder.populateModel(models[position])
    }
    override fun getItemCount(): Int = models.size
}