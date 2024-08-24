package com.example.foodapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.foodapp.model.Dish
import com.example.foodapp.viewmodel.DishesViewModel

@Preview
@Composable
fun RecommendationsGrid(viewModel: DishesViewModel = viewModel()) {
    val dishes = viewModel.dishes.collectAsState()
    var selectedDish by remember { mutableStateOf<Dish?>(null) }
    var isDialogOpen by remember { mutableStateOf(false) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(dishes.value) { dish ->
            ResponsiveRecipeBox(
                imageUrl = dish.imageUrl,
                title = dish.dishName,
                rating = 4.2, // Assuming a static rating; update according to your data model
                time = "30 min", // Assuming static time; update according to your data model
                difficulty = "Medium", // Assuming static difficulty; update according to your data model
                isSelected = dish == selectedDish,
                onClick = {
                    selectedDish = dish
                    isDialogOpen = true
                }
            )
        }
    }

    // Display the dialog if isDialogOpen is true
    selectedDish?.let {
        if (isDialogOpen) {
            ScheduleCookingDialog(
                dish = it,
                onDismiss = { isDialogOpen = false },
                onCookNow = { dish ->
                    viewModel.setSelectedDish(dish)
                    isDialogOpen = false
                }
            )
        }
    }
}

@Composable
fun ResponsiveRecipeBox(
    imageUrl: String,
    title: String,
    rating: Double,
    time: String,
    difficulty: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 10.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(if (isSelected) Color(0xFF3333FF) else Color.White) // Blue background if selected, else gray
            .clickable { onClick() }

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)
        ) {
            // Image
            Box(modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray)){
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(15.dp)
                        .size(100.dp) // Adjust size as needed
                        .clip(CircleShape) // Ensures image is clipped into a circle
                )
            }
            // Star Rating
            Box(
                modifier = Modifier
                    .offset(y = ((-13).dp))
                    .background(
                        Color(0xFFFFA500),
                        shape = RoundedCornerShape(50)
                    ) // Orange star background
                    .padding(horizontal = 8.dp, vertical = 2.dp) // Position the rating star over the image
            ) {
                Text(
                    text = "★ $rating",
                    color = if(isSelected) Color.White else Color.Blue,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Title
            Text(
                text = title,
                color = if(isSelected) Color.White else Color.Blue,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            // Time and Difficulty
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = " $time • $difficulty",
                    color = if(isSelected) Color.White else Color.Blue,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}


