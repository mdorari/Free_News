package com.mehrdad.freenews.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehrdad.freenews.R
import com.mehrdad.freenews.presentation.LocalSpacing
import com.mehrdad.freenews.ui.theme.Primary
import com.mehrdad.freenews.ui.theme.Secondary

@Composable
fun NotificationCard() {
    val spacing = LocalSpacing.current
    Column {
        Row(
            modifier = Modifier.padding(
                vertical = spacing.spaceSmall,
                horizontal = spacing.spaceLarge
            )
        ) {
            Image(
                modifier = Modifier
                    .width(55.dp)
                    .aspectRatio(.75f)
                    .clip(RoundedCornerShape(spacing.spaceSmall)),
                painter = painterResource(id = R.drawable.sample_image),

                //            painter = rememberAsyncImagePainter(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(sampleImage)
//                    .size(coil.size.Size.ORIGINAL)
//                    .crossfade(true)
//                    .build()
//            ),

                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
            Column(modifier = Modifier.padding(horizontal = spacing.spaceSmall)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier.width(24.dp),
                        painter = painterResource(id = R.drawable.news_agency_icon),
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                    Text(text = "Rappler",
                        modifier = Modifier.padding(start = spacing.spaceExtraSmall),
                        color = Primary,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                        fontSize = 18.sp,
                        letterSpacing = (-0.5).sp,
                    )
                }
                Text(text = "Inbounded a News: “Philippines' military conducts successful operations against Islamist extremist groups”",
                    color = Secondary,
                    fontWeight = FontWeight.Thin,
                    fontFamily = FontFamily(Font(R.font.archivo_variable_font_wdth_wght)),
                    fontSize = 12.sp,
                    letterSpacing = 0.sp,
                    maxLines = 3
                )
            }
        }
        Spacer(modifier = Modifier
            .padding(horizontal = spacing.spaceSmall)
            .height(1.dp)
            .fillMaxWidth()
            .background(Secondary))
    }
}

@Preview(
    device = "spec:width=1440px,height=2560px,dpi=560", showSystemUi = true,
    showBackground = true
)
@Composable
fun NotificationPrev() {
    NotificationCard()
}