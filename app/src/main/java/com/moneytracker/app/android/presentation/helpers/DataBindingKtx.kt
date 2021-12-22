package com.moneytracker.app.android.presentation.helpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.moneytracker.app.android.BR

fun <T : ViewDataBinding> AppCompatActivity.setContentViewBinding(
    @LayoutRes layoutId: Int,
    viewModel: ViewModel? = null,
    block: T.() -> Unit = {}
): T {
    return DataBindingUtil.setContentView<T>(this, layoutId).apply {
        lifecycleOwner = this@setContentViewBinding

        setVariable(BR.viewModel, viewModel)
        block(this)
        executePendingBindings()
    }
}

fun <T : ViewDataBinding> Fragment.setContentViewBinding(
    @LayoutRes layoutId: Int,
    inflater: LayoutInflater,
    container: ViewGroup?,
    viewModel: ViewModel? = null
): T {
    return DataBindingUtil.inflate<T>(inflater, layoutId, container, false).apply {
        lifecycleOwner = this@setContentViewBinding
        setVariable(BR.viewModel, viewModel)
        executePendingBindings()
    }
}