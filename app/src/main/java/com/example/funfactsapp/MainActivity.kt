package com.example.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.funfactsapp.ui.theme.FunFactsAppTheme

import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsAppTheme {
                Scaffold(modifier = Modifier.fillMaxHeight()) { innerPadding ->
                    val funFactsArray = arrayOf(
                        "Bananas are berries, but strawberries aren't: Botanically speaking, bananas qualify as berries, while strawberries do not. A berry has seeds inside, and bananas fit that definition!",
                        "Sharks existed before trees: Sharks have been around for more than 400 million years, while trees only appeared about 350 million years ago.",
                        "A day on Venus is longer than a year on Venus: Venus rotates so slowly that it takes longer to complete one full spin (a day) than it does to orbit the sun (a year).\n" +
                                "\n",
                        "Octopuses have three hearts: Two pump blood to the gills, while one pumps it to the rest of the body. When they swim, the heart that pumps to the body actually stops beating!"
                    )

                    Greeting(
                        funfacts = funFactsArray,
                        modifier = Modifier.fillMaxSize().background(Color.Black)
//                        verticalArrangement = Alignment.CenterVertically
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(funfacts: Array<String>, modifier: Modifier = Modifier) {

    var num by remember { mutableStateOf(Random.nextInt(0, 4))}

    Column(modifier = Modifier.fillMaxHeight().padding(16.dp).wrapContentSize(Alignment.Center).background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "${funfacts[num % funfacts.size]}",
            modifier =Modifier
                .wrapContentWidth()
                .wrapContentHeight(align = Alignment.CenterVertically),
//            background = Color.Black,
//            textAlign = TextAlign.Center

            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.Cyan,
                background = Color.Black,
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { num += 1 }) {
            Text("Next Fact!")
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}

val funFactsArray = arrayOf(
    "Bananas are berries, but strawberries aren't: Botanically speaking, bananas qualify as berries, while strawberries do not. A berry has seeds inside, and bananas fit that definition!",
    "Sharks existed before trees: Sharks have been around for more than 400 million years, while trees only appeared about 350 million years ago.",
    "A day on Venus is longer than a year on Venus: Venus rotates so slowly that it takes longer to complete one full spin (a day) than it does to orbit the sun (a year).\n" +
            "\n",
    "Octopuses have three hearts: Two pump blood to the gills, while one pumps it to the rest of the body. When they swim, the heart that pumps to the body actually stops beating!"
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunFactsAppTheme {
        Greeting(funfacts = funFactsArray, modifier = Modifier.fillMaxSize())
    }
}