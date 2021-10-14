package com.example.apiretrofit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apiretrofit.databinding.FragmentMainBinding
import com.example.apiretrofit.models.LoginResponse
import com.example.apiretrofit.models.User
import com.example.apiretrofit.retrofit.ApiClient

class FragmentMain : Fragment(R.layout.fragment_main) , NetworkListener{
    lateinit var networkHelper:NetworkHelper
    lateinit var binding: FragmentMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        networkHelper = NetworkHelper(ApiClient.getClient())
        binding = FragmentMainBinding.bind(view)
        binding.button.setOnClickListener {
            if(binding.hintEmail.text.isEmpty() || binding.hintPassword.text.isEmpty()){
                Toast.makeText(requireContext(), "Qatorlarni to'ldiring!", Toast.LENGTH_SHORT).show()
            }else{
                var status = true
                var username = binding.hintEmail.text.toString()
                var password = binding.hintPassword.text.toString()
                var user = User(status,username,password)
                setData(user)
            }
        }
    }
    private fun setData(user: User){
        networkHelper.getUsers( this ,user)
    }

    override fun onUsersResponse(models: LoginResponse?) {
        if(models!!.succesful){
            Toast.makeText(requireContext(), models.code.toString(), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentCategory)
        }
    }

    override fun onUsersFailure(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}