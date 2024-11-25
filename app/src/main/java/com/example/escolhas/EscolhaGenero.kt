package com.example.escolhas

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun EscolhaGenero(navController: NavController) {
    val generos = listOf(
        "Infantil" to R.drawable.infantil,
        "Clássicos" to R.drawable.classicos,
        "Romântico" to R.drawable.romantico,
        "Terror" to R.drawable.terror,
        "Comédia" to R.drawable.comedia,
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fundo),
            contentDescription = "Fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Spacer(modifier = Modifier.height(123.dp))

            Image(
                painter = painterResource(id = R.drawable.logotipo),
                contentDescription = "Logotipo",
                modifier = Modifier.size(150.dp)
            )

            Text(
                text = buildAnnotatedString {
                    append("Escolha o ")
                    withStyle(style = SpanStyle(color = Color(0xFFE3CA0B))) {
                        append("gênero:")
                    }
                },
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    fontSize = 26.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )

            HorizontalPager(
                state = pagerState,
                count = generos.size,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) { page ->
                val (genero, icone) = generos[page]

                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFE3CA0B)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = icone),
                            contentDescription = genero,
                            modifier = Modifier.size(100.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = genero,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = Color(0xFFE3CA0B),
                inactiveColor = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    coroutineScope.launch {
                        val generoSelecionado = generos[pagerState.currentPage].first
                        navController.navigate("filme/$generoSelecionado")
                    }
                },
                modifier = Modifier
                    .padding(bottom = 45.dp)
                    .height(60.dp)
                    .fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE3CA0B)),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Sortear Filme",
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
