package com.example.kotlinmvvm.view

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.databinding.ActivityMainBinding
import com.example.kotlinmvvm.model.Note
import com.example.kotlinmvvm.view.viewComponent.ViewManager
import com.example.kotlinmvvm.viewModel.MainViewModel
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()

        binding.button.setOnClickListener {
            if (binding.editText.text.isEmpty()) {
                ViewManager.showSnackBar(binding.root, "At least")
            } else {
                val text = binding.editText.text.toString()
                viewModel.addItem("title + $text", "body + $text")
                binding.editText.setText("")
            }
        }
    }
    private fun init() {
        observers()
        viewInit()
    }

    private fun observers() {
        val noteObserver: Observer<List<Note>> = Observer {
            viewModel.getNoteAdapter()?.notifyDataSetChanged()
        }
        viewModel.getList().observe(this, noteObserver)
    }

    private fun viewInit() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = viewModel.getNoteAdapter()
        Log.d("로그", binding.recyclerView.adapter.toString())
    }
}