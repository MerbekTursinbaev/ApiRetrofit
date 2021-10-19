package com.example.apiretrofit.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apiretrofit.AdapterFragmentProCategory
import com.example.apiretrofit.MainViewModel
import com.example.apiretrofit.R
import com.example.apiretrofit.databinding.FragmentProductsCategoryBinding
import com.example.apiretrofit.resource.ResourceState
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentProductsCategory : Fragment(R.layout.fragment_products_category) {
    private lateinit var binding: FragmentProductsCategoryBinding
    private val viewModel : MainViewModel by viewModel()
    private var adapter = AdapterFragmentProCategory()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsCategoryBinding.bind(view)
        binding.recyclerView.adapter = adapter
        setData()
        viewModel.getProductCategory.observe(viewLifecycleOwner,{
            when(it.status){
                ResourceState.LOADING->{
                    binding.progress.isVisible = true
                }
                ResourceState.SUCCESS->{
                    binding.progress.isVisible = false
                    adapter.models = it.data!!
                }
                ResourceState.ERROR->{
                    binding.progress.isVisible = false
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
    fun positionItem(id : Int){
        var identif  = id.toString()
        val action = FragmentProductsCategoryDirections.actionFragmentProductsCategoryToFragmentCatalog(identif)
        findNavController().navigate(action)
    }
    private fun setData(){
        viewModel.getProductCategories()
    }
}