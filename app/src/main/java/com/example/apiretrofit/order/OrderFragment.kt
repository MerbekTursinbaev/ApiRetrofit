package com.example.apiretrofit.order

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.apiretrofit.AdapterOrderCategory
import com.example.apiretrofit.MainViewModel
import com.example.apiretrofit.R
import com.example.apiretrofit.databinding.FragmentOrderBinding
import com.example.apiretrofit.resource.ResourceState
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderFragment: Fragment(R.layout.fragment_order) {
    lateinit var binding: FragmentOrderBinding
    private val viewModel: MainViewModel by viewModel()
    var adapter = AdapterOrderCategory()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)
        binding.recyclerCategory.adapter = adapter
        viewModel.getProductCategories()
        viewModel.getProductCategory.observe(viewLifecycleOwner,{
            when(it.status){
                ResourceState.LOADING->{

                }
                ResourceState.SUCCESS->{
                    adapter.models = it.data!!
                }
                ResourceState.ERROR->{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}