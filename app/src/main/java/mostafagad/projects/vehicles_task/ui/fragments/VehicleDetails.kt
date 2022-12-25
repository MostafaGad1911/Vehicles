package mostafagad.projects.vehicles_task.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import mostafagad.projects.vehicles_task.R
import mostafagad.projects.vehicles_task.data.models.Vehicle
import mostafagad.projects.vehicles_task.databinding.FragmentVehicleDetailsBinding


class VehicleDetails : Fragment() {

    val vehicle:Vehicle by lazy {
        arguments?.getSerializable("vehicle") as Vehicle
    }
    private lateinit var vehicleDetailsBinding: FragmentVehicleDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        vehicleDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vehicle_details, container, false)
        vehicleDetailsBinding.lifecycleOwner = this
        return vehicleDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vehicleDetailsBinding.executePendingBindings()
        bindDetails(vehicle = vehicle)

    }
    private fun bindDetails(vehicle: Vehicle){
        vehicleDetailsBinding.vehicle = vehicle

    }

}