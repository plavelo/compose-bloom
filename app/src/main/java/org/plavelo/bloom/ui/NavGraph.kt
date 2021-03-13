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
package org.plavelo.bloom.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import org.plavelo.bloom.ui.screen.home.Home
import org.plavelo.bloom.ui.screen.login.LogIn
import org.plavelo.bloom.ui.screen.welcome.Welcome

object MainDestinations {
    const val WELCOME_ROUTE = "welcome"
    const val LOGIN_ROUTE = "login"
    const val HOME_ROUTE = "home"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.WELCOME_ROUTE) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.WELCOME_ROUTE) {
            Welcome(
                onTapLogin = actions.login,
            )
        }
        composable(MainDestinations.LOGIN_ROUTE) {
            LogIn()
        }
        composable(MainDestinations.HOME_ROUTE) {
            Home()
        }
    }
}

class MainActions(navController: NavHostController) {
    val login: () -> Unit = {
        navController.navigate(MainDestinations.LOGIN_ROUTE)
    }
    val home: () -> Unit = {
        navController.navigate(MainDestinations.HOME_ROUTE)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
