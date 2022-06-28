package com.moneytracker.app.android.presentation.screen.inputdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.DialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class InputDialogFragment: DialogFragment() {

    private val dialogViewModel: InputDialogViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val state = dialogViewModel.state
                val buttonSpacing = 8.dp

            }
        }
    }
}