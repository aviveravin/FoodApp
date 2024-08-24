package com.example.foodapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.TimeFormat
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.example.foodapp.model.Dish

@Composable
fun ScheduleCookingDialog(
    dish: Dish,
    onDismiss: () -> Unit,
    onCookNow: (Dish) -> Unit
) {
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Schedule cooking time")
        },
        text = {
            Column(modifier = Modifier
                .background(Color(0xFFF5F5F5), RoundedCornerShape(14.dp))){
                // Time picker placeholder
                WheelTimePicker(
                    modifier = Modifier
                        .padding(12.dp),
                    timeFormat = TimeFormat.AM_PM,
                    size = DpSize(300.dp, 150.dp),
                    rowCount = 3,
                    textStyle = MaterialTheme.typography.titleLarge,
                    textColor = Color.Blue,
                    selectorProperties = WheelPickerDefaults.selectorProperties(
                        enabled = true,
                        shape = RoundedCornerShape(0.dp),
                        border = BorderStroke(0.dp, Color.Gray)
                    )
                ) { snappedDateTime ->
                    dish.time = snappedDateTime.toString()
                    println(snappedDateTime)
                }
                Spacer(modifier = Modifier.height(16.dp))

            }
        },
        confirmButton = {
            Box(modifier = Modifier
                .background(Color(0xFFEF6C00), RoundedCornerShape(15.dp))){
                TextButton(onClick = { onCookNow(dish) }) {
                    Text("Cook Now", color = Color.White)
                }
            }

        },
        dismissButton = {
            Box(modifier = Modifier
                .border(2.dp, Color(0xFFEF6C00), RoundedCornerShape(15.dp))
                .background(Color.White, RoundedCornerShape(15.dp))){
                TextButton(onClick = { onCookNow(dish) }) {
                    Text("Cook Now", color = Color(0xFFEF6C00))
                }
            }
        },
    )
}
