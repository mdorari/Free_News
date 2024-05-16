package com.mehrdad.freenews.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.mehrdad.freenews.R
import com.mehrdad.freenews.data.remote.model.remote.Article
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.ui.theme.Primary

@Composable
fun NewsCard(
    article: Article,
    onClick: (Article) -> Unit
) {
    val spacing = LocalSpacing.current

//    val sampleImage =
//        "https://images6.alphacoders.com/488/thumb-1920-488158.jpg"
    Column(modifier = Modifier.padding(spacing.spaceMedium).clickable { onClick(article) }) {
        Box() {
            Image(
                modifier = Modifier.clip(RoundedCornerShape(spacing.spaceSemiLarge)),

                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(article.urlToImage)
                        .size(coil.size.Size.ORIGINAL)
                        .crossfade(true)
                        .build()
                ),
                contentDescription = article.description
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .padding(spacing.spaceSemiMedium)
                        .width(40.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(spacing.spaceXXLarge)),
                    painter = painterResource(id = R.drawable.news_agency_icon),
                    contentDescription = ""
                )
                Text(
                    text = article.source.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    letterSpacing = (-1).sp,
                    fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght))
                )
            }
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(spacing.spaceSemiMedium),
                text = article.author ?: article.source.name,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                letterSpacing = (-1).sp,
                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght))
            )


            /*


            Image(
                        painter = rememberImagePainter(
                            data = food.imageUrl,
                            builder = {
                                crossfade(true)
                                error(R.drawable.ic_burger)
                                fallback(R.drawable.ic_burger)
                            }
                        ),
                        contentDescription = food.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(topStart = 5.dp))
                    )


             */


        }
        Text(
            modifier = Modifier
                .padding(top = spacing.spaceSemiMedium),
            text = article.title ?: "No title",
            color = Primary,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontSize = 24.sp,
            letterSpacing = (-0.5).sp,
        )
    }

}

//@Preview(device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun NewsCardPreview() {
//    NewsCard()
//}