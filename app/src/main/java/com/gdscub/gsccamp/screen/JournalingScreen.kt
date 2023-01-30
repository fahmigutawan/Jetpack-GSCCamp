package com.gdscub.gsccamp.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gdscub.gsccamp.AppNavRoute
import com.gdscub.gsccamp.ui.theme.AppColor
import com.gdscub.gsccamp.ui.theme.AppType
import com.gdscub.gsccamp.viewmodel.JournalingViewModel

@Composable
fun JournalingScreen(navController: NavController) {
    val viewModel: JournalingViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Journaling",
                    style = AppType.H5Semibold,
                    color = AppColor.Neutral50
                )
            }, backgroundColor = AppColor.Primary700)
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(route = "${AppNavRoute.JournalingResult.name}/${viewModel.inputValue.value}")
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = AppColor.Primary700)
            ) {
                Text(text = "Submit", style = AppType.H6Semibold, color = AppColor.Shades50)
            }
        }
    ) {
        TextField(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = it.calculateBottomPadding()
                ),
            value = viewModel.inputValue.value,
            onValueChange = {
                viewModel.inputValue.value = it
            }
        )
    }
}