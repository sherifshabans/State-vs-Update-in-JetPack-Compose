package com.elsharif.statevsupdateconfigurationinjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun StateScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        /*If we let the text filed as this , it will not work because we haven't value change
         because it state is mutable and need to external state to be able to edit on it
        TextField(value = "", onValueChange ={} )
         */

        /*Now we can use it , be declare :

        var inputText by remember { mutableStateOf("") }
        TextField(
        value = inputText
        , onValueChange ={
        inputText=it
        } )

         */

        // if we move the screen or any update in scene or mood the value will to be find ,we solve this problem by :
        /*Now we can use it , be declare :
        var inputText by rememberSaveable { mutableStateOf("") }
        TextField(
        value = inputText
        , onValueChange ={
        inputText=it
        } )
         */


    }

}

@Composable
fun CounterContent(
    counter:String,
    onClickMinus:()->Unit,
    onClickPlus:()->Unit

) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier=Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(text = counter, fontSize = 96.sp)

            Row {
                Button(onClick = onClickMinus) {

                    Text(text = "-", fontSize = 48.sp)

                }

                Button(onClick = onClickPlus) {

                    Text(text = "+", fontSize = 48.sp)

                }

            }


        }
    }
}


// State Hoisting in Jetpack Compose

@Composable
fun CounterScreen () {


    var counter by remember {
        mutableStateOf(0)
    }
    CounterContent(counter = counter.toString(), onClickMinus = { counter--},onClickPlus={counter++})




}