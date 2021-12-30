package com.example.kotlinmvvm.view.viewComponent

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.databinding.DialogPlainBinding

class CustomDialog(context: Context, private val title: String, private val body: String) : Dialog(context) {
    private lateinit var binding: DialogPlainBinding

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)

        binding = setContentView(context as Activity, R.layout.dialog_plain)

        val lp = WindowManager.LayoutParams()
        lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
        lp.dimAmount = 0.8f
        window!!.attributes = lp

        binding.textViewPlainTitle.text = title
        binding.textViewPlainBody.text = body
        binding.buttonPlainConfirm.setOnClickListener {
            this.dismiss()
        }
    }
}