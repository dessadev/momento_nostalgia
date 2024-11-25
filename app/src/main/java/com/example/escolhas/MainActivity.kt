package com.example.escolhas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.escolhas.ui.theme.EscolhasTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EscolhasTheme {
                val navController = rememberNavController()

                Scaffold { innerPadding ->

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            Home(innerPadding = innerPadding, navController = navController)
                        }
                        composable("escolha_genero") {
                            EscolhaGenero(navController = navController)
                        }
                        composable("filme/{genero}") { backStackEntry ->
                            val genero = backStackEntry.arguments?.getString("genero")
                            Filme(navController = navController, genero = genero)
                        }

                    }
                }
            }
        }
    }


    @Composable
    fun Home(innerPadding: PaddingValues, navController: NavController) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Image(
                painter = painterResource(id = R.drawable.fundo),
                contentDescription = "Fundo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Spacer(modifier = Modifier.height(280.dp))
                Image(
                    painter = painterResource(id = R.drawable.logotipo),
                    contentDescription = "Logotipo",
                    modifier = Modifier.size(210.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .border(
                            width = 0.5.dp,
                            color = Color(0xFFE3CA0B),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("Escolha o ")
                            withStyle(style = SpanStyle(color = Color(0xFFE3CA0B))) {
                                append("gênero")
                            }
                            append(" do filme para sortear:")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                            color = Color.White,
                            fontSize = 22.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("escolha_genero")
                    },
                    modifier = Modifier
                        .padding(top = 45.dp)
                        .height(60.dp)
                        .fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE3CA0B)),
                    shape = RoundedCornerShape(16.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Começar",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.montserrat_black)),
                            color = Color.Black,
                            fontSize = 22.sp
                        )
                    )
                }
            }
        }
    }
}


