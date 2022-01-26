package tw.nolions.anigamerappuimock.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.nolions.anigamerappuimock.model.Video
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme
import tw.nolions.anigamerappuimock.widget.videoCoverItemView

@ExperimentalFoundationApi
@Composable
fun recommendView() {
    var recommendTabIndex by remember { mutableStateOf(0) }
    val recommendItems = listOf("本季新番", "週期表")

    Column() {
        TabRow(
            selectedTabIndex = recommendTabIndex,
            backgroundColor = Color.White,
            modifier = Modifier.requiredWidth(188.dp)
        ) {
            recommendItems.forEachIndexed { index, title ->
                Tab(selected = recommendTabIndex == index,
                    onClick = { recommendTabIndex = index },
                    text = { Text(text = title) })
            }
        }
        when (recommendTabIndex) { // 6.
            0 -> seasonView()
            1 -> weeklyView()
        }
    }
}

var seasonVideos: ArrayList<Video> = ArrayList()

private fun videoDataBySeason(): ArrayList<Video> {
    val video1 = Video(title = "終末後宮", ep = 1, date = "01/23")
    val video2 = Video(title = "一拳超人", ep = 1, date = "01/23")
    val video3 = Video(title = "世界頂尖暗殺者轉生為異世界貴族", ep = 1, date = "01/23")
    val video4 = Video(title = "機動戰士鋼彈 OO 第二季", ep = 1, date = "01/23")
    val video5 = Video(title = "機動戰士鋼彈 00", ep = 1, date = "01/23")
    val video6 = Video(title = "星期一的豐滿", ep = 1, date = "01/23")
    val video7 = Video(title = "境界戰機 第二季", ep = 1, date = "01/23")
    val video8 = Video(title = "月光下的異世界之旅", ep = 1, date = "01/23")
    val video9 = Video(title = "星期一的豐滿 第二季", ep = 1, date = "01/23")

    val seasonVideos: ArrayList<Video> = ArrayList()
    seasonVideos.add(video1)
    seasonVideos.add(video2)
    seasonVideos.add(video3)
    seasonVideos.add(video4)
    seasonVideos.add(video5)
    seasonVideos.add(video6)
    seasonVideos.add(video7)
    seasonVideos.add(video8)
    seasonVideos.add(video9)

    return seasonVideos
}

@ExperimentalFoundationApi
@Composable
fun seasonView() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp)
    ) {
        videoDataBySeason().forEachIndexed { index, item ->
            item {
                videoCoverItemView(index, item)
            }
        }
    }
}

@Composable
fun weeklyView() {
    Text("weekly")
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun RecommendViewPreview() {
    AniGamerAppUIMockTheme {
        recommendView()
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun SeasonViewPreview() {
    AniGamerAppUIMockTheme {
        seasonView()
    }
}

@Preview(showBackground = true)
@Composable
fun WeeklyViewPreview() {
    AniGamerAppUIMockTheme {
        weeklyView()
    }
}
