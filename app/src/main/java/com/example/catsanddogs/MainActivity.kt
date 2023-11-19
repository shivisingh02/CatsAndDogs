package com.example.catsanddogs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
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
                    HomeScreen()

                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val animals = FakeRepository().loadData()
    LazyColumn(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Cats and Dogs", style = MaterialTheme.typography.headlineSmall)
        }
        items(animals) { animal ->
            AnimalCard(animal = animal, onItemClick = {
                Log.d("Event", "Item clicked")
            }, onFavClick = {
                Log.d("Event", "Fav clicked")
            },
                onShareClick = {
                    Log.d("Event" , "Share Clicked")
                })
        }
    }
//    Card(
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        ),
//        modifier = Modifier
//            .padding(start = 35.dp, top = 100.dp, bottom = 500.dp, end = 10.dp)
//            .size(350.dp)
//            .border(
//                BorderStroke(5.dp, Color.Gray),
//                shape = RoundedCornerShape(10.dp)
//            )
//            .padding(end = 10.dp)
//    ) {
//        // Text(text ="CAT", color = Color.Black, modifier = Modifier.padding(start = 160.dp, top= 5.dp,))
//        Row {
//            Image(
//                painter = painterResource(id = R.drawable.cats3),
//                contentDescription = "cat",
//                modifier = Modifier
//                    .size(220.dp)
//                    .padding(top = 35.dp, end = 25.dp)
//            )
//            Column {
//                Text(
//                    text = "Name : Fluffy",
//                    modifier = Modifier.padding(top = 55.dp,),
//                    color = Color.Black
//                )
//                Text(
//                    text = "Age : 3",
//                    modifier = Modifier.padding(top = 10.dp,),
//                    color = Color.Black
//                )
//                Text(
//                    text = "AnimalType : Cat",
//                    modifier = Modifier.padding(top = 10.dp,),
//                    color = Color.Black
//                )
//            }
//        }
//    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun AnimalCard(
    animal: Animal,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit = {},
    onFavClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Card(
        onClick = onItemClick,
        modifier = Modifier
    ) {
        Box {
            GlideImage(
                model = animal.image,
                loading = placeholder(ColorPainter(Color.LightGray)),
                contentDescription = animal.title,
                transition = CrossFade,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(250.dp)
            )
            Badge(
                modifier = Modifier
                    .padding(16.dp)
                    .align(
                        alignment = Alignment.TopEnd
                    )
            ) {
                Text(
                    text = animal.type.name, style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
                )
            }
            Text(
                text = "${animal.age}Yrs",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(alignment = Alignment.BottomEnd)
                    .alpha(0.8f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = animal.title,
                modifier = Modifier.padding(16.dp)
            )
            Row {
                IconButton(onClick = onFavClick) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favourite",
                        modifier = Modifier.padding(start = 10.dp, end = 0.dp)
                    )
                }
                IconButton(onClick = onShareClick) {


                    Icon(
                        imageVector = Icons.Default.Share, contentDescription = "Share",
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }

            }

        }

    }

}


@Preview
@Composable
fun ScreenPreview() {
    CatsAndDogsTheme {
        HomeScreen()
    }
}