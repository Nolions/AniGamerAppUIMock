package tw.nolions.anigamerappuimock.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.nolions.anigamerappuimock.model.Video
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme
import tw.nolions.anigamerappuimock.widget.PageHeaderView
import tw.nolions.anigamerappuimock.widget.VerticalVideoItemView

var favoriteList: ArrayList<Video> = ArrayList()

fun setFavoriteData() {
    val record1 = Video(title = "終末後宮", ep = 1, date = "01/23")
    val record3 = Video(title = "世界頂尖暗殺者轉生為異世界貴族", ep = 1, date = "01/23")
    val record5 = Video(title = "機動戰士鋼彈 00", ep = 1, date = "01/23")
    val record6 = Video(title = "星期一的豐滿", ep = 1, date = "01/23")
    val record7 = Video(title = "境界戰機 第二季", ep = 1, date = "01/23")
    val record9 = Video(title = "星期一的豐滿 第二季", ep = 1, date = "01/23")

    records = ArrayList()
    records.add(record1)
    records.add(record3)
    records.add(record3)
    records.add(record5)
    records.add(record5)
    records.add(record6)
    records.add(record7)
    records.add(record9)
}

@ExperimentalFoundationApi
@Composable
fun VideoFavoriteView() {
    setRecordsData()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PageHeaderView(title = "收藏")

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp)
        ) {
            records.forEachIndexed { index, item ->
                item {
                    VerticalVideoItemView(index, item)
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun VideoFavoriteViewPreview() {
    AniGamerAppUIMockTheme {
        VideoFavoriteView()
    }
}