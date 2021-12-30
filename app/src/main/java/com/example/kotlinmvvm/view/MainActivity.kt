package com.example.kotlinmvvm.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
//            ViewManager.showDialog(this, "씹새야", "개새야")
//            ViewManager.showSnackBar(binding.root, "asd")
            val viewManager = ViewManager()
            viewManager.showSnackBar(binding.root, "Tltvkf")
            viewManager.showDialog(this, "qwe,", "qweasd")
        }

    }
}