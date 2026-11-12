package com.example.booklibrary.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp


import com.example.booklibrary.Book
import com.example.booklibrary.Composables.BookCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadBoooksScreen(
    bookList : List<Book>,
    moveToHomeClicked:() -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Read Books") },
                navigationIcon = {
                    IconButton(onClick = {
                        moveToHomeClicked()
                    }) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = "Go to read books"
                        )

                    }
                }

            )

        }
    ){
        innerPadding ->
        if(bookList.isEmpty()){
           Box(
               modifier = Modifier.fillMaxSize()
                   .padding(innerPadding),
              // contentAlignment = Alignment.Center
           ){
            Text(
                text ="You have't  added any favorite courses yet.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
           }
        }
        else {
            LazyColumn(
                modifier = Modifier .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    items = bookList,
                    key = {it.id}
                )
                { book ->
                    BookCard(
                        book = book,
                        isRead = true,
                        readClicked = { }
                    )

                }
            }
        }
    }
}
