package io.easycontext.blueprint.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.easycontext.blueprint.ui.greeting.greetingGraph
import io.easycontext.blueprint.ui.greeting.greetingRoute

@Composable
fun BlueprintNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = greetingRoute,
    ) {
        greetingGraph()
    }
}

