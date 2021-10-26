package com.example.apiretrofit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apiretrofit.databinding.FragmentCategoryBinding

class FragmentCategory: Fragment(R.layout.fragment_category) {

    lateinit var binding: FragmentCategoryBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)
        binding.catalog.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentCategory_to_fragmentProductsCategory)
        }
        binding.order.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentCategory_to_orderFragment)
        }
    }
}