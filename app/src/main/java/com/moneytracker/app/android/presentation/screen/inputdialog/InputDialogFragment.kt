package com.moneytracker.app.android.presentation.screen.inputdialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.DialogFragment
import com.moneytracker.app.android.presentation.util.InputButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class InputDialogFragment: DialogFragment() {

    private val dialogViewModel: InputDialogViewModel by viewModel()
    private lateinit var dialogContext: Context

    fun InputDialogFragment() {

    }
    companion object {
        fun newInstance(context: Context): InputDialogFragment {
            val dialog = InputDialogFragment()
            dialog.dialogContext = context
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        val builder: AlertDialog.Builder = AlertDialog.Builder(dialogContext)

        val dialogView = ComposeView(dialogContext).apply {
                setContent {
                    val state = dialogViewModel.state
                    val buttonSpacing = 8.dp
                    InputDialogComposable(
                        state = state,
                        buttonSpacing = buttonSpacing,
                        onAction = dialogViewModel::onAction,
                        modifier = Modifier
                            .wrapContentSize()
                            .background(Color.Gray)
                            .padding(16.dp)
                    )
                }
            }
        builder.setView(dialogView)

        return builder.create()
    }

}