import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.portadaapp.R
import kotlinx.coroutines.delay

@Composable
fun PantallaSplash(navController: NavHostController, modifier: Modifier = Modifier) {
    val nombre = "Darius Tiganas"
    val delaySeconds: Long = 2

    Box(
        modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.screen),
            contentDescription = "Logotipo de la aplicacion",
            modifier = Modifier
                .requiredSize(300.dp)
                .align(Alignment.Center)
        )

        Text(
            text = "Hecho por\n$nombre",
            modifier = modifier
                .align(Alignment.BottomCenter),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    LaunchedEffect(true) {
        delay(delaySeconds * 1000)
        navController.navigate("PantallaMain") {
            popUpTo("PantallaSplash") { inclusive = true }
        }
    }
}