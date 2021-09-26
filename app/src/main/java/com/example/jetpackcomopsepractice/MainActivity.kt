package com.example.jetpackcomopsepractice

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomopsepractice.ui.theme.JetPackComopsePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComopsePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextInputArea()
                }
            }
        }
    }
}

@Composable
fun CheckBox2() {
    var state by remember {
        mutableStateOf(false)
    }
    
    Column {
        Text(text = "checked:" + state, style = TextStyle(color = Color.Red, fontSize = 12.sp))
        Row {
            Checkbox(checked = state, onCheckedChange = {
                state = it
            }, modifier = Modifier.size(20.dp, 20.dp))
            Text(text = "Checkbox", style = TextStyle(fontSize = 12.sp))
        }
    }
}

@Composable
fun Greets(){
    val radio = listOf("a","b","c")
    var message by remember {
        mutableStateOf("Hello")
    } 
    Column {
        Text(text = "selected")

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun TextInputArea() {
    var input by remember {
        mutableStateOf("0")
    }
    var message by remember {
        mutableStateOf("Hello!")
    }

    Column {
        Text(
            text = message, style = TextStyle(
                color = Color.Red, fontSize = 14.sp
            )
        )
        TextField(value = input, textStyle = TextStyle(fontSize = 14.sp), onValueChange = {
            input = it
        })
        Button(onClick = {
            val number = input.toInt()
            var total = 0
            (1..number).forEach {
                total += it
            }
            message = total.toString()

        }) {
            Text(
                text = "Click", style = TextStyle(
                    color = Color.White, fontSize = 14.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComopsePracticeTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Column {
                Greeting("Android")
                CheckBox2()
            }
        }
    }
}