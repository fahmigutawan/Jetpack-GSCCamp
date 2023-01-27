package com.gdscub.gsccamp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.gdscub.gsccamp.AppNavRoute
import com.gdscub.gsccamp.ui.theme.AppColor
import com.gdscub.gsccamp.ui.theme.AppType
import com.gdscub.gsccamp.R
import com.gdscub.gsccamp.component.HomeArticlePreview
import com.gdscub.gsccamp.data.Resource
import com.gdscub.gsccamp.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeViewModel = viewModel()
    val allArticle = viewModel.allArticle.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getAllArticle()
    }

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
        when (allArticle.value) {
            is Resource.Error -> {
                //HANDLE ERROR DI SINI
            }

            is Resource.Loading -> {
                //HANDLE LOADING DI SINI
            }

            is Resource.Success -> {
                LazyColumn {
                    items(allArticle.value.data!!.data) { item ->
                        HomeArticlePreview(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            imageUrl = item.ImageUrl,
                            title = item.Title,
                            description = item.Body,
                            onClick = {
                                navController.navigate(route = "${AppNavRoute.ArticleDetail}/${item.ID}")
                            }
                        )
                    }
                }
            }
        }
    }
}