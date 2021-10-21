package com.example.apiretrofit.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.apiretrofit.AdapterFragmentCatalog
import com.example.apiretrofit.MainViewModel
import com.example.apiretrofit.R
import com.example.apiretrofit.databinding.FragmentCatalogBinding
import com.example.apiretrofit.resource.ResourceState
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentCatalog(): Fragment(R.layout.fragment_catalog) {
    private val safeArgs : FragmentCatalogArgs by navArgs()
    lateinit var binding: FragmentCatalogBinding
    private val viewModel: MainViewModel by viewModel()
    private var adapter  =  AdapterFragmentCatalog()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id  = safeArgs.identif
        binding = FragmentCatalogBinding.bind(view)
        viewModel.getProduct(id)
        binding.recyclerView.adapter = adapter
        binding = FragmentCatalogBinding.bind(view)
        viewModel.getProduct.observe(viewLifecycleOwner,{
            when(it.status){
                ResourceState.LOADING->{
                    binding.progress.isVisible = true
                }
                ResourceState.SUCCESS->{
                    binding.progress.isVisible = false
                    adapter.models = it.data!!
                }
                ResourceState.ERROR->{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}