package com.example.kotlinmvvm.view.viewComponent

import android.provider.ContactsContract
import androidx.recyclerview.widget.DiffUtil
import com.example.kotlinmvvm.model.Note

class CustomDiffUtil : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}