package io.easycontext.blueprint.ui.greeting

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val greetingRoute: String = "greeting_route"

fun NavGraphBuilder.greetingGraph() {
    composable(route = greetingRoute) {
        GreetingScreen()
    }
}
