package com.mehrdad.freenews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mehrdad.freenews.data.remote.model.remote.Article
import com.mehrdad.freenews.domain.BottomNavigationItem
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.presentation.article.ArticleScreen
import com.mehrdad.freenews.presentation.home.HomeScreen
import com.mehrdad.freenews.presentation.navigation.Route
import com.mehrdad.freenews.presentation.profile.ProfileScreen
import com.mehrdad.freenews.presentation.profile.ProfileViewModel
import com.mehrdad.freenews.ui.theme.FreeNewsTheme
import com.mehrdad.freenews.ui.theme.Secondary
import com.mehrdad.freenews.ui.theme.Tertiary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val spacing = LocalSpacing.current
                    var selectedItemIndex by rememberSaveable {
                        mutableIntStateOf(0)
                    }
                    var shouldShowTopBar by rememberSaveable {
                        mutableStateOf(false)
                    }
                    val navigationItem = BottomNavigationItem.navbarItems
                    val navController = rememberNavController()

                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        topBar = {
                            if (shouldShowTopBar) {
                                TopAppBar(
                                    title = { },
                                    navigationIcon = {
                                        IconButton(
                                            onClick = { navController.navigateUp() }) {
                                            Icon(
                                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                                contentDescription = "back"
                                            )
                                        }
                                    }
                                )
                            }
//                            Spacer(
//                                modifier = Modifier
//                                    .height(spacing.spaceXXLarge)
//                                    .fillMaxWidth()
//                                    .background(Primary)
//                            )
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
                                            if (selectedItemIndex != index) {
                                                selectedItemIndex = index

                                                navController.popBackStack()
                                                navController.navigate(item.route)

//                                                navController.navigate(item.route) {
//                                                    // Pop up to the start destination of the navigation graph
//                                                    popUpTo(navController.graph.startDestinationId) {
//                                                        // Inclusive of the start destination
//                                                        inclusive = true
//                                                    }
//                                                    // Avoid multiple copies of the same destination when reselecting the same item
//                                                    launchSingleTop = true
//                                                    // Restore state when navigating back to a previously visited destination
//                                                    restoreState = true
//                                                }
//                                                navController.popBackStack()
                                            }
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
                                shouldShowTopBar = false
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
                                shouldShowTopBar = false
                                val viewModel: ProfileViewModel = hiltViewModel()
                                ProfileScreen(navController = navController, event = { event ->
                                    viewModel::onEvent
                                })
                            }
                            composable(Route.ARTICLE) {
                                shouldShowTopBar = true
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