package io.nerdstone.composecalc.ui.calculator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.nerdstone.composecalc.ui.calculator.model.ButtonData
import io.nerdstone.composecalc.ui.calculator.model.CalcOperation

class CalculatorViewModel : ViewModel() {

  val calculatorUiState: MutableState<CalculatorUiState> = mutableStateOf(CalculatorUiState())
  // Calculator business logic goes here

  fun onEvent(calculatorEvent: CalculatorEvent) {
    when (calculatorEvent) {
      is CalculatorEvent.OnButtonClick -> {
        calculatorUiState.value =
          calculatorUiState.value.copy(
            currentValue =
              retrieveCurrentValue(calculatorUiState.value.currentValue, calculatorEvent.buttonData)
          )
      }
      CalculatorEvent.ComputeResult -> TODO("Perform calculation and show result")
    }
  }

  private fun retrieveCurrentValue(currentValue: String?, buttonData: ButtonData): String {
    return when (buttonData.operation) {
      CalcOperation.ADDITION,
      CalcOperation.SUBTRACTION,
      CalcOperation.MULTIPLICATION,
      CalcOperation.PERCENTAGE,
      CalcOperation.DIVISION,
      CalcOperation.DECIMAL -> ""
      CalcOperation.CLEAR -> ""
      else -> ""
    }
  }
}
