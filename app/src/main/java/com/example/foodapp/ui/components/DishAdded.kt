package com.example.foodapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodapp.viewmodel.DishesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun DishAdded(viewModel: DishesViewModel = viewModel()) {
    val selectedDish by viewModel.selectedDish.collectAsState()

    if (selectedDish == null) {
        Box(
            modifier = Modifier
                .border(2.dp, Color.Gray, RoundedCornerShape(100.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No dish added. \n Please add a dish.",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
            )
        }
    } else {
        selectedDish?.let { dish ->
            Box(
                modifier = Modifier
                    .shadow(
                        5.dp,
                        RoundedCornerShape(100.dp)
                    )
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.White)
                    .padding(vertical = 2.dp, horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = dish.imageUrl),
                            contentDescription = "category.label",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    Column {
                        Text(
                            text = dish.dishName,
                            color = Color.Black,
                            modifier = Modifier
                        )
                        Text(
                            text = dish.time!!,
                            color = Color.Black,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}
