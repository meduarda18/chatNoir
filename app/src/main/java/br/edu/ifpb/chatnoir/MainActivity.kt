package br.edu.ifpb.chatnoir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifpb.chatnoir.ui.theme.ChatNoirTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.edu.ifpb.chatnoir.R
import br.edu.ifpb.chatnoir.enums.EstadoCelula
import br.edu.ifpb.chatnoir.enums.TipoJogador
import br.edu.ifpb.chatnoir.model.Partida

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatNoirTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ChatNoirGame() {
    val partida = remember { mutableStateOf(Partida()) }
    val refresh = remember { mutableStateOf(false) } // só para forçar recomposição

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        // Placar de vitórias
        Text(
            text = "Vitórias do jogador: ${partida.value.jogador.vitorias}",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tabuleiro 11x11
        for (linha in 0 until partida.value.tabuleiro.tamanho) {
            Row(
                modifier = Modifier.padding(start = if (linha % 2 == 0) 16.dp else 0.dp)
            ) {
                for (coluna in 0 until partida.value.tabuleiro.tamanho) {
                    val celula = partida.value.tabuleiro.getCelula(linha, coluna)

                    if (celula.estadoCelula == EstadoCelula.GATO) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .padding(2.dp)
                                .clickable(enabled = partida.value.emAndamento) {
                                    partida.value.jogadaJogador(linha, coluna)
                                    partida.value.jogadaGato()
                                    refresh.value = !refresh.value
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image),
                                contentDescription = "Gato",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    } else {
                        val color = when (celula.estadoCelula) {
                            EstadoCelula.VAZIA -> Color(0xFFCCFF00)
                            EstadoCelula.BLOQUEADA -> Color(0xFF669900)
                            else -> Color.Transparent
                        }
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .padding(2.dp)
                                .background(color, shape = CircleShape)
                                .clickable(enabled = partida.value.emAndamento) {
                                    partida.value.jogadaJogador(linha, coluna)
                                    partida.value.jogadaGato()
                                    refresh.value = !refresh.value
                                }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Mensagem de fim de jogo
        if (!partida.value.emAndamento) {
            val vencedor = partida.value.getVencedor()
            Text(
                text = when (vencedor) {
                    TipoJogador.GATO -> "O gato escapou!"
                    TipoJogador.JOGADOR -> "Você venceu!"
                    else -> ""
                },
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Botão reiniciar
            Button(onClick = {
                partida.value.reiniciar()
                refresh.value = !refresh.value
            }) {
                Text("Reiniciar")
            }
        }
    }
}