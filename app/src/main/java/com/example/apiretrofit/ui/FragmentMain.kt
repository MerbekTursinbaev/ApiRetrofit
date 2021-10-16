package com.example.apiretrofit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apiretrofit.databinding.FragmentMainBinding
import com.example.apiretrofit.models.User
import com.example.apiretrofit.resource.ResourceState
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMain : Fragment(R.layout.fragment_main) {
    lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.button.setOnClickListener {
            if (binding.hintEmail.text.isEmpty() || binding.hintPassword.text.isEmpty()) {
                Toast.makeText(requireContext(), "Qatorlarni to'ldiring!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                var status = true
                var username = binding.hintEmail.text.toString()
                var password = binding.hintPassword.text.toString()
                var user = User(status, username, password)
                setData(user)
            }
        }
        viewModel.getLogins.observe(viewLifecycleOwner, {
            when (it.status) {
                ResourceState.LOADING -> {
                    binding.progressBar.isVisible = true
                }
                ResourceState.SUCCESS -> {
                    binding.progressBar.isVisible = false
                    findNavController().navigate(R.id.action_fragmentMain_to_fragmentCategory)
                }
                ResourceState.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setData(user: User) {
        viewModel.getLogin(user)
    }
}