package io.nerdstone.composecalc.ui.calculator.model

import androidx.compose.ui.graphics.Color
import io.nerdstone.composecalc.ui.theme.GreyColor
import io.nerdstone.composecalc.ui.theme.OrangeColor

sealed class ButtonData(
  open val text: String,
  open val operation: CalcOperation? = null,
  val textColor: Color = Color.Black,
  val buttonBackgroundColor: Color = Color.White,
  val weight: Float = 0.25f
) {

  data class DigitButtonData(override val text: String) :
    ButtonData(
      text = text,
      operation = null,
      textColor = Color.Black,
      buttonBackgroundColor = Color.White
    )

  data class ActionButtonData(
    override val text: String,
    override val operation: CalcOperation,
  ) :
    ButtonData(
      text = text,
      operation = operation,
      textColor = Color.White,
      buttonBackgroundColor = GreyColor
    )

  class ResultButtonData :
    ButtonData(
      text = "=",
      operation = CalcOperation.COMPUTATION,
      textColor = Color.White,
      buttonBackgroundColor = OrangeColor
    )
}
