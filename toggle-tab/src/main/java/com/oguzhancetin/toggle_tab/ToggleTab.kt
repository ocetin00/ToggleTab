package com.oguzhancetin.toggle_tab

import android.util.Log
import androidx.compose.runtime.Composable

/**
 * Created by ocetin00 on 22.01.2023
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import  androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

/**
 * Created by ocetin00 on 9.01.2023
 */

@Preview
@Composable
fun ToggleTabPreview1() {
    var selectedPageIndex by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth()
                .background(Color.White), horizontalArrangement = Arrangement.Center
        ) {
            ToggleTab(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.9f)
                    .clip(ShapeDefaults.ExtraLarge),
                onTabSelected = { index ->
                    selectedPageIndex = index
                },
                titleList = listOf("First", "Second", "Third"),
                tabItemTextStyle = TextStyle.Default.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        var backgroundColor: Color = when (selectedPageIndex) {
            0 -> Color.Green
            1 -> Color.Magenta
            2 -> Color.Cyan
            else -> {
                Color.Green
            }
        }
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .background(backgroundColor)
        ) {

        }
    }
}

@Preview
@Composable
fun ToggleTabPreview2() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
    ) {
        ToggleTab(modifier = Modifier.fillMaxWidth(0.6f),titleList = listOf("Male", "Famele"), onTabSelected = {})
    }
}

@Preview
@Composable
fun ToggleTabPreview3() {
    Row(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        ToggleTab(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.9f),
            containerColor = Color.Blue,
            selectedColor = Color.White,
            onTabSelected = { index ->
                Log.e("selectedIndex", "selectedIndex: ${index.toString()}")
            },
            titleList = listOf("First", "Second", "Third"),
            tabItemTextStyle = TextStyle.Default.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun ToggleTab(
    modifier: Modifier = Modifier,
    titleList: List<String>,
    initialSelectedTabIndex: Int = 0,
    tabItemTextStyle: TextStyle? = null,
    containerColor: Color = Color.Blue.copy(alpha = 0.5f),
    selectedColor: Color = Color.White,
    onTabSelected: (Int) -> Unit
) {
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {

        var currentTabIndex by remember { mutableStateOf(initialSelectedTabIndex) }

        TabRow(selectedTabIndex = currentTabIndex,
            modifier = modifier
                .clip(ShapeDefaults.ExtraLarge),
            containerColor = containerColor,
            indicator = {
                Box(
                    Modifier
                        .zIndex(-1f)
                        .tabIndicatorOffset(it[currentTabIndex])
                        .fillMaxSize()
                        .clip(ShapeDefaults.ExtraLarge)
                        .background(selectedColor)
                        .border(0f.dp, containerColor, ShapeDefaults.ExtraLarge)
                )
            },
            divider = {}
        ) {

            val tabModifier = Modifier
                .padding(horizontal = 4.dp)
                .clip(RoundedCornerShape(70.dp))

            titleList.forEachIndexed { index, title ->
                val textColor =
                    if (index == currentTabIndex) containerColor else selectedColor
                Tab(
                    selectedContentColor = Color.Transparent,
                    modifier = tabModifier,
                    selected = false,
                    text = {
                        tabItemTextStyle?.let {
                            Text(text = title, color = textColor, style = tabItemTextStyle)
                        } ?: Text(text = title, color = textColor)
                    },
                    onClick = {
                        currentTabIndex = index
                        onTabSelected(index)
                    }
                )
            }
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}