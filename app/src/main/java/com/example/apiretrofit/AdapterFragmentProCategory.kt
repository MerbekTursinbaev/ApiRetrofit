package com.example.apiretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiretrofit.databinding.ItemProductCategoryBinding
import com.example.apiretrofit.models.ProductCategory
import com.example.apiretrofit.ui.FragmentProductsCategory


class AdapterFragmentProCategory() : RecyclerView.Adapter<AdapterFragmentProCategory.FragmentProCategoryViewHolder>() {
    var onId : (id : Int) -> Unit = {}
    var models: List<ProductCategory> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class FragmentProCategoryViewHolder(var binding: ItemProductCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(model: ProductCategory) {
            binding.tvName.text = model.name
            binding.tvDescription.text = model.description
            binding.layout.setOnClickListener {
                var id = models[adapterPosition].id
                onId.invoke(id)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentProCategoryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_category, parent, false)
        var binding = ItemProductCategoryBinding.bind(view)
        return FragmentProCategoryViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FragmentProCategoryViewHolder, position: Int) {
        holder.populateModel(models[position])
    }
    override fun getItemCount() : Int = models.size
}