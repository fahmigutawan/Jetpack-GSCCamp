package com.gdscub.gsccamp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gdscub.gsccamp.ui.theme.AppColor
import com.gdscub.gsccamp.ui.theme.AppType

@Composable
fun HomeArticlePreview(
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick:() -> Unit,
    imageUrl: String,
    title: String,
    description: String
) {
    Card(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(),
            onClick = onClick
        ), backgroundColor = AppColor.Neutral50, elevation = 8.dp
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.size(64.dp)) {
                //Placeholder
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppColor.Neutral400)
                )

                //Image
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = imageUrl,
                    contentDescription = "Img",
                    contentScale = ContentScale.Crop
                )
            }

            Column(modifier = Modifier.padding(top = 4.dp, end = 4.dp, bottom = 4.dp)) {
                //Title
                Text(
                    text = title,
                    style = AppType.B2Semibold,
                    color = AppColor.Neutral900
                )

                //Description
                Text(
                    text = description,
                    style = AppType.B3Regular.copy(fontSize = 8.sp),
                    color = AppColor.Neutral700
                )
            }
        }
    }
}