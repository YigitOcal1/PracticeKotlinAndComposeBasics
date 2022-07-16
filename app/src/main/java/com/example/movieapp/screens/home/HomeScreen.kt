package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Cyan, elevation = 8.dp) {
            Text(text = "Filmler")
        }
    },
    ) {
        MainContent(navController=navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf("asd"
    ,"sdfas","wtgwagw","sagasgasw")) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(movie = it){
                        movie->
                   navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")

                }

            }
        }
    }
}
@Composable
fun MovieRow(movie:String,onItemClick:(String) -> Unit={}){

    Card(modifier = Modifier
        .padding(6.dp)
        .fillMaxWidth()
        .height(140.dp)
        .clickable {
            onItemClick(movie)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 8.dp){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp), shape = RectangleShape, elevation = 6.dp) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Film resmi")
            }
            Text(text = movie)
        }

    }



}