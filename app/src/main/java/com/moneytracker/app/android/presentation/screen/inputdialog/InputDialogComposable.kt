package com.moneytracker.app.android.presentation.screen.inputdialog

import androidx.compose.animation.shrinkVertically
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
import androidx.compose.ui.unit.sp
import com.moneytracker.app.android.presentation.util.*

@Composable
fun InputDialogComposable (
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    contentColumnRow: List<List<CalculatorKeypad>>,
    onAction: (InputDialogActions) -> Unit
){
    Box(modifier) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                modifier = Modifier
                    .weight(0.5F),
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
            )
            Row(
                modifier = Modifier
                    .weight(0.5F)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.LightGray),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                contentColumnRow.forEachIndexed { index, column ->
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .weight(1F),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {
                        column.forEach { rowButton ->
                            Row(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight()
                                    .weight(if(index.equals(4)) 0.8F else 1F)
                            ) {
                                InputButton(
                                    symbol = rowButton.symbol,
                                    modifier = Modifier
                                        .background(rowButton.backgroundColor)
                                        .weight(rowButton.weight)
                                        .aspectRatio(rowButton.aspectRatio),
                                    onClick = { onAction(rowButton.action) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

