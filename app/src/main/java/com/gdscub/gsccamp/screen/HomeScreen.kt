package com.gdscub.gsccamp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.gdscub.gsccamp.ui.theme.AppColor
import com.gdscub.gsccamp.ui.theme.AppType
import com.gdscub.gsccamp.R

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = AppColor.Primary700) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Article",
                    style = AppType.H5Semibold,
                    color = AppColor.Neutral50
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = rememberAsyncImagePainter(
                            model = R.drawable.ic_journaling //GANTI DENGAN ICON MU
                        ),
                        contentDescription = "Journaling",
                        tint = AppColor.Neutral50
                    )
                }
            }
        }
    }) {
        //ITEM HERE
    }
}