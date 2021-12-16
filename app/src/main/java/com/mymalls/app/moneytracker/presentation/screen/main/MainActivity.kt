package com.mymalls.app.moneytracker.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mymalls.app.moneytracker.R
import com.mymalls.app.moneytracker.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
//private lateinit var mainViewModel: MainViewModel by viewModel()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}