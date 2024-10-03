package com.example.locationapp

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.locationapp.ui.theme.LocationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: LocationViewModel = viewModel()
            LocationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   MyApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(viewModel: LocationViewModel){
    val context = LocalContext.current
    val locationUtils = LocationUtils(context)
    LocationDisplay(locationUtils = locationUtils, viewModel , context =context )
}

@Composable
fun LocationDisplay(locationUtils: LocationUtils,
                    viewModel: LocationViewModel,
                    context:Context){

    val location = viewModel.location.value

    val address = location?.let {
        locationUtils.reverseGeocodeLocation(location)
    }

//requestPermissionLauncher ai puro bracker er angser j code ache ata evabei likhte hobe akhane just koyta permission
    // and ki permission setate change ante hobe shudu jemos ACCE SS_COARSE_LOCATION naki ACCESS_FINE_LOCATION naki onno kisu
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult ={ permissions ->
                if(permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                    && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true){
                    // I have access to location

                    locationUtils.requestLocationUpdates(viewModel = viewModel )


                }else {
                    // Ask for permission
                    val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                        context as MainActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) || ActivityCompat.shouldShowRequestPermissionRationale(
                        context as MainActivity,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )

                    if (rationaleRequired){
                        Toast.makeText(context,
                            "Location permission is required for this feature to work", Toast.LENGTH_LONG)
                            .show()
                    }else{
                        Toast.makeText(context,
                            "Location permission is required please enable it in your phone settings", Toast.LENGTH_LONG)
                            .show()

                    }

                }

                })


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        if(location!=null){
            Text("Address: ${location.latitude} , ${location.longitude}\n $address")
        }else {
            Text(text = "Location Not Available.")
        }

        Button(onClick = {
            if (locationUtils.hasLocationPermission(context)){
                // permission already granted update the location
                locationUtils.requestLocationUpdates(viewModel)

            }else{
                //Request Location permission ( ai angser code a shudu requestPermission ta launch kora hoise)
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )


            }
        }) {
            Text(text = "Get Location")

        }
    }

}

