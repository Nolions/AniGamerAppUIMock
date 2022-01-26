package tw.nolions.anigamerappuimock.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.nolions.anigamerappuimock.R
import tw.nolions.anigamerappuimock.ui.theme.AniGamerAppUIMockTheme

@Composable
fun SearchView() {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        verticalArrangement = Arrangement.Top,

        ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text(text = "搜尋") },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_search), contentDescription = null,
                    tint = Color.Black
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .border(
                    BorderStroke(width = 1.dp, color = Color.Black),
                    shape = RoundedCornerShape(20)
                )
                .fillMaxWidth()
        )

        Text(text = "最近搜尋")

        Text(text = "熱門搜尋")

        Text(text = "動畫搜尋")
    }
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    AniGamerAppUIMockTheme {
        SearchView()
    }
}