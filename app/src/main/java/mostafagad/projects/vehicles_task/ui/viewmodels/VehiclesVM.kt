package mostafagad.projects.vehicles_task.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mostafagad.projects.vehicles_task.data.models.Vehicle
import mostafagad.projects.vehicles_task.data.repository.VehicleRepo
import mostafagad.projects.vehicles_task.usecases.VehiclesUseCases
import javax.inject.Inject

@HiltViewModel
class VehiclesVM @Inject constructor(private val vehiclesRepo: VehicleRepo): ViewModel () {

    private val vehiclesState = MutableStateFlow(ArrayList<Vehicle>())
    var vehiclesValue: StateFlow<ArrayList<Vehicle>> = vehiclesState

    init {
        loadVehicles()
    }

    private fun loadVehicles() = viewModelScope.launch(Dispatchers.Default) {
        vehiclesState.emit(vehiclesRepo.getVehicles())
    }
}