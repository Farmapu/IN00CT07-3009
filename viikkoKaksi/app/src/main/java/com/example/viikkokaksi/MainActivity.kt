package com.example.viikkokaksi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viikkokaksi.ui.theme.ViikkoKaksiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViikkoKaksiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Testing()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!?",
        modifier = modifier
    )
}

@Composable
fun Testing() {
    var user by rememberSaveable { mutableStateOf("")}
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp, top = 20.dp),
            text = "Login",
            color = Color.Blue
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp),
            value = user,
            onValueChange = { user = it },
            singleLine = true,
            placeholder = { Text("User") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null
                )
            }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp),
            value = password,
            onValueChange = { password = it },
            singleLine = true,
            placeholder = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null
                )
            }
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 10.dp),
        ) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ViikkoKaksiTheme {

    }
}