package com.mehrdad.freenews.presentation.home

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mehrdad.freenews.R
import com.mehrdad.freenews.data.remote.model.remote.Article
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.presentation.UiEvent
import com.mehrdad.freenews.presentation.components.FilterButton
import com.mehrdad.freenews.presentation.components.NewsCard
import com.mehrdad.freenews.presentation.components.OtherNews
import com.mehrdad.freenews.presentation.service.NewsNotificationService
import com.mehrdad.freenews.presentation.splashScreen.SplashViewModel
import com.mehrdad.freenews.ui.theme.Tertiary
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    splashViewModel: SplashViewModel,
//    navController: NavController,
    navigateToDetails: (Article) -> Unit,
) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            splashViewModel.saveNotificationPermissionState(isGranted)
        }
    )

    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    var selectedFilterIndex by remember {
        mutableIntStateOf(0)
    }
    val service = NewsNotificationService(context)

    LaunchedEffect(true) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!splashViewModel.hadNotificationPermission.value) {
                launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.showSnackBar -> {
                    UiEvent.showSnackBar(
                        message = event.message
                    )
                }

                else -> Unit
            }
        }
    }

    val filterItems = state.filterList
    val otherNews = state.articles
    val newsByCategory = state.articlesByCategory
    Column(
        modifier = Modifier
//            .padding(paddingValues)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
//                .padding(horizontal = spacing.spaceSmall)
    ) {
        if (state.articles.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LaunchedEffect(key1 = true)  {
                delay(5000)
                val randomArticleIndex = Random.nextInt(from = 0, until = state.articles.size/2)
                service.sendNewsNotification(state.articles[randomArticleIndex])
            }
            Text(
                modifier = Modifier.padding(spacing.spaceMedium),
                text = "Now!",
                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                color = Tertiary,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            )
            NewsCard(article = state.bannerNews,
                onClick = { navigateToDetails(state.bannerNews) })
            Text(
                modifier = Modifier.padding(spacing.spaceMedium),
                text = "Other News:",
                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                color = Tertiary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {
                items(otherNews) { item ->
                    OtherNews(
                        onClick = { navigateToDetails(item) },
                        article = item
                    )
                }
            }
            LazyRow(
                modifier = Modifier.padding(vertical = spacing.spaceMedium),
            ) {
                item {
                    filterItems.forEachIndexed { index, filter ->
                        FilterButton(
                            modifier = Modifier.padding(horizontal = spacing.spaceSmall),
                            text = filter.text,
                            isSelected = selectedFilterIndex == index,
                            onFilterSelected = {
                                selectedFilterIndex = 0
                                viewModel.onEvent(HomeEvent.OnFilterClick(filter))
                            })

                    }
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {
                items(newsByCategory) { item ->
                    OtherNews(
                        onClick = { navigateToDetails(item) },
                        article = item
                    )
                }
            }
        }
    }
}

//@Preview(
//    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}