package com.example.btown.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.btown.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationUI.setupWithNavController(
            bottom_navigation, findNavController(R.id.navigation_host)
        )

        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.navigation_host),
            AppBarConfiguration(
                setOf(
                    R.id.homeFragment,
                    R.id.categoryFragment,
                    R.id.boardFragment,
                    R.id.notificationFragment,
                    R.id.myPageFragment
                )
            )
        )
    }

    override fun onSupportNavigateUp() = findNavController(R.id.navigation_host).navigateUp()
}