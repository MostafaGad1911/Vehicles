package mostafagad.projects.vehicles_task.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mostafagad.projects.vehicles_task.data.models.Vehicle
import mostafagad.projects.vehicles_task.data.entities.VehiclesResponse
import java.io.IOException

fun Context.getVehicles(): ArrayList<Vehicle> {

    lateinit var jsonString: String
    try {
        jsonString = assets.open("vehicles.json")
            .bufferedReader()
            .use { it.readText() }

    } catch (ioException: IOException) {
        Log.e("VehiclesIO" , ioException.message.toString())
    }

    val vehicleResponse = object : TypeToken<VehiclesResponse>() {}.type
    return Gson().fromJson<VehiclesResponse?>(jsonString, vehicleResponse).vehicles()
}
