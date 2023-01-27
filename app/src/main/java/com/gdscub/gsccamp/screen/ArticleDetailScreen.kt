package com.gdscub.gsccamp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.gdscub.gsccamp.data.Resource
import com.gdscub.gsccamp.ui.theme.AppColor
import com.gdscub.gsccamp.ui.theme.AppType
import com.gdscub.gsccamp.viewmodel.ArticleDetailViewModel

@Composable
fun ArticleDetailScreen(
    id: String
) {
    val viewModel: ArticleDetailViewModel = viewModel()
    val articleById = viewModel.articleById.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getArticleById(id)
    }

    when (articleById.value) {
        is Resource.Error -> {
            //HANDLE ERROR DI SINI
        }

        is Resource.Loading -> {
            //HANDLE LOADING DI SINI
        }

        is Resource.Success -> {
            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                //Title
                item {
                    Text(
                        text = articleById.value.data!!.data.Title,
                        style = AppType.H5Semibold,
                        color = AppColor.Neutral900
                    )
                }

                //Image & Author
                item {
                    Column {
                        //Image
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 128.dp)
                                .background(AppColor.Neutral400),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                contentScale = ContentScale.FillWidth,
                                model = articleById.value.data!!.data.ImageUrl,
                                contentDescription = "Image"
                            )
                        }

                        //Author
                        Text(
                            text = "${articleById.value.data!!.data.CreatedBy}-${articleById.value.data!!.data.CreatedAt}",
                            style = AppType.B3Regular.copy(fontSize = 8.sp),
                            color = AppColor.Neutral500
                        )
                    }
                }

                //Body
                item {
                    Text(
                        text = articleById.value.data!!.data.Body,
                        style = AppType.B2Semibold,
                        color = AppColor.Neutral700
                    )
                }
            }
        }
    }
}