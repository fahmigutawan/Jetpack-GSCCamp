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
import com.gdscub.gsccamp.screen.JournalingResultScreen
import com.gdscub.gsccamp.screen.JournalingScreen

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
                    route = "${AppNavRoute.ArticleDetail.name}/{id}",
                    arguments = listOf(
                        navArgument(name = "id") {
                            type = NavType.StringType
                        }
                    )
                ) {
                    val id = it.arguments?.getString("id") ?: ""
                    ArticleDetailScreen(id)
                }

                composable(route = AppNavRoute.Journaling.name) {
                    JournalingScreen(navController = navController)
                }

                composable(
                    route = "${AppNavRoute.JournalingResult.name}/{sentence}",
                    arguments = listOf(
                        navArgument(name = "sentence") {
                            type = NavType.StringType
                        }
                    )
                ) {
                    val sentence = it.arguments?.getString("sentence") ?: ""
                    JournalingResultScreen(
                        navController = navController,
                        sentence = sentence
                    )
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