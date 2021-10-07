package com.example.apiretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apiretrofit.databinding.ActivityMainBinding
import com.example.apiretrofit.models.SchoolClass
import com.example.apiretrofit.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NetworkListener {
    private val adapter = SchoolClassAdapter()
    private lateinit var networkHelper: NetworkHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        networkHelper = NetworkHelper(ApiClient.getClient())
        setData()
    }
    private fun setData(){
        networkHelper.getClasses(this)
    }

    override fun onSchoolClassesResponse(models: List<SchoolClass>?) {
       adapter.models = models as MutableList<SchoolClass>
    }

    override fun onSchoolClassesFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}