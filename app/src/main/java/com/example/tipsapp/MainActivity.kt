package com.example.tipsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipsapp.ui.theme.TipsAppTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}


@Composable
fun TipTimeLayout() {

    var amountInput  by remember{ mutableStateOf("")}
    val amount = amountInput.toDoubleOrNull() ?: 0.0

    var tipPercent by remember { mutableStateOf("") }
    val percent = tipPercent.toDoubleOrNull() ?: 0.0

    var roundUp by remember { mutableStateOf(false) }

    val tip = calculateTip(amount,percent,roundUp)


    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {



        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )

        EditNumberField(value = amountInput,
            onValueChange = {amountInput = it},
            percentValue = tipPercent,
            onPercentChange = {tipPercent = it},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth())

        RoundTheTip(
            roundUp = roundUp,
            onRoundUpCanged = { roundUp = it },
            modifier = Modifier.padding(bottom = 32.dp))

        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))



    }
}


@Composable
fun EditNumberField(

                    value: String, // adding the valu and on valuechange to hoist or lift the state
                    onValueChange:(String) -> Unit,
                    percentValue : String,
                    onPercentChange : (String) -> Unit,
                    modifier: Modifier = Modifier) {


    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.bill_amount))},
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )

//    Spacer(modifier = Modifier.height(80.dp))
    
    TextField(value = percentValue,
        onValueChange = onPercentChange,
        label = { Text(stringResource(R.string.tip_percentage))},
        singleLine = true,
        modifier = modifier
        )



}

@Composable
fun RoundTheTip(modifier : Modifier = Modifier,
                roundUp : Boolean,
                onRoundUpCanged : (Boolean) -> Unit
                ){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

       Text(stringResource(R.string.round_up_tip))

        Switch(checked = roundUp,
            onCheckedChange = onRoundUpCanged ,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
            )
    }

}


@VisibleForTesting
internal fun calculateTip(amount: Double, percent: Double, roundUp: Boolean): String {
    var tip = percent / 100 * amount
    if(roundUp){
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun TipTimeLayoutPreview() {
    TipsAppTheme {
        TipTimeLayout()
    }
}


