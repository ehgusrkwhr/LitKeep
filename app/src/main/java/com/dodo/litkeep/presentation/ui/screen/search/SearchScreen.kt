package com.dodo.litkeep.presentation.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(navController: NavHostController) {
//    SearchContent()

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContent(
    onBackClick: () -> Unit,
    onBarcodeClick: () -> Unit,
    onClearSearch: () -> Unit,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    searchResults: List<String> // 검색 결과 리스트
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("타이틀", style = MaterialTheme.typography.titleLarge) },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { onBarcodeClick() }) {
                        Icon(
                            imageVector = Icons.Default.QrCodeScanner,
                            contentDescription = "바코드 아이콘"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Column {
                // 검색창
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = MaterialTheme.shapes.medium
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "돋보기 아이콘",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    TextField(
                        value = searchQuery,
                        onValueChange = { onSearchQueryChange(it) },
                        placeholder = { Text("검색") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent, // 포커스 상태 배경색
                            unfocusedContainerColor = Color.Transparent, // 비포커스 상태 배경색
                            focusedIndicatorColor = Color.Transparent, // 포커스 상태 테두리
                            unfocusedIndicatorColor = Color.Transparent // 비포커스 상태 테두리
                        )
                    )
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { onClearSearch() }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "검색창 지우기"
                            )
                        }
                    }
                }

                // 광고 영역
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text("AD 광고 영역", style = MaterialTheme.typography.bodyLarge, color = Color.White)
                }
            }
        }
    ) { innerPadding ->
        // 검색 결과 리스트
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(searchResults) { result ->
                ListItem(
                    headlineContent = { Text(result) },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    SearchContent()
}