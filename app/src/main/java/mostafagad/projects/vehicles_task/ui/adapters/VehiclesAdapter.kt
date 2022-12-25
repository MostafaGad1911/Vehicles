package mostafagad.projects.vehicles_task.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import mostafagad.projects.vehicles_task.R
import mostafagad.projects.vehicles_task.data.models.Vehicle
import mostafagad.projects.vehicles_task.databinding.VehicleItemBinding
import mostafagad.projects.vehicles_task.ui.interfaces.VehiclesController

class VehiclesAdapter(private val vehiclesList: ArrayList<Vehicle>, vehiclesController: VehiclesController? = null) :
    RecyclerView.Adapter<VehiclesAdapter.VehicleHolder>() {

    private lateinit var scaleAnim: Animation
    private var mLastPosition: Int = -1
    private lateinit var recyclerView: RecyclerView

    private val _vehiclesController:VehiclesController? = vehiclesController

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    class VehicleHolder(private val vehicleItemBinding: VehicleItemBinding) : ViewHolder(vehicleItemBinding.root) {
        fun bind(item: Vehicle){
            vehicleItemBinding.vehicle = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleHolder {
        val inflater = LayoutInflater.from(parent.context)
        val vehicleItemBinding = VehicleItemBinding.inflate(inflater , parent , false)
        return VehicleHolder(vehicleItemBinding)

    }

    override fun onBindViewHolder(holder: VehicleHolder, position: Int) {
        startAnimation(vew = holder.itemView, position = position)
        Log.i("MY_VEHICLES" , vehiclesList[position].toString())

        holder.bind(item = vehiclesList[position])
        holder.itemView.setOnClickListener{
            _vehiclesController?.getVehicleDetails(vehicle = vehiclesList[position])
        }

    }

    override fun getItemCount(): Int = vehiclesList.size

    private fun startAnimation(vew:View, position:Int){
        if (position > mLastPosition) {
            scaleAnim = AnimationUtils.loadAnimation(vew.context , R.anim.fall_down)
            vew.startAnimation(scaleAnim)
            mLastPosition = position
        }
    }

}