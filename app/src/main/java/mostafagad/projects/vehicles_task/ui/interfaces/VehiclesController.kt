package mostafagad.projects.vehicles_task.ui.interfaces

import mostafagad.projects.vehicles_task.data.models.Vehicle

interface VehiclesController {
    fun getVehicleDetails(vehicle: Vehicle)
}