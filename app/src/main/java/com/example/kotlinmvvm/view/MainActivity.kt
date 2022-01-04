package com.example.kotlinmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.databinding.ActivityMainBinding
import com.example.kotlinmvvm.model.Note
import com.example.kotlinmvvm.view.viewComponent.NoteAdapter
import com.example.kotlinmvvm.view.viewComponent.ViewManager
import com.example.kotlinmvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private val adapter by lazy {
        NoteAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        init()

        binding.button.setOnClickListener {
            if (binding.editText.text.isEmpty()) {
                ViewManager.showSnackBar(binding.root, "At least")
            } else {
                val text = binding.editText.text.toString()
                viewModel.addItem("$text title", "$text body")
                binding.editText.setText("")
            }
        }
    }

    private fun init() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        observers()
    }

    private fun observers() {
        val dataObserver: Observer<List<Note>> = Observer {
            adapter.submit(it)
        }
        viewModel.getList().observe(this, dataObserver)
    }
}