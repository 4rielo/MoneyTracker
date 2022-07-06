package com.moneytracker.app.android.presentation.screen.inputdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.DialogFragment
import com.moneytracker.app.android.presentation.util.InputButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class InputDialogFragment: DialogFragment() {

    private val dialogViewModel: InputDialogViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun defaultPreview() {
        ComposeView(requireContext()).apply {
            setContent {
                InputButton("4", Modifier, {})
            }
        }
    }

}