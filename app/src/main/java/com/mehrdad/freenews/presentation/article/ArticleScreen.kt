package com.mehrdad.freenews.presentation.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.mehrdad.freenews.R
import com.mehrdad.freenews.data.model.remote.Article
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.presentation.components.NewsAgencyName
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Tertiary

@Composable
fun ArticleScreen(
    article: Article,
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .padding(spacing.spaceSmall)
            .fillMaxSize()
    ) {
        NewsAgencyName(article)
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = spacing.spaceSemiLarge)
                .clip(RoundedCornerShape(spacing.spaceMedium)),
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article.urlToImage)
                    .size(Size.ORIGINAL)
                    .crossfade(true)
                    .build()
            ),

            contentDescription = article.description
        )
        Text(
            text = article.source.name,
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontSize = 12.sp,
            color = Tertiary,
            fontWeight = FontWeight.Bold,
            letterSpacing = (-0.5).sp,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = spacing.spaceExtraSmall)
        )
        Text(
            text = article.title ?: "No title",
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontSize = 24.sp,
            color = Primary,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-0.5).sp,
            maxLines = 3,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = spacing.spaceExtraSmall)
        )
        Text(
            text = article.content ?: "No content",
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontSize = 16.sp,
            color = Primary,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = spacing.spaceExtraSmall)
        )
    }
}

//@Preview(
//    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun ArticlePrev() {
//    Article("","","","", Source("",""),"","","")
//}