package com.example.kotlinmvvm.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import com.example.kotlinmvvm.view.viewComponent.CustomDialog
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import java.lang.NullPointerException

class ViewManager {
    companion object {
        private var instance: ViewManager? = null

        init {
            try {
                instance = ViewManager()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun showSnackBar(view: View, body: String) {
        Snackbar.make(view, body, Snackbar.LENGTH_SHORT).show()
    }

    fun showDialog(context: Context, title: String, body: String) {
        val plainDialog = CustomDialog(context, title, body)
        plainDialog.show()
    }

}
