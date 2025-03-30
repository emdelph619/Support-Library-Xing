package com.example.supportchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.supportchat.ui.theme.SupportChatTheme
import com.example.supportlibrary.SupportChatHelper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            SupportChatTheme {
                var message by remember { mutableStateOf("Loading...") }

                // Load the JSON message
                message = SupportChatHelper.getSupportChatMessage(this)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MessageScreen(message, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MessageScreen(message: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Support Chat Message:")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = message, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun MessageScreenPreview() {
    SupportChatTheme {
        MessageScreen("Sample support chat message")
    }
}
