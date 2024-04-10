package com.mehrdad.freenews.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mehrdad.freenews.R
import com.mehrdad.freenews.data.Filter
import com.mehrdad.freenews.data.model.Article
import com.mehrdad.freenews.data.model.Headlines
import com.mehrdad.freenews.data.model.Source
import com.mehrdad.freenews.domain.BottomNavigationItem
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.presentation.UiEvent
import com.mehrdad.freenews.presentation.components.FilterButton
import com.mehrdad.freenews.presentation.components.NewsCard
import com.mehrdad.freenews.presentation.components.OtherNews
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Secondary
import com.mehrdad.freenews.ui.theme.Tertiary
import com.mehrdad.freenews.ui.theme.Transparent
import kotlinx.coroutines.flow.collect

@Composable
fun HomeScreen(
//    onNavigateUp:()->Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(true) {
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

    val filterItems = listOf<Filter>(
        Filter("General", true),
        Filter("Health", false),
        Filter("Finance", false),
    )
    val otherNews = state.articles
    Column(
        modifier = Modifier
            .padding(paddingValues)
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
            LazyRow(
                modifier = Modifier.padding(vertical = spacing.spaceMedium),
            ) {
                items(filterItems) { filter ->
                    FilterButton(
                        modifier = Modifier.padding(horizontal = spacing.spaceSmall),
                        text = filter.text,
                        isSelected = filter.isSelected,
                        onClick = {})
                }
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
            NewsCard(article = state.articles.first())
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
                    OtherNews(item)
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