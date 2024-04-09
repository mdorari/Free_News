package com.mehrdad.freenews.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.mehrdad.freenews.R
import com.mehrdad.freenews.data.model.Article
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Secondary

@Composable
fun OtherNews(
//    modifier: Modifier = Modifier,
    article: Article
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(spacing.spaceSmall),
        horizontalAlignment = Alignment.Start
    ) {
//        Image(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(spacing.spaceSemiMedium)),
//            painter = painterResource(id = R.drawable.sample_image),
//            contentDescription = "sample image"
//        )

            Image(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(spacing.spaceSemiMedium)),
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(article.urlToImage)
                        .size(Size.ORIGINAL)
                        .crossfade(true)
                        .build()
                ),
                contentDescription = ""
            )
        Text(
            text = article.title,
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            letterSpacing = (-0.4).sp,
            color = Primary,
            modifier = Modifier.padding(top = spacing.spaceSmall)
        )
        Text(
            text = article.source.name,
            fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            letterSpacing = (-0.4).sp,
            color = Secondary,
        )
    }
}

//@Preview(
//    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
//    showBackground = true
//)
//@Composable
//fun OtherNewsPrev() {
//    OtherNews()
//}