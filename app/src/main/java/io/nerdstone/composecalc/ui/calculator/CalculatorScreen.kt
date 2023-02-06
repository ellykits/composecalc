package io.nerdstone.composecalc.ui.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.nerdstone.composecalc.ui.calculator.components.CalculatorButton
import io.nerdstone.composecalc.ui.calculator.model.ButtonData
import io.nerdstone.composecalc.ui.calculator.model.CalcOperation
import io.nerdstone.composecalc.ui.theme.ComposeCalcTheme

@Composable
fun CalculatorScreen(calculatorViewModel: CalculatorViewModel, modifier: Modifier = Modifier) {
  // TODO extend views to full screen and implement click action
  val calculatorUiState = remember { calculatorViewModel.calculatorUiState }.value

  CalculatorPage(
    calculatorUiState = calculatorUiState,
    onButtonClick = { buttonData ->
      calculatorViewModel.onEvent(CalculatorEvent.OnButtonClick(buttonData))
    },
    modifier = modifier
  )
}

@Composable
fun CalculatorRow(
  buttonDataList: List<ButtonData>,
  modifier: Modifier = Modifier,
  onButtonClick: (ButtonData) -> Unit
) {
  Row(modifier = modifier.fillMaxWidth()) {
    buttonDataList.forEach {
      CalculatorButton(
        buttonData = it,
        modifier = modifier.weight(it.weight),
        onButtonClick = onButtonClick
      )
    }
  }
}

@Composable
fun CalculatorPage(
  calculatorUiState: CalculatorUiState,
  onButtonClick: (ButtonData) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier.fillMaxWidth()) {
    Column(horizontalAlignment = Alignment.End, modifier = modifier.fillMaxWidth()) {
      Text(
        text = calculatorUiState.currentValue,
        fontSize = 32.sp,
        color = Color.Black,
        textAlign = TextAlign.End,
        modifier = modifier.wrapContentWidth(Alignment.End).padding(bottom = 4.dp),
        overflow = TextOverflow.Clip,
        maxLines = 1
      )
      Text(
        text =
          if (calculatorUiState.currentResult == null) ""
          else calculatorUiState.currentResult.toString(),
        fontSize = 26.sp,
        color = Color.LightGray,
        textAlign = TextAlign.Center,
        modifier = modifier.wrapContentWidth(Alignment.End).padding(bottom = 4.dp),
        overflow = TextOverflow.Clip,
        maxLines = 1
      )
    }

    Column {
      // First row of action buttons
      CalculatorRow(
        buttonDataList =
          listOf(
            ButtonData.ActionButtonData(text = "C", operation = CalcOperation.CLEAR),
            ButtonData.ActionButtonData(text = "( )", operation = CalcOperation.BRACKET),
            ButtonData.ActionButtonData(text = "%", operation = CalcOperation.PERCENTAGE),
            ButtonData.ActionButtonData(text = "/", operation = CalcOperation.DIVISION)
          ),
        onButtonClick = onButtonClick
      )
      // Second row
      CalculatorRow(
        buttonDataList =
          listOf(
            ButtonData.DigitButtonData(text = "7"),
            ButtonData.DigitButtonData(text = "8"),
            ButtonData.DigitButtonData(text = "9"),
            ButtonData.ActionButtonData(text = "+", operation = CalcOperation.ADDITION)
          ),
        onButtonClick = onButtonClick
      )
      // Third row
      CalculatorRow(
        buttonDataList =
          listOf(
            ButtonData.DigitButtonData(text = "4"),
            ButtonData.DigitButtonData(text = "5"),
            ButtonData.DigitButtonData(text = "6"),
            ButtonData.ActionButtonData(text = "-", operation = CalcOperation.SUBTRACTION)
          ),
        onButtonClick = onButtonClick
      )
      // Forth row
      CalculatorRow(
        buttonDataList =
          listOf(
            ButtonData.DigitButtonData(text = "1"),
            ButtonData.DigitButtonData(text = "2"),
            ButtonData.DigitButtonData(text = "3"),
            ButtonData.ActionButtonData(text = "*", operation = CalcOperation.MULTIPLICATION)
          ),
        onButtonClick = onButtonClick
      )
      // Fifth row
      CalculatorRow(
        buttonDataList =
          listOf(
            ButtonData.DigitButtonData(text = "."),
            ButtonData.DigitButtonData(text = "0"),
            ButtonData.DigitButtonData(text = "+-"),
            ButtonData.ResultButtonData()
          ),
        onButtonClick = onButtonClick
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPagePreview() {
  ComposeCalcTheme { CalculatorPage(CalculatorUiState(), {}) }
}
