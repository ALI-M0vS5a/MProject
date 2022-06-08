package com.example.montypays.utils


import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.example.montypays.authentication.LogInFragment


fun LogInFragment.toast(message: String?) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}
fun ProgressBar.show(){
    visibility = View.VISIBLE
}
fun ProgressBar.hide(){
    visibility = View.GONE
}
