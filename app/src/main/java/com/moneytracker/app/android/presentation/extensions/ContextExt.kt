package com.mymalls.app.android.presentation.helpers.extensions

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import com.moneytracker.app.android.R

fun Context.toast(message: Int): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }

fun Context.toast(message: CharSequence): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }

inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    block(intent)
    startActivity(intent)
}

fun Context.getDialog(
    @LayoutRes layoutRes: Int,
    @StyleRes styleRes: Int? = null,
    configBlock: Dialog.() -> Unit
): Dialog {
    return Dialog(this, styleRes ?: R.style.AppTheme_Dialog_Custom).apply {
        setContentView(layoutRes)
        configBlock()
        show()
    }
}