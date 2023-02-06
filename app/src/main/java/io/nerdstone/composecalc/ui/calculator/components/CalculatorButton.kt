package io.nerdstone.composecalc.ui.calculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.nerdstone.composecalc.ui.calculator.model.ButtonData
import io.nerdstone.composecalc.ui.calculator.model.CalcOperation

@Composable
fun CalculatorButton(
  buttonData: ButtonData,
  modifier: Modifier = Modifier,
  onButtonClick: (ButtonData) -> Unit
) {
  Box(
    contentAlignment = Alignment.Center,
    modifier =
      modifier
        .border(width = 1.4.dp, color = Color.LightGray.copy(alpha = 0.2f), shape = RectangleShape)
        .background(buttonData.buttonBackgroundColor)
        .size(64.dp)
        .clickable { onButtonClick(buttonData) }
  ) {
    Text(
      text = buttonData.text,
      color = buttonData.textColor,
      fontWeight = FontWeight.Bold,
      fontSize = 20.sp
    )
  }
}

@Preview(showBackground = true)
@Composable
fun CalculatorButtonDigitPreview() {
  CalculatorButton(buttonData = ButtonData.DigitButtonData(text = "7"), onButtonClick = {})
}

@Preview(showBackground = true)
@Composable
fun CalculatorButtonActionPreview() {
  CalculatorButton(
    buttonData = ButtonData.ActionButtonData(text = "C", operation = CalcOperation.CLEAR),
    onButtonClick = {}
  )
}

@Preview(showBackground = true)
@Composable
fun CalculatorButtonResultPreview() {
  CalculatorButton(buttonData = ButtonData.ResultButtonData(), onButtonClick = {})
}
