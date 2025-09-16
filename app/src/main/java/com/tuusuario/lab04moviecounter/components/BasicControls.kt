package com.tuusuario.lab04moviecounter.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// AlertDialog
@Composable
fun SampleAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Show Dialog")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Alert") },
            text = { Text("This is an alert dialog") },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
}

// Card
@Composable
fun SampleCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "This is a Card",
            modifier = Modifier.padding(16.dp)
        )
    }
}

// Checkbox
@Composable
fun SampleCheckbox() {
    var checked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text("Check me")
    }
}

// FloatingActionButton
@Composable
fun SampleFloatingActionButton() {
    FloatingActionButton(
        onClick = { }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}

// Icon
@Composable
fun SampleIcon() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Icon(Icons.Default.Home, contentDescription = "Home")
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}

// Image (usando un icono como placeholder)
@Composable
fun SampleImage() {
    Icon(
        Icons.Default.Home,
        contentDescription = "Sample Image",
        modifier = Modifier.size(100.dp)
    )
}

// ProgressBar
@Composable
fun SampleProgressBar() {
    Column {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        CircularProgressIndicator()
    }
}

// RadioButton
@Composable
fun SampleRadioButton() {
    var selected by remember { mutableStateOf(0) }
    val options = listOf("Option 1", "Option 2", "Option 3")

    Column {
        options.forEachIndexed { index, text ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selected == index,
                    onClick = { selected = index }
                )
                Text(text)
            }
        }
    }
}

// Slider
@Composable
fun SampleSlider() {
    var value by remember { mutableStateOf(0.5f) }

    Column {
        Slider(
            value = value,
            onValueChange = { value = it }
        )
        Text("Value: ${(value * 100).toInt()}%")
    }
}

// Spacer (invisible component for spacing)
@Composable
fun SampleSpacer() {
    Column {
        Text("Text 1")
        Spacer(modifier = Modifier.height(32.dp))
        Text("Text 2 with spacer above")
    }
}

// Switch
@Composable
fun SampleSwitch() {
    var checked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text(" Switch is ${if (checked) "ON" else "OFF"}")
    }
}

// TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleTopAppBar() {
    TopAppBar(
        title = { Text("Top App Bar") }
    )
}

// Combined Example
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicControlsDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SampleCard()
        SampleCheckbox()
        SampleRadioButton()
        SampleSlider()
        SampleSwitch()
        SampleProgressBar()
        SampleAlertDialog()
    }
}

// Previews
@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    SampleCard()
}

@Preview(showBackground = true)
@Composable
fun PreviewCheckbox() {
    SampleCheckbox()
}

@Preview(showBackground = true)
@Composable
fun PreviewRadioButton() {
    SampleRadioButton()
}

@Preview(showBackground = true)
@Composable
fun PreviewSlider() {
    SampleSlider()
}

@Preview(showBackground = true)
@Composable
fun PreviewSwitch() {
    SampleSwitch()
}

@Preview(showBackground = true)
@Composable
fun PreviewBasicControls() {
    BasicControlsDemo()
}