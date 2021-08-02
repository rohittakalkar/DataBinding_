package com.example.databinding_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databinding_.databinding.ActivityMainBinding
import com.example.databinding_.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var mainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
////        Step 1 : set the view property and events programmatically

        mainViewModel.quoteLiveData.observe(this, {
//            no need to use findViewById now
            binding.tvQuote.text = it
        })
//
        binding.btnQuote.setOnClickListener {
            mainViewModel.updateQuote()
        }

//        Step 2 : Using data binding library to perform step 1

        binding.mainviewmodel = mainViewModel
        binding.lifecycleOwner = this
    }
}