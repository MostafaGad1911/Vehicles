package mostafagad.projects.vehicles_task.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import mostafagad.projects.vehicles_task.R
import mostafagad.projects.vehicles_task.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var controller:NavController
    private val binding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this , R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.vehiclesFragmentsContainer) as NavHostFragment
        controller = navHostFragment.navController
    }


}