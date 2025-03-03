package com.example.mywishlist

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mywishlist.data.DummyWish
import com.example.mywishlist.data.Wish

@Composable
fun HomeView(
    viewModel: WishViewModel,
    navController: NavController
) {
    val context = LocalContext.current

    Scaffold(
        topBar = { AppBarView(
            title = "WishList"
        ) {
            Toast.makeText(
                context,
                "Button Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                containerColor = Color.Black,
                onClick = {
                    navController.navigate(Screen.AddScreen.route)

                    Toast.makeText(
                        context,
                        "Floating Button Clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription = null)
                }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(DummyWish.wishList){
                wish -> WishItem(wish = wish) {

                }
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: ()-> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    )
    {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = wish.description)
        }
    }

}
