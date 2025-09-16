package com.tuusuario.lab04moviecounter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow

// LazyColumn Component
@Composable
fun SampleLazyColumn() {
    val items = (1..20).map { "Item $it" }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

// LazyRow Component
@Composable
fun SampleLazyRow() {
    val items = (1..10).map { "Item $it" }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier.width(120.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

// Grid Component (LazyVerticalGrid)
@Composable
fun SampleGrid() {
    val items = (1..12).map { "Grid $it" }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = item)
                }
            }
        }
    }
}

// ConstraintLayout Component
@Composable
fun SampleConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (title, subtitle, button) = createRefs()

        Text(
            text = "Title",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "This is a subtitle using ConstraintLayout",
            modifier = Modifier.constrainAs(subtitle) {
                top.linkTo(title.bottom, 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(subtitle.bottom, 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Action Button")
        }
    }
}

// Scaffold Component
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scaffold Example") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { }
            ) {
                Text("+")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Content inside Scaffold")
        }
    }
}

// Surface Component
@Composable
fun SampleSurface() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primaryContainer,
        shadowElevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Surface Component",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("This content is inside a Surface with elevation")
        }
    }
}

// Chip Component
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleChip() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        AssistChip(
            onClick = { },
            label = { Text("Assist Chip") }
        )
        FilterChip(
            onClick = { },
            label = { Text("Filter Chip") },
            selected = false
        )
        InputChip(
            onClick = { },
            label = { Text("Input Chip") },
            selected = true
        )
    }
}

// FlowRow Component (necesita accompanist)
@Composable
fun SampleFlowRow() {
    val items = listOf("Kotlin", "Android", "Jetpack", "Compose", "Material", "Design", "UI", "Development")

    FlowRow(
        modifier = Modifier.padding(16.dp),
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        items.forEach { item ->
            AssistChip(
                onClick = { },
                label = { Text(item) }
            )
        }
    }
}

// FlowColumn Component (necesita accompanist)
@Composable
fun SampleFlowColumn() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    FlowColumn(
        modifier = Modifier.padding(16.dp),
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        items.forEach { item ->
            Card {
                Text(
                    text = item,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

// Previews
@Preview(showBackground = true)
@Composable
fun PreviewLazyColumn() {
    SampleLazyColumn()
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyRow() {
    SampleLazyRow()
}

@Preview(showBackground = true)
@Composable
fun PreviewGrid() {
    SampleGrid()
}

@Preview(showBackground = true)
@Composable
fun PreviewConstraintLayout() {
    SampleConstraintLayout()
}

@Preview(showBackground = true)
@Composable
fun PreviewSurface() {
    SampleSurface()
}

@Preview(showBackground = true)
@Composable
fun PreviewChip() {
    SampleChip()
}

@Preview(showBackground = true)
@Composable
fun PreviewFlowRow() {
    SampleFlowRow()
}