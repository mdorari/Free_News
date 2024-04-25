package com.mehrdad.freenews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mehrdad.freenews.data.model.remote.Article
import com.mehrdad.freenews.domain.BottomNavigationItem
import com.mehrdad.freenews.presentation.navigation.Route
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.presentation.article.ArticleScreen
import com.mehrdad.freenews.presentation.home.HomeScreen
import com.mehrdad.freenews.presentation.home.HomeViewModel
import com.mehrdad.freenews.presentation.profile.ProfileScreen
import com.mehrdad.freenews.presentation.profile.ProfileViewModel
import com.mehrdad.freenews.ui.theme.FreeNewsTheme
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Secondary
import com.mehrdad.freenews.ui.theme.Tertiary
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
//                    val viewModel = hiltViewModel<HomeViewModel>()
//                    val state = viewModel.state
                    val spacing = LocalSpacing.current
                    var selectedItemIndex by rememberSaveable {
                        mutableIntStateOf(0)
                    }
                    val navigationItem = BottomNavigationItem.navbarItems
                    val navController = rememberNavController()

                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        topBar = {
                            Spacer(
                                modifier = Modifier
                                    .height(spacing.spaceXXLarge)
                                    .fillMaxWidth()
                                    .background(Primary)
                            )
                        },
                        bottomBar = {
                            NavigationBar(containerColor = Color.White) {
                                navigationItem.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = Color.White
                                        ),
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            navController.navigate(item.route)
                                        },
                                        label = {
                                            Text(
                                                text = item.title,
                                                color = if (selectedItemIndex == index) {
                                                    Tertiary
                                                } else Secondary,
                                                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                                                fontWeight = if (selectedItemIndex == index) {
                                                    FontWeight.Bold
                                                } else FontWeight.Thin,
                                                fontSize = 12.sp,
                                                letterSpacing = (-0.7).sp
                                            )
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = if (selectedItemIndex == index) {
                                                    item.selectedIcon
                                                } else item.unselectedIcon,
                                                contentDescription = item.title,
                                                tint = if (selectedItemIndex == index) {
                                                    Tertiary
                                                } else Secondary,
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    ) {
                        NavHost(
                            modifier = Modifier.padding(it),
                            navController = navController,
                            startDestination = Route.HOME
                        ) {
                            composable(Route.HOME) {
                                HomeScreen(
                                    navController = navController,
                                    navigateToDetails = { article ->
                                        navigateToDetails(
                                            navController = navController,
                                            article = article
                                        )
                                    }
                                )
                            }
                            composable(Route.PROFILE) {
                                val viewModel:ProfileViewModel = hiltViewModel()
                                ProfileScreen(navController = navController, event = {event->
                                    viewModel::onEvent
                                })
                            }
                            composable(Route.ARTICLE) {
                                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>(
                                    "article"
                                )
                                    ?.let { article ->
                                        ArticleScreen(article = article)
                                    }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun navigateToDetails(navController: NavController, article: Article) {
        navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
        navController.navigate(
            route = Route.ARTICLE
        )
    }
}