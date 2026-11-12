package com.example.booklibrary.Composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.booklibrary.Book

@Composable
fun BookCard(book: Book,
             isRead : Boolean,
             readClicked:(id: Int) -> Unit
){
Card(
   modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(13.dp),
    elevation = CardDefaults.cardElevation(disabledElevation = 5.dp)
     )
{
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Book details on the left
            Column(
                modifier = Modifier.weight(1f)
                    .padding(10.dp)
            ) {
                Text(text = "BookId: ${book.id}",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium)

                Text(text = "Title: ${book.title}",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium)
                Text(text = "Author: ${book.author}",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium)
                Text(text="Year : ${book.publicationYear}",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium)
            }

            // Book icon on the right
            IconButton(
                onClick = {
                    readClicked(book.id)
                }
            ) {
                Icon(
                    imageVector = if (isRead)
                        Icons.Default.MenuBook
                    else
                        Icons.Outlined.MenuBook,
                    contentDescription = "Toggle read",
                    tint = if (isRead) Color.Green else Color.Gray
                )
            }
        }
    }
 }
}

