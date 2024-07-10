package com.route.route_task.ui.product.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.route.route_task.databinding.ActivityProductBinding


class ProductActivity : AppCompatActivity() {
    private var _binding : ActivityProductBinding?=null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityProductBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}