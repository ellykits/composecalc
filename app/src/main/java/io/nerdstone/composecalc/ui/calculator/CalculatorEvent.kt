package io.nerdstone.composecalc.ui.calculator

import io.nerdstone.composecalc.ui.calculator.model.ButtonData

sealed class CalculatorEvent {

  data class OnButtonClick(val buttonData: ButtonData) : CalculatorEvent()

  object ComputeResult : CalculatorEvent()
}
