package com.mymalls.app.android.presentation.helpers.extensions

import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/*fun Fragment.copyToClipBoard(text: String) {
    activity?.let{
        val clipboard = it.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clip = ClipData.newPlainText(AppConstants.EMPTY_STRING, text)
        clipboard.setPrimaryClip(clip)
        it.toast(text)
    }
}*/


fun Fragment.openBrowser(url: String) {
    activity?.let{
        if (url.isNotBlank()) {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW , Uri.parse(url))
                startActivity(browserIntent)
            } catch (e: Exception) {
                it.toast("Application Not Found")
            }
        }
    }
}

inline fun <reified T : Activity> Fragment.startActivity(block: Intent.() -> Unit = {}) {
    this.context?.startActivity<T>(block)
}

fun FragmentManager?.isBackstackEmpty(): Boolean = this?.backStackEntryCount == 0

fun FragmentManager?.isBackstackNotEmpty(): Boolean = !this.isBackstackEmpty()