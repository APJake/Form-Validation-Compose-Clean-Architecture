package com.apjake.formvalidationcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.apjake.formvalidationcompose.ui.theme.FormValidationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormValidationComposeTheme {

            }
        }
    }
}
