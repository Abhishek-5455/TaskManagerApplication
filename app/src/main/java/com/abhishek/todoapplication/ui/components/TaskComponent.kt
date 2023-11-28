package com.abhishek.todoapplication.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.todoapplication.data.Task
import com.abhishek.todoapplication.ui.theme.LightBlue
import com.abhishek.todoapplication.ui.theme.LightGreen
import com.abhishek.todoapplication.ui.theme.LightPurple
import com.abhishek.todoapplication.ui.theme.Telex

@Composable
fun TaskComponent(
    task: Task,
    modifier: Modifier = Modifier,
    onIconClick: (Task) -> Unit
) {
    val taskBgColors = listOf(LightPurple, LightBlue, LightGreen)
    val color = taskBgColors[task.id % 3]
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = task.startTime,
            fontFamily = Telex,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .border(
                    border = BorderStroke(3.dp, color = Color.Black),
                    shape = CircleShape
                )
        )
        Divider(
            modifier = Modifier.width(6.dp),
            color = Color.Black
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(color)
                    .padding(12.dp)
                    .weight(0.9f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = task.title,
                        fontFamily = Telex,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    task.body?.let {
                        Text(
                            text = it,
                            fontFamily = Telex,
                            fontSize = 12.sp,
                        )
                    }
                    Text(
                        text = "${task.startTime} - ${task.endTime}",
                        fontFamily = Telex,
                        fontSize = 12.sp,
                    )
                }
                IconButton(onClick = { onIconClick(task) } ) {
                    Icon(
                        imageVector = Icons.Rounded.Delete,
                        contentDescription = "Delete Task",
                        tint = Color.LightGray
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .weight(0.1f)
                    .width(6.dp),
                color = Color.Black
            )
        }
    }
}


@Preview
@Composable
fun TaskComponentPreview() {
//    TaskComponent(task = Task(
//        1,
//        "Do Laundry",
//        "Wash and fold clothes",
//        "10:00",
//        "11:00"
//    ))
}