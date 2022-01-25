package tw.nolions.anigamerappuimock.view.record

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tw.nolions.anigamerappuimock.model.VideoRecord
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme
import tw.nolions.anigamerappuimock.widget.PageHeaderView
import tw.nolions.anigamerappuimock.widget.VideoRecordItemView

var records: ArrayList<VideoRecord> = ArrayList()

fun setRecordsData() {
    val record1 = VideoRecord(title = "終末後宮", ep = 1, date = "01/23")
    val record2 = VideoRecord(title = "一拳超人", ep = 1, date = "01/23")
    val record3 = VideoRecord(title = "世界頂尖暗殺者轉生為異世界貴族", ep = 1, date = "01/23")
    val record4 = VideoRecord(title = "機動戰士鋼彈 OO 第二季", ep = 1, date = "01/23")
    val record5 = VideoRecord(title = "機動戰士鋼彈 00", ep = 1, date = "01/23")
    val record6 = VideoRecord(title = "星期一的豐滿 第二季", ep = 1, date = "01/23")
    val record7 = VideoRecord(title = "境界戰機 第二季", ep = 1, date = "01/23")
    val record8 = VideoRecord(title = "月光下的異世界之旅", ep = 1, date = "01/23")
    val record9 = VideoRecord(title = "星期一的豐滿 第二季", ep = 1, date = "01/23")
    val record10 = VideoRecord(title = "星期一的豐滿 第二季", ep = 1, date = "01/23")

    records = ArrayList()
    records.add(record1)
    records.add(record2)
    records.add(record3)
    records.add(record4)
    records.add(record5)
    records.add(record6)
    records.add(record7)
    records.add(record8)
    records.add(record9)
    records.add(record10)
}

@Composable
fun VideoRecordsView() {
    setRecordsData()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        
        PageHeaderView(title = "紀錄")

        LazyColumn {
            records.forEachIndexed { index, item ->
                item {
                    VideoRecordItemView(index, item)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VideoRecordsViewPreview() {
    AniGamerAppUIMockTheme {
        VideoRecordsView()
    }
}
