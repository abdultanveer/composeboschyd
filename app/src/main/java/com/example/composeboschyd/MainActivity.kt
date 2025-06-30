package com.example.composeboschyd

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeboschyd.ui.theme.ComposeboschydTheme

class MainActivity : ComponentActivity() {
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"chick is in the egg getting created --memory is being allocated in the RAM")
        setContent {
            ComposeboschydTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = stringResource(R.string.name),
                        from = "emma",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w(TAG,"hatched -- is visible to the user")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG,"waking up")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"about to sleep")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"hibernating")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"destroyed")
    }
}






//this functiono is returning a textview
@Composable
fun Greeting(name: String,from: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column ( verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)){
        Text(
            fontSize = 100.sp,
            lineHeight = 116.sp,
            text = stringResource(R.string.greeting, name),
            modifier = modifier,
            textAlign = TextAlign.Center

        )
        Text(text = from,fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End))
        Button(
            onClick = {

                var intent = Intent("ineed.calendar.bosch.hyd")
                context.startActivity(intent)
            }) {
            Text(text = "open calendar")
        }

    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box {

        Image(
            painter = image,
            contentDescription = null
        )

        Greeting(
            name = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun imagePreview(){
    GreetingImage(message = "abdul", from = "emma" )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeboschydTheme {
        Greeting("Ansari","emma")
    }
}