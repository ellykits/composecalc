package io.nerdstone.composecalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import io.nerdstone.composecalc.ui.calculator.CalculatorScreen
import io.nerdstone.composecalc.ui.calculator.CalculatorViewModel
import io.nerdstone.composecalc.ui.theme.ComposeCalcTheme

class MainActivity : ComponentActivity() {
  private val calculatorViewModel by viewModels<CalculatorViewModel>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeCalcTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          CalculatorScreen(calculatorViewModel)
        }
      }
    }
  }
}
