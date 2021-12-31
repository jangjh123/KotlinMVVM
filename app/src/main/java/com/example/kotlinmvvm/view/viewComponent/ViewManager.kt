package com.example.kotlinmvvm.view.viewComponent

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.view.viewComponent.CustomDialog
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import java.lang.NullPointerException

object ViewManager {

    private lateinit var progress: ProgressDlg

    fun showSnackBar(view: View, body: String) {
        Snackbar.make(view, body, Snackbar.LENGTH_SHORT).show()
    }

    fun showDialog(fragmentManager: FragmentManager, title: String, body: String) {
        val dialog = CustomDialog(title, body)
        dialog.dialog?.setCanceledOnTouchOutside(false)
        dialog.show(fragmentManager, "CustomDialog")
    }

    fun showProgress(context: Context) {
        progress = ProgressDlg(context)
        progress.setCanceledOnTouchOutside(false)
        progress.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        progress.show()
    }

    fun dismissProgress() {
        progress.dismiss()
    }
}
