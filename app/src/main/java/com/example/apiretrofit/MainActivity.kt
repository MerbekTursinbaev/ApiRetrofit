package com.example.apiretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apiretrofit.models.User
import com.example.apiretrofit.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NetworkListener {
    private val adapter = UsersAdapter()
    private lateinit var networkHelper: NetworkHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        networkHelper = NetworkHelper(ApiClient.getClient())
        setData()
    }
    private fun setData(){
        networkHelper.getUsers(this, User())
    }

    override fun onUsersResponse(models: List<User>?) {
       adapter.models = models as MutableList<User>
    }
    override fun onUsersFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}