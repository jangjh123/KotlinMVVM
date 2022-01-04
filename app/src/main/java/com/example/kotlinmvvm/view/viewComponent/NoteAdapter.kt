package com.example.kotlinmvvm.view.viewComponent

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.NoteItemBinding
import com.example.kotlinmvvm.model.Note

class NoteAdapter : ListAdapter<Note, RecyclerView.ViewHolder>(CustomDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            NoteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val note = getItem(position) as Note
            holder.bind(note)
        }
    }

    fun submit(list: List<Note>) {
        submitList(list.toMutableList())

        // 참조값 비교
    }

    inner class ViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            with (binding) {
                textViewTitle.text = note.title
                textViewBody.text = note.body
            }
        }
    }
}