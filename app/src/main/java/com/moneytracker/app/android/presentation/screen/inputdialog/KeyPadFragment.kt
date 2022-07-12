package com.moneytracker.app.android.presentation.screen.inputdialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.moneytracker.app.android.presentation.util.CalculatorKeypad
import com.moneytracker.app.android.presentation.util.CalculatorOperation
import com.moneytracker.app.android.presentation.util.InputDialogActions
import org.koin.androidx.viewmodel.ext.android.viewModel

class KeyPadFragment: Fragment() {

    private val keyPadViewModel: KeyPadViewModel by viewModel()
    private lateinit var dialogContext: Context

    private val keypad: List<List<CalculatorKeypad>> = listOf(
        listOf(
            CalculatorKeypad(
                symbol = "7",
                action = InputDialogActions.Number(7),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = "4",
                action = InputDialogActions.Number(4),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = "1",
                action = InputDialogActions.Number(1),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = ".",
                action = InputDialogActions.Decimal,
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            )
        ),
        listOf(
            CalculatorKeypad(
                symbol = "8",
                action = InputDialogActions.Number(8),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = "5",
                action = InputDialogActions.Number(5),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = "2",
                action = InputDialogActions.Number(2),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = "0",
                action = InputDialogActions.Number(0),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            )
        ),
        listOf(
            CalculatorKeypad(
                symbol = "9",
                action = InputDialogActions.Number(9),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = "6",
                action = InputDialogActions.Number(6),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = "3",
                action = InputDialogActions.Number(3),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            ),
            CalculatorKeypad(
                symbol = "<-",
                action = InputDialogActions.Delete,
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.DarkGray
            )
        ),
        listOf(
            CalculatorKeypad(
                symbol = "/",
                action = InputDialogActions.Operation(CalculatorOperation.Divide),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.Blue
            ),
            CalculatorKeypad(
                symbol = "*",
                action = InputDialogActions.Operation(CalculatorOperation.Multiply),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.Blue
            ),
            CalculatorKeypad(
                symbol = "-",
                action = InputDialogActions.Operation(CalculatorOperation.Subtract),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.Blue
            ),
            CalculatorKeypad(
                symbol = "+",
                action = InputDialogActions.Operation(CalculatorOperation.Add),
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.Blue
            ),
            CalculatorKeypad(
                symbol = "=",
                action = InputDialogActions.Calculate,
                aspectRatio = 1F,
                weight = 1F,
                backgroundColor = Color.Blue
            ),
        )
    )

    companion object {
        fun newInstance(context: Context): Fragment {
            val dialog = KeyPadFragment()
            dialog.dialogContext = context
            return dialog
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dialogView = ComposeView(dialogContext).apply {
            setContent {
                val state = keyPadViewModel.state
                val buttonSpacing = 8.dp
                InputDialogComposable(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = keyPadViewModel::onAction,
                    modifier = Modifier
                        .wrapContentSize()
                        .background(Color.Gray)
                        .padding(16.dp),
                    contentColumnRow = keypad
                )
            }
        }
        return dialogView
    }
}