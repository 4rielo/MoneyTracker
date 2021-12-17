package com.mymalls.app.moneytracker.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.mymalls.app.moneytracker.R
import com.mymalls.app.moneytracker.databinding.ActivityMainBinding
import com.mymalls.app.moneytracker.presentation.helpers.setContentViewBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = setContentViewBinding(R.layout.activity_main,mainViewModel)

        observeHello()
    }

    private fun observeHello(){
        mainViewModel.hello.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}