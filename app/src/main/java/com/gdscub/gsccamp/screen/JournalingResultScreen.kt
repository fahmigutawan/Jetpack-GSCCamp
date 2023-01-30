package com.gdscub.gsccamp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.gdscub.gsccamp.R
import com.gdscub.gsccamp.data.Resource
import com.gdscub.gsccamp.ui.theme.AppColor
import com.gdscub.gsccamp.ui.theme.AppType
import com.gdscub.gsccamp.viewmodel.JournalingResultViewModel

@Composable
fun JournalingResultScreen(
    navController: NavController,
    sentence: String
) {
    val viewModel: JournalingResultViewModel = viewModel()
    val depressionPrediction = viewModel.depressionPrediction.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getDepressionPrediction(sentence)
    }

    when (depressionPrediction.value) {
        is Resource.Error -> {
            //HANDLE ERROR DI SINI
        }

        is Resource.Loading -> {
            //HANDLE LOADING DI SINI
        }

        is Resource.Success -> {
            when (depressionPrediction.value.data!!.data.is_depressed) {
                "True" -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Icon(
                                modifier = Modifier.size(128.dp),
                                painter = rememberAsyncImagePainter(model = R.drawable.ic_sad),
                                contentDescription = "SAD",
                                tint = AppColor.Error900
                            )

                            Text(
                                text = "You look sad",
                                style = AppType.H4Semibold,
                                color = AppColor.Error900
                            )

                            Text(
                                textAlign = TextAlign.Center,
                                text = "It's okay! Take your time on healing for as long as you want. No one else knows what you've been through.",
                                style = AppType.B1Semibold,
                                color = AppColor.Neutral500
                            )
                        }
                    }
                }

                "False" -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Icon(
                                modifier = Modifier.size(128.dp),
                                painter = rememberAsyncImagePainter(model = R.drawable.ic_smile),
                                contentDescription = "SMILE",
                                tint = AppColor.Success900
                            )

                            Text(
                                text = "You look happy",
                                style = AppType.H4Semibold,
                                color = AppColor.Success900
                            )

                            Text(
                                textAlign = TextAlign.Center,
                                text = "You look fine today! no need to worry about your life. Live happily and do not forget to  spread your happiness to others",
                                style = AppType.B1Semibold,
                                color = AppColor.Neutral500
                            )
                        }
                    }
                }
            }
        }
    }
}