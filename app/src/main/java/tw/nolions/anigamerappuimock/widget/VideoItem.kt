package tw.nolions.anigamerappuimock.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.nolions.anigamerappuimock.R
import tw.nolions.anigamerappuimock.model.VideoRecord
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme

@Composable
fun VideoRecordItemView(index: Int, record: VideoRecord) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .selectable(
                selected = true,
                onClick = {
                    println("RecordListView $index item click")
                }
            )

    ) {
        Image(
            painter = painterResource(id = R.drawable.image_400_600),
            contentDescription = "Video Cover",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(80.dp)
                .height(120.dp)
        )
        Column(modifier = Modifier.padding(4.dp)) {
            Text(text = "${record.title} ${record.ep}")
            Text(text = record.date)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VideoRecordItemViewPreview() {
    AniGamerAppUIMockTheme {
        VideoRecordItemView(
            1,
            VideoRecord(title = "終末後宮", ep = 1, date = "01/23")
        )
    }
}