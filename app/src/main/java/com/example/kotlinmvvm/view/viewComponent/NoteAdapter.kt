package com.example.kotlinmvvm.view.viewComponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.model.Note

class NoteAdapter(arr: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private val mArr = arr

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.mTextViewTitle.text = mArr[position].title
        holder.mTextViewBody.text = mArr[position].body
    }

    override fun getItemCount(): Int {
        return if (mArr.isEmpty()) {
            0
        } else {
            mArr.size
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mTextViewTitle: TextView = view.findViewById(R.id.textViewTitle)
        val mTextViewBody: TextView = view.findViewById(R.id.textViewBody)

    }
}