package com.example.kotlinmvvm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.model.Note
import com.example.kotlinmvvm.view.viewComponent.NoteAdapter

class MainViewModel : ViewModel() {
    private val list: MutableLiveData<List<Note>> = MutableLiveData<List<Note>>()
    private val _list = mutableListOf<Note>()

    init {
        _list.apply {
            add(Note("example 1", "example 2"))
            add(Note("example 3", "example 4"))
            add(Note("example 5", "example 6"))
            list.postValue(_list)
        }
    }

    fun getList(): LiveData<List<Note>> {
        return list
    }

    fun addItem(title: String, body: String) {
        _list.add(Note(title, body))
        list.postValue(_list)
    }

    fun getNoteAdapter(): NoteAdapter? {
        return noteAdapter
    }
}