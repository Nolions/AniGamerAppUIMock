package tw.nolions.anigamerappuimock.view.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme

@ExperimentalFoundationApi
@Composable
fun ClassificationView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp)
        ) {
            classificationList().forEachIndexed { index, item ->
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(8.dp)
                            .border(
                                BorderStroke(width = 1.dp, color = Color.Black),
                                shape = RoundedCornerShape(8)
                            )
                            .selectable(
                                selected = true,
                                onClick = {
                                    println("Classification $index item click")
                                }
                            ),
                        backgroundColor = Color.White,
                    ) {
                        Box(Modifier.wrapContentSize(Alignment.Center)) {
                            Text(
                                text = item,
                            )
                        }
                    }
                }
            }
        }
    }
}

fun classificationList() = listOf(
    "奇幻冒險", "科幻未來", "青春校園", "幽默搞笑", "戀愛", "溫馨", "靈異神怪",
    "推理懸疑", "料理美食", "社會寫實", "運動競技", "歷史傳記", "闔家觀賞", "雙語",
    "其他", "OVA", "電影版",
)

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun ClassificationViewPreview() {
    AniGamerAppUIMockTheme {
        ClassificationView()
    }
}