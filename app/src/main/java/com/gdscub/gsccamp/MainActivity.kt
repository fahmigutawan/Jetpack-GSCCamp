package com.gdscub.gsccamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gdscub.gsccamp.component.HomeArticlePreview
import com.gdscub.gsccamp.screen.ArticleDetailScreen
import com.gdscub.gsccamp.screen.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = AppNavRoute.Home.name) {
                composable(route = AppNavRoute.Home.name) {
                    HomeScreen(navController = navController)
                }

                composable(
                    route = "${AppNavRoute.ArticleDetail.name}/{artikel_id}",
                    arguments = listOf(
                        navArgument(name = "artikel_id") {
                            type = NavType.StringType
                        }
                    )
                ) {
                    val tmp_artikel_id = it.arguments?.getString("artikel_id") ?: ""
                    ArticleDetailScreen(artikel_id = tmp_artikel_id)
                }

                composable(route = AppNavRoute.Journaling.name) {
                    //JOURNALING HERE
                }

                composable(route = AppNavRoute.JournalingResult.name) {
                    //JOURNALING RESULT HERE
                }
            }
        }
    }
}

enum class AppNavRoute {
    Home,
    ArticleDetail,
    Journaling,
    JournalingResult
}