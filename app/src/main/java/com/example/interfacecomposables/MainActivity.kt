package com.example.interfacecomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interfacecomposables.ui.theme.InterfaceComposablesTheme
import androidx.compose.ui.Alignment
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color


//Desenvolvido por Thainá Ferreira da Silva
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfaceComposablesTheme {
               App()
            }
        }
    }
}

//Função App (Inserindo componentes na interface)
@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Adicionando composables
            SimpleCenterAlignedTopAppBar() //barra superior
            AlertDialogSample() //caixa de dialogo (aviso)
        }
    }
}

//Criando preview da função App
@Preview
@Composable //função composta que cria uma parte da interface usando a biblioteca Compose
fun AppPreview(){
    App()
}

//Criando barra superior da interface
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleCenterAlignedTopAppBar() {
    Scaffold( //Função composta que fornece slots para vários componentes
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Thainá",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "description"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(1.dp)
            ) {
            }
        }
    )
}

@Composable
fun AlertDialogSample() {
    val openDialog = remember { mutableStateOf(true) } //criando um estado mutável chamado openDialog. "true" será usado para controlar se o diálogo de alerta deve ser exibido ou não.
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Erro")
            },
            text = {
                Text(text = "O aplicativo parou de funcionar")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Reportar")
                }
            }
        )
    }
}

@Composable
fun SimpleBottomAppBar() {
    BottomAppBar {
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Menu, contentDescription = "Localized description")
        }
    }
}

