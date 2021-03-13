/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.plavelo.bloom.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.plavelo.bloom.R
import org.plavelo.bloom.ui.theme.Elevations
import org.plavelo.bloom.ui.theme.MyTheme

sealed class NavItem(val title: String, val icon: ImageVector) {
    object Home : NavItem("Home", Icons.Filled.Home)
    object Favorites : NavItem("Favorites", Icons.Filled.FavoriteBorder)
    object Profile : NavItem("Profile", Icons.Filled.AccountCircle)
    object Cart : NavItem("Cart", Icons.Filled.ShoppingCart)
}

val items = listOf(
    NavItem.Home,
    NavItem.Favorites,
    NavItem.Profile,
    NavItem.Cart,
)

@Composable
fun Home() {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                elevation = Elevations.elevation16,
                modifier = Modifier.height(56.dp),
            ) {
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                            )
                        },
                        label = {
                            Text(
                                item.title,
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onPrimary,
                            )
                        },
                        selected = item == NavItem.Home,
                        onClick = {}
                    )
                }
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
        ) {
            OutlinedTextField(
                "",
                onValueChange = {},
                placeholder = {
                    Text(
                        stringResource(R.string.search_placeholder),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                    )
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    MyTheme {
        Home()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Home()
    }
}
