package mostafagad.projects.vehicles_task.data.models

data class Vehicle(
    val id: Int,
    val brand: VehicleBrand,
    val model: VehicleModel,
    val plate_number: String,
    val color: String,
)
