package com.example.simplearithmetic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simplearithmetic.ui.theme.SimpleArithmeticTheme
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleArithmeticTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FirstInput()


                }
            }
        }
    }
}

@Composable
fun FirstInput(){
    var firstNumber by remember { mutableStateOf("0") }
    var secondNumber by remember { mutableStateOf("0") }
    var answer by  remember { mutableStateOf("1") }

    Column(modifier=Modifier.fillMaxSize(),horizontalAlignment=Alignment.CenterHorizontally,) {
        TextField(
            value = firstNumber,
            onValueChange = { firstNumber = it },
            label = { Text("0.0") },
        )
        TextField(
            value = secondNumber,
            onValueChange = { secondNumber = it },
            label = { Text("0.0") },
        )
        Row {

            Button(onClick = {
                answer = if (secondNumber == "0") {
                    "Invalid Operand"
                } else{
                    (firstNumber.toFloat()/ secondNumber.toFloat()).toString()
                }
            })
            {
                Text("/")
            }

            Button(onClick = {
                answer =(firstNumber.toFloat() * secondNumber.toFloat()).toString()
            })
            {
                Text("X")
            }
            Button(onClick = {
                answer =(firstNumber.toFloat() + secondNumber.toFloat()).toString()

            })
            {
                Text("+")
            }
            Button(onClick = {
                answer =(firstNumber.toFloat() - secondNumber.toFloat()).toString()

            })
            {
                Text("-")
            }
            Button(onClick = {
                answer =(firstNumber.toFloat().mod(secondNumber.toFloat())).toString()

            })
            {
                Text("%")
            }

        }
        Text(
            text=("%.2f".format(answer.toFloat()))
        )
    }
}

