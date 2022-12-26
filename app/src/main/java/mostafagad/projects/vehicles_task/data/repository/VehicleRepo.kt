package mostafagad.projects.vehicles_task.data.repository

import mostafagad.projects.vehicles_task.usecases.VehiclesUseCases
import javax.inject.Inject

class VehicleRepo @Inject constructor(private val vehiclesUseCases: VehiclesUseCases) {

    fun getVehicles() = vehiclesUseCases.getVehicles()
}