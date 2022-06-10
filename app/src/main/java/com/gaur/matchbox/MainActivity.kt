package com.gaur.matchbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gaur.common.base.BaseActivity
import com.gaur.matchbox.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private var _binding:ActivityMainBinding?=null
    private val binding:ActivityMainBinding
    get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this,R.color.grey)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragmentContainer)
         binding.navigationView.setupWithNavController(navController)

        val toggle = ActionBarDrawerToggle(
            this, binding.drawrLayout, binding.toolbar, 0,
            0
        )

        binding.drawrLayout.addDrawerListener(toggle)
        toggle.syncState()



        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            when(destination.id){
                R.id.savedFragment->{
                    binding.appbar.visibility= View.GONE
                }
                R.id.allMatchesFragment->{
                    binding.appbar.visibility= View.VISIBLE
                }
            }


        }

    }



    override fun onBackPressed() {
        if (binding.drawrLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawrLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}