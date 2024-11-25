package com.example.escolhas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Filme(navController: NavController, genero: String?) {
    val filme = remember { mutableStateOf(obterFilmeAleatorio(genero)) }
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Image(
            painter = painterResource(id = filme.value.imagem),
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

            Image(
                painter = painterResource(id = filme.value.logo),
                contentDescription = "Logotipo",
                modifier = Modifier
                    .size(240.dp)
                    .offset(x = 0.dp, y = 120.dp)
            )

            Text(
                text = filme.value.descricao,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center),
                    modifier = Modifier.fillMaxWidth(0.8f)
                    .offset(x = 0.dp, y = 100.dp)
            )

            Button(
                onClick = {
                    uriHandler.openUri(filme.value.link)
                },
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(0.8f)
                    .offset(x = 0.dp, y = 90.dp)
                    .height(60.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFE3CA0B)),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color(0xFFE3CA0B)),

            ) {
                Text(
                    text = "Onde assistir?",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                        fontSize = 20.sp,
                        color = Color(0xFFE3CA0B),
                    )
                )
            }

            Button(
                onClick = {
                    navController.navigate("escolha_genero")
                },
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(0.8f)
                    .offset(x = 0.dp, y = 80.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE3CA0B)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Sortear Novamente",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.montserrat_black)),
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                )
            }
        }
    }
}

data class Filme(
    val imagem: Int,
    val logo: Int,
    val descricao: String,
    val ondeAssistir: String,
    val link: String
    )

fun obterFilmeAleatorio(genero: String?): Filme {
    val filmes = when (genero) {
        "Infantil" -> listOf(
            Filme(R.drawable.bckinfantil01, R.drawable.infantil01, "A Sra. Wilson aceita hospedar o pestinha Dennis em sua casa enquanto os pais dele viajam. Ela só não imagina que o garoto é capaz de tantas travessuras, incluindo a destruição do premiado jardim que seu marido, o Sr. Wilson, cultiva há décadas.", "Onde assistir?", "https://www.primevideo.com/dp/amzn1.dv.gti.04b961e0-8eff-4059-87ee-8deedf01c264?autoplay=0&ref_=atv_cf_strg_wb"),
            Filme(R.drawable.bckinfantil02, R.drawable.infantil02, "Baseado no conto de Roald Dahl, este cômico e fantástico filme segue o jovem Charlie Bucket e seu avô Joe. Eles se juntam a um pequeno grupo de ganhadores de uma competição, os quais vão para um passeio na mágica e misteriosa fábrica do excêntrico Willy Wonka.", "Onde assistir?", "https://www.max.com/br/pt/movies/fantastica-fabrica-de-chocolate/aad8e3ff-05d9-4325-a1eb-585ee5057ccf?utm_source=universal_search"),
            Filme(R.drawable.bckinfantil03, R.drawable.infantil03, "Matilda é uma criança brilhante que cresceu ignorada pelos pais, a ponto de esquecerem de matriculá-la na escola. Quando a menina descobre que possui poderes mágicos e seu pai a manda estudar, ela precisa proteger os colegas da malvada diretora.", "Onde assistir?", "https://www.netflix.com/br/title/70033005?source=35"),
            Filme(R.drawable.bckinfantil04, R.drawable.infantil04, "Os Little vão a um orfanato para adotar um novo membro da família, e um jovem rato chamado Stuart é escolhido. Enquanto George fica inicialmente indiferente com o seu novo irmão, o gato da família, Snowbell, se mostra ainda menos entusiasmado com a ideia de ter um rato e planeja se livrar dele.", "Onde assistir?", "https://www.primevideo.com/dp/amzn1.dv.gti.eea9f66e-df53-4491-511a-f065ba08871c?autoplay=0&ref_=atv_cf_strg_wb"),
        )
        "Clássicos" -> listOf(
            Filme(R.drawable.bckclassico01, R.drawable.classico01, "Marty McFly é transportado para 1955 quando uma experiência de Doc Brown dá errado. No passado, ele encontra seus pais ainda jovens e, sem querer, interfere no romance deles, colocando sua própria existência em risco.", "Onde assistir?", "https://www.primevideo.com/dp/amzn1.dv.gti.f6a9f675-7a13-b722-23c9-82a4a4794997?autoplay=0&ref_=atv_cf_strg_wb"),
            Filme(R.drawable.bckclassico02, R.drawable.classico02, "A adolescente Cady Heron foi educada na África pelos seus pais cientistas. Quando sua família se muda para o Estados Unidos, Cady começa a frequentar a escola pública. Sem querer, ela acaba no meio de um grupo de elite de estudantes", "Onde assistir?", "https://www.netflix.com/br/title/60034551"),
            Filme(R.drawable.bckclassico03, R.drawable.classico03, "O garoto Elliott faz amizade com um pequeno alienígena inofensivo que está bem longe do seu planeta. Ele decide manter a adorável criatura em segredo e em casa após apresentá-la aos irmãos.", "Onde assistir?", "https://www.primevideo.com/dp/amzn1.dv.gti.86ac0f2e-2364-8e52-c91c-ed6ae11922b3?autoplay=0&ref_=atv_cf_strg_wb"),
            Filme(R.drawable.bckclassico04, R.drawable.classico04, "Um artista pobre e uma jovem rica se conhecem e se apaixonam na viagem inaugural do Titanic em 1912. Embora esteja noiva do arrogante herdeiro, a jovem desafia sua família em busca do verdadeiro amor.", "Onde assistir?", "https://www.disneyplus.com/pt-br/movies/titanic/1vXLGiOUqEP9"),
        )
        "Romântico" -> listOf(
            Filme(R.drawable.bckromantico01, R.drawable.romantico01, "Na Carolina do Sul, nos anos 1940, Noah, um operário, e Allie, uma jovem rica, vivem um romance desaprovado pelos pais dela. Separados pela Segunda Guerra, Allie segue outro caminho, mas a paixão renasce quando Noah retorna, perto do casamento dela.", "Onde assistir?", "https://www.max.com/br/pt/movies/diario-de-uma-paixao/2635ac87-887a-4cc7-8dac-5ecf3270ac21?utm_source=universal_search"),
            Filme(R.drawable.bckromantico02, R.drawable.romantico02, "Bianca Stratford é bonita e popular, mas só pode namorar se sua irmã Kat arrumar um namorado primeiro. Para isso, um garoto interessado em Bianca suborna um amigo misterioso para conquistar a difícil Kat.", "Onde assistir?", "https://www.disneyplus.com/pt-br/movies/10-things-i-hate-about-you/10OzquDiTIJB"),
            Filme(R.drawable.bckromantico03, R.drawable.romantico03, "Seth, um anjo que cuida de Los Angeles, se apaixona por Maggie, uma cirurgiã. Ao vê-la sofrer por perder um paciente, ele desenvolve sentimentos que desafiam sua imortalidade e começa a considerar abrir mão da eternidade por esse amor.", "Onde assistir?", "https://www.primevideo.com/dp/amzn1.dv.gti.34a7aaad-3871-41cb-ab6b-ec5ca55032e6?autoplay=0&ref_=atv_cf_strg_wb"),
            Filme(R.drawable.bckromantico04, R.drawable.romantico04, "Frank Farmer, um guarda-costas experiente, é contratado para proteger Rachel Marron, uma famosa cantora ameaçada por cartas anônimas. Enquanto lidam com novos atentados, Frank e Rachel se apaixonam.", "Onde assistir?", "https://www.disneyplus.com/pt-br/movies/titanic/1vXLGiOUqEP9"),
        )
        "Terror" -> listOf(
            Filme(R.drawable.bckterror01, R.drawable.terror01, "Um grupo de jovens enfrenta um assassino mascarado que testa seus conhecimentos sobre filmes de terror. A pequena cidade de Woodsboro nunca mais será a mesma.", "Onde assistir?", "https://www.netflix.com/br/title/939827?source=35"),
            Filme(R.drawable.bckterror02, R.drawable.terror02, "Jack Torrance assume o cargo de caseiro no isolado Hotel Overlook para superar seu bloqueio criativo. Lá, os segredos do hotel e as premonições de seu filho Danny o levam a se tornar uma ameaça à própria família.", "Onde assistir?", "https://www.max.com/br/pt/movies/o-iluminado/9370f169-89d8-48c6-912d-8b10590a4de2?utm_source=universal_search"),
            Filme(R.drawable.bckterror03, R.drawable.terror03, "Um garoto que vê espíritos conta seu segredo ao psicólogo Malcolm Crowe, que tenta ajudá-lo a entender seus dons. A busca por respostas traz consequências inesperadas para os dois.", "Onde assistir?", "https://www.disneyplus.com/pt-br/movies/the-sixth-sense/4t2IIhSGdve0"),
            Filme(R.drawable.bckterror04, R.drawable.terror04, "Ignorando os avisos sobre um antigo homicídio em Crystal Lake, jovens montam um acampamento de verão no local. Os instrutores logo se tornam alvo de um assassino brutal.", "Onde assistir?", "https://www.max.com/br/pt/movies/sexta-feira-13-1980/091df698-401e-42d9-9886-0b9d4c41b460?utm_source=universal_search"),
        )
        "Comédia" -> listOf(
            Filme(R.drawable.bckcomedia01, R.drawable.comedia01, "Após arruinarem uma operação, os agentes do FBI Marcus e Kevin são designados para escoltar duas socialites nos Hamptons. Quando elas recusam, os irmãos, decidem se disfarçar como as jovens.", "Onde assistir?", "https://www.netflix.com/br/title/60034587?source=35"),
            Filme(R.drawable.bckcomedia02, R.drawable.comedia02, "Após o assassinato de uma colega, Cindy Campbell e seus amigos descobrem que há um assassino entre eles, enquanto lidam com a insistente repórter Gail Hailstorm.", "Onde assistir?", "https://www.primevideo.com/dp/amzn1.dv.gti.b87b6e6c-f2d5-4ceb-b032-2eb8b98cd244?autoplay=0&ref_=atv_cf_strg_wb"),
            Filme(R.drawable.bckcomedia03, R.drawable.comedia03, "Stanley Ipkiss, um tímido bancário, encontra uma máscara mágica que lhe dá superpoderes. Porém, ele atrai a atenção do gângster Dorian, que quer usar os poderes da máscara para o mal.", "Onde assistir?", "https://www.max.com/br/pt/movies/o-maskara/1cdd2cef-c4ce-46b0-83c8-62bb9286e5c8?utm_source=universal_search"),
            Filme(R.drawable.bckcomedia04, R.drawable.comedia04, "Dois anos após o caótico casamento de Doug em Las Vegas, é a vez de Stu se casar na Tailândia. Apesar de planejar uma comemoração tranquila, nada sai como esperado, e novas confusões acontecem.", "Onde assistir?", "https://www.primevideo.com/-/pt/detail/Se-Beber-N%C3%A3o-Case-Parte-II/0J1F01YTKKFZ2CKNHMPAMLCFB7"),
            Filme(R.drawable.bckcomedia05, R.drawable.comedia05, "O príncipe Akeem vai aos EUA para fugir de um casamento arranjado e buscar o amor verdadeiro. Disfarçado, ele trabalha em um restaurante e se apaixona por Lisa, escondendo sua identidade.", "Onde assistir?", "https://www.primevideo.com/dp/amzn1.dv.gti.26bb440c-b497-f889-be57-bbaec42984b8?autoplay=0&ref_=atv_cf_strg_wb"),
            )
        else -> emptyList()
    }

    return filmes.random()
}
