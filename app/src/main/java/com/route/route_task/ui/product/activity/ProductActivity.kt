package com.route.route_task.ui.product.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.route.route_task.R
import com.route.route_task.databinding.ActivityProductBinding
import com.route.route_task.ui.product.fragment.ProductFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {
    private var _binding : ActivityProductBinding?=null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityProductBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()
        initProductFragment()
    }

    private fun initProductFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.product_fragment_container,ProductFragment())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}