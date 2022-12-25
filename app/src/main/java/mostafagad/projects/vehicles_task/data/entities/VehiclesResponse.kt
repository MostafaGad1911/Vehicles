package mostafagad.projects.vehicles_task.data.entities

import com.google.gson.annotations.SerializedName
import mostafagad.projects.vehicles_task.data.models.Vehicle
import mostafagad.projects.vehicles_task.data.models.VehiclesData

data class VehiclesResponse(
    @SerializedName("success") val success: Boolean = true,
    @SerializedName("message") val message: String = "",
    @SerializedName("code") val code: Int = 200,
    @SerializedName("data") val data: VehiclesData
){
    fun vehicles():ArrayList<Vehicle> = data.vehicle
}