package com.example.appaula2503

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appaula2503.ui.theme.*

const val TAG = "TesteAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppAula2503Theme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    var nome by remember { mutableStateOf("") }
    
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFDFDFD)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Logo Educacional
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                // Certifique-se de salvar a imagem como 'education_logo' em res/drawable
                Image(
                    painter = painterResource(id = R.drawable.education_logo),
                    contentDescription = "Logo Educacional",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Greeting("escolar")

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome do Usuário") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = Color.LightGray
                ),
                singleLine = true
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Selecione o Cargo",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ActionButton(
                        text = "Aluno",
                        buttonColors = errorButtonColors(),
                        modifier = Modifier.weight(1f)
                    ) { Log.i(TAG, "Nome: $nome | Cargo: Aluno") }
                    
                    ActionButton(
                        text = "Professor",
                        buttonColors = warningButtonColors(),
                        modifier = Modifier.weight(1f)
                    ) { Log.i(TAG, "Nome: $nome | Cargo: Professor") }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ActionButton(
                        text = "Coordenador",
                        buttonColors = debugButtonColors(),
                        modifier = Modifier.weight(1f)
                    ) { Log.i(TAG, "Nome: $nome | Cargo: Coordenador") }
                    
                    ActionButton(
                        text = "Diretor",
                        buttonColors = infoButtonColors(),
                        modifier = Modifier.weight(1f)
                    ) { Log.i(TAG, "Nome: $nome | Cargo: Diretor") }
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "Sistema de Gestão Escolar",
                style = MaterialTheme.typography.bodySmall,
                color = Color.LightGray
            )
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    block: () -> Unit
) {
    Button(
        onClick = block,
        modifier = modifier.height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = buttonColors,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "SISTEMA",
            style = MaterialTheme.typography.labelMedium,
            letterSpacing = 4.sp,
            color = Color.Gray
        )
        Text(
            text = name.uppercase(),
            modifier = modifier,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            color = DarkGrey
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 740)
@Composable
fun AppPreview() {
    AppAula2503Theme {
        App()
    }
}
