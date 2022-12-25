package mostafagad.projects.vehicles_task.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mostafagad.projects.vehicles_task.R
import mostafagad.projects.vehicles_task.data.models.Vehicle
import mostafagad.projects.vehicles_task.databinding.FragmentVehiclesBinding
import mostafagad.projects.vehicles_task.ui.adapters.VehiclesAdapter
import mostafagad.projects.vehicles_task.ui.interfaces.VehiclesController
import mostafagad.projects.vehicles_task.ui.viewmodels.VehiclesVM

@AndroidEntryPoint
class Vehicles : Fragment(), VehiclesController {
    private val vehiclesVM: VehiclesVM by viewModels()

    private val vehiclesList: ArrayList<Vehicle> = ArrayList()

    private val vehiclesAdapter: VehiclesAdapter by lazy {
        VehiclesAdapter(vehiclesController = this, vehiclesList = vehiclesList)
    }

    private lateinit var vehiclesBinding: FragmentVehiclesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        vehiclesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vehicles, container, false)
        vehiclesBinding.lifecycleOwner = this
        return vehiclesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vehiclesBinding.executePendingBindings()
        initVehiclesRV()
        collectsVM()
    }

    private fun initVehiclesRV() {
        val lytManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        vehiclesBinding.vehiclesRV.layoutManager = lytManager
        vehiclesBinding.vehiclesRV.adapter = vehiclesAdapter

    }

    private fun collectsVM() {
        CoroutineScope(Dispatchers.IO).launch {
            vehiclesVM.vehiclesValue.collect {
                vehiclesList.clear()
                vehiclesList.addAll(it)
                vehiclesAdapter.notifyItemRangeInserted(vehiclesList.size.plus(1), it.size)
            }
        }

    }

    override fun getVehicleDetails(vehicle: Vehicle) {
        val bundle = Bundle()
        bundle.putSerializable("vehicle" , vehicle)
        findNavController().navigate(R.id.vehicleDetailsFragment , bundle)

    }

}