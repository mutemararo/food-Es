package com.healthypalate.food_e_s

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.healthypalate.food_e_s.model.Additive
import com.healthypalate.food_e_s.ui.home.HomeViewModel
import com.healthypalate.food_e_s.ui.home.HomeViewModelFactory
import com.healthypalate.food_e_s.ui.theme.FoodEsTheme

class MainActivity : ComponentActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodEsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewmodel by viewModels<HomeViewModel> {
                        HomeViewModelFactory((application as FoodEsApplication).container.repository)
                    }
                    val allItems: List<Additive> = viewmodel.allAdditives.value
                    Greeting(allItems)
                }
            }
        }
    }
}

@Composable
fun Greeting(elements: List<Additive>, modifier: Modifier = Modifier) {
      LazyColumn{
          items(elements){item ->
              Text(text = item.name)
          }
      }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodEsTheme {
        Greeting()
    }
}*/
