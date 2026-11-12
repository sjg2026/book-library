package com.example.booklibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.booklibrary.ui.theme.BookLibraryTheme
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.booklibrary.Screens.HomeScreen
import com.example.booklibrary.Screens.ReadBoooksScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyLog", "App started")
        enableEdgeToEdge()
        val books = listOf(
            Book(
                id = 1,
                title = "Book1",
                author = "author1",
                publicationYear = "1991"
            ),
            Book(
                id = 2,
                title = "Book2",
                author = "author2",
                publicationYear = "1992"
            ),
            Book(
                id = 3,
                title = "Book3",
                author = "author3",
                publicationYear = "1993"
            ),
            Book(
                id = 4,
                title = "Book4",
                author = "author4",
                publicationYear = "1994"
            ),
            Book(
                id = 5,
                title = "Book5",
                author = "author5",
                publicationYear = "1995"
            ),
            Book(
                id = 6,
                title = "Book6",
                author = "author6",
                publicationYear = "1996"
            ),
            Book(
                id = 6,
                title = "Book6",
                author = "author7",
                publicationYear = "1997"
            )

        )

        Log.d("MyLog", "Total books created: ${books.size}")

        setContent {
            BookLibraryTheme {
                val navController = rememberNavController()
                var readIds by remember {
                    mutableStateOf(setOf<Int>())
                }
                NavHost(
                    navController = navController,
                    startDestination = "home"
                )
                {

                    composable(route = "home")
                    {
                        HomeScreen(
                            bookList = books,
                            readBookList = readIds,

                            readSelected = { selectedId ->
                                Log.d("BookLibrary", "Clicked book ID: $selectedId")

                                readIds =
                                    if (selectedId in readIds) {
                                        readIds - selectedId
                                    } else {
                                        readIds + selectedId
                                    }
                            },

                            moveToReadClicked = {
                                Log.d("MyLog","Navigating to Read BookScreen")
                                navController.navigate("read")
                            }
                        )
                    }
                    composable(route = "read") {

                        val readBooks = books.filter {
                            it.id in readIds
                        }

                        Log.d("BookLibrary", "Filtered read books: ${readBooks.map { it.title }}")

                        ReadBoooksScreen(
                            bookList = readBooks,
                            moveToHomeClicked = {
                                navController.popBackStack()
                            }
                        )
                    }

                }
            }
        }
    }
}




