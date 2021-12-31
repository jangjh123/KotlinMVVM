package com.example.kotlinmvvm.view.viewComponent

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kotlinmvvm.databinding.DialogPlainBinding

class CustomDialog(_title: String, _body: String) : DialogFragment() {
    private lateinit var binding: DialogPlainBinding
    private val title = _title
    private val body = _body

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogPlainBinding.inflate(inflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.title = title
        binding.body = body

        binding.buttonPlainConfirm.setOnClickListener {
            dismiss()
        }

        return binding.root
    }
}