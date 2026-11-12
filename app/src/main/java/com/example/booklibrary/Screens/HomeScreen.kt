package com.example.booklibrary.Screens


import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp

import com.example.booklibrary.Book
import com.example.booklibrary.Composables.BookCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
bookList: List<Book>,
readBookList: Set<Int>,
readSelected: (id: Int) -> Unit,
moveToReadClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Book Libabry") },
                actions = {
                    IconButton(onClick = {
                        moveToReadClicked()
                    }) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = "Go to read books"
                        )

                    }
                }

            )

        }
    )
    { innerPadding ->

        LazyColumn(
            modifier = Modifier.padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = bookList,
                key = { it.id }
            ) { book ->

                BookCard(
                    book = book,
                    isRead = book.id in readBookList,
                    readClicked = { id ->
                        readSelected(id)
                    }
                )
            }
        }
    }
}