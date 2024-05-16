package com.mehrdad.freenews.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehrdad.freenews.R
import com.mehrdad.freenews.data.remote.model.remote.Article
import com.mehrdad.freenews.data.remote.model.remote.Source
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.ui.theme.Primary


@Composable
fun NewsAgencyName(article: Article) {
    val spacing = LocalSpacing.current
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .padding(end = spacing.spaceSemiMedium)
                .width(40.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(spacing.spaceXXLarge)),
            painter = painterResource(id = R.drawable.news_agency_icon),
            contentDescription = "News agency icon"
        )
        Column(verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = article.source.name,
                color = Primary,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                fontSize = 16.sp,
                letterSpacing = (-0.5).sp,
            )
            Text(
                text = article.publishedAt?:"no date",
                color = Primary,
                fontWeight = FontWeight.Thin,
                fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                fontSize = 12.sp,
                letterSpacing = (-0.5).sp,
            )
        }
    }
}

@Preview(
    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
    showBackground = true
)
@Composable
fun NewsAgencyNamePrev() {
    NewsAgencyName(
        article = Article(
            author = "",
            title = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
            description = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
            content = "We use cookies and data to Deliver and maintain Google services Track outages and protect against spam, fraud, and abuse Measure audience engagement and site statistics to unde… [+1131 chars]",
            publishedAt = "2023-06-16T22:24:33Z",
            source = Source(
                id = "", name = "bbc"
            ),
            url = "https://consent.google.com/ml?continue=https://news.google.com/rss/articles/CBMiaWh0dHBzOi8vY3J5cHRvc2F1cnVzLnRlY2gvY29pbmJhc2Utc2F5cy1hcHBsZS1ibG9ja2VkLWl0cy1sYXN0LWFwcC1yZWxlYXNlLW9uLW5mdHMtaW4td2FsbGV0LXJldXRlcnMtY29tL9IBAA?oc%3D5&gl=FR&hl=en-US&cm=2&pc=n&src=1",
            urlToImage = "https://media.wired.com/photos/6495d5e893ba5cd8bbdc95af/191:100/w_1280,c_limit/The-EU-Rules-Phone-Batteries-Must-Be-Replaceable-Gear-2BE6PRN.jpg"
        ),
    )
}