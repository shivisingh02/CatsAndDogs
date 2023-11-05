package com.example.catsanddogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.catsanddogs.data.Animal
import com.example.catsanddogs.data.FakeRepository
import com.example.catsanddogs.ui.theme.CatsAndDogsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatsAndDogsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    val animals = FakeRepository().loadData()
    LazyColumn{
        item {
            Text(text = "Cats and Dogs" , style = MaterialTheme.typography.headlineSmall)
        }
        items(animals){animal ->
            AnimalCard(animal = animal)
        }
    }
}

@Composable
fun AnimalCard(animal:Animal,
    modifier: Modifier = Modifier){
Text(text = animal.title)

}

@Preview
@Composable
fun ScreenPreview(){
    CatsAndDogsTheme {
        HomeScreen()
    }
}