package com.example.hoabhjetpack.view


import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hoabhjetpack.ui.theme.colorPrimary
import com.example.hoabhjetpack.R


@Composable
fun Dashboard(
    navController: NavController,
) {
    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItems = DashboardSection.values().toList()

    Scaffold(
        bottomBar = {
            BottomBar(
                items = navItems,
                currentSection = sectionState.value,
                onSectionSelected = { sectionState.value = it },
            )
        }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier,
            targetState = sectionState.value,
            label = ""
        )
        { section ->
            when (section) {
                DashboardSection.Home -> HomeScreen(navController)
                else -> {}
            }
            when (section) {
                DashboardSection.Activity -> ActivityScreen()
                else -> {}
            }
        }
    }
}

@Preview
@Composable
fun DashboardPreview() = Dashboard(NavController(LocalContext.current))

@Composable
private fun BottomBar(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit,
) {
    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    ) {
        items.forEach { section ->


            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = if (section == DashboardSection.Add) painterResource(id = R.drawable.ic_add) else painterResource(id = iconRes),
                        modifier = if (section == DashboardSection.Add) Modifier.size(48.dp) else Modifier.size(24.dp),
                        contentDescription = "Bottom nav icons"
                    )
                },
                selected = selected,
                unselectedContentColor = if (section == DashboardSection.Add) colorPrimary else Color.Gray,
                selectedContentColor = colorPrimary,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}
@Preview
@Composable
fun BottomBarPreview() = BottomBar(
    currentSection = DashboardSection.Home,
    items = DashboardSection.values().toList(),
    ) {}

private enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int,
) {
    Home(R.drawable.ic_home, R.drawable.ic_home),
    Task(R.drawable.ic_task, R.drawable.ic_task),
    Add(R.drawable.ic_add, R.drawable.ic_add),
    Activity(R.drawable.ic_activity, R.drawable.ic_activity),
    Folder(R.drawable.ic_folder, R.drawable.ic_folder),
}