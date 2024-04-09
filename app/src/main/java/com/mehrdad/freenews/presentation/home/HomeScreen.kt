package com.mehrdad.freenews.presentation.home

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBarDefaults.containerColor
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
import com.mehrdad.freenews.presentation.components.FilterButton
import com.mehrdad.freenews.presentation.components.NewsCard
import com.mehrdad.freenews.presentation.components.OtherNews
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Secondary
import com.mehrdad.freenews.ui.theme.Tertiary
import com.mehrdad.freenews.ui.theme.Transparent

@Composable
fun HomeScreen(
//    onNavigateUp:()->Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current

//    LaunchedEffect(key1 = , block = )

    val filterItems = listOf<Filter>(
        Filter("General", true),
        Filter("Health", false),
        Filter("Finance", false),
    )
    val otherNews = state.articles.subList(1,10)

//        listOf<Article>(
//        Article(
//            source = Source(
//                id = "espn",
//                name = "ESPN"
//            ),
//            author = null,
//            title = "Iowa again sets ratings record in win over UConn - ESPN",
//            description = "Iowa's win over UConn Friday night in the semifinals of the women's Final Four drew a record average of 14.2 million viewers for the matchup.",
//            url = "https://www.espn.com/womens-college-basketball/story/_/id/39889095/iowa-again-draws-record-ratings-final-four-win-uconn",
//            urlToImage = "https://a3.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F0406%2Fr1314943_1296x729_16%2D9.jpg",
//            publishedAt = "2024-04-06T21:55:00Z",
//            content = "BRISTOL, Conn. -- Iowa's 71-69 victory over UConn at the women's Final Four on Friday night averaged 14.2 million viewers on ESPN, making it the most-viewed women's basketball game on record and the … [+1611 chars]"
//        ),
//        Article(
//            source = Source(
//                id = "espn",
//                name = "ESPN"
//            ),
//            author = null,
//            title = "Iowa again sets ratings record in win over UConn - ESPN",
//            description = "Iowa's win over UConn Friday night in the semifinals of the women's Final Four drew a record average of 14.2 million viewers for the matchup.",
//            url = "https://www.espn.com/womens-college-basketball/story/_/id/39889095/iowa-again-draws-record-ratings-final-four-win-uconn",
//            urlToImage = "https://a3.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F0406%2Fr1314943_1296x729_16%2D9.jpg",
//            publishedAt = "2024-04-06T21:55:00Z",
//            content = "BRISTOL, Conn. -- Iowa's 71-69 victory over UConn at the women's Final Four on Friday night averaged 14.2 million viewers on ESPN, making it the most-viewed women's basketball game on record and the … [+1611 chars]"
//        ),
//        Article(
//            source = Source(
//                id = "espn",
//                name = "ESPN"
//            ),
//            author = null,
//            title = "Iowa again sets ratings record in win over UConn - ESPN",
//            description = "Iowa's win over UConn Friday night in the semifinals of the women's Final Four drew a record average of 14.2 million viewers for the matchup.",
//            url = "https://www.espn.com/womens-college-basketball/story/_/id/39889095/iowa-again-draws-record-ratings-final-four-win-uconn",
//            urlToImage = "https://a3.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F0406%2Fr1314943_1296x729_16%2D9.jpg",
//            publishedAt = "2024-04-06T21:55:00Z",
//            content = "BRISTOL, Conn. -- Iowa's 71-69 victory over UConn at the women's Final Four on Friday night averaged 14.2 million viewers on ESPN, making it the most-viewed women's basketball game on record and the … [+1611 chars]"
//        )
//    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val navigationItem = BottomNavigationItem.navbarItems

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
//            .padding(spacing.spaceExtraSmall),
                ,
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
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues = it)
//                .padding(horizontal = spacing.spaceSmall)
        ) {
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
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)) {
                items(otherNews) { item ->
                    OtherNews(item)
                }
            }
//            Text(
//                modifier = Modifier.padding(spacing.spaceMedium),
//                text = "Other News:",
//                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
//                color = Tertiary,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                letterSpacing = (-0.5).sp
//            )
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