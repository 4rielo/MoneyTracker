package com.moneytracker.app.android.presentation.screen.inputdialog

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.moneytracker.app.android.presentation.util.CalculatorOperation
import com.moneytracker.app.android.presentation.util.CalculatorState
import com.moneytracker.app.android.presentation.util.InputButton
import com.moneytracker.app.android.presentation.util.InputDialogActions

@Composable
fun InputDialogComposable (
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (InputDialogActions) -> Unit
){
    Box(modifier) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                InputButton(
                    symbol = "AC",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .background(Color.LightGray)
                        .weight(2f),
                    onClick = {
                        onAction(InputDialogActions.Clear)
                    }
                )
                InputButton(
                    symbol = "C",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.LightGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Delete)
                    }
                )
                InputButton(
                    symbol = "/",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color(R.color.holo_orange_light))
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                InputButton(
                    symbol = "7",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(7))
                    }
                )
                InputButton(
                    symbol = "8",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(8))
                    }
                )
                InputButton(
                    symbol = "9",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(9))
                    }
                )
                InputButton(
                    symbol = "*",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color(R.color.holo_orange_light))
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Operation(CalculatorOperation.Multiply))
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                InputButton(
                    symbol = "4",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(4))
                    }
                )
                InputButton(
                    symbol = "5",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(5))
                    }
                )
                InputButton(
                    symbol = "6",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(6))
                    }
                )
                InputButton(
                    symbol = "-",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color(R.color.holo_orange_light))
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Operation(CalculatorOperation.Subtract))
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                InputButton(
                    symbol = "1",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(1))
                    }
                )
                InputButton(
                    symbol = "2",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(2))
                    }
                )
                InputButton(
                    symbol = "3",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Number(3))
                    }
                )
                InputButton(
                    symbol = "+",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color(R.color.holo_orange_light))
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Operation(CalculatorOperation.Add))
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                InputButton(
                    symbol = "0",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .background(Color.DarkGray)
                        .weight(2f),
                    onClick = {
                        onAction(InputDialogActions.Number(0))
                    }
                )
                InputButton(
                    symbol = ".",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.DarkGray)
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Decimal)
                    }
                )
                InputButton(
                    symbol = "=",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color(R.color.holo_orange_light))
                        .weight(1f),
                    onClick = {
                        onAction(InputDialogActions.Calculate)
                    }
                )
            }
        }
    }
}

