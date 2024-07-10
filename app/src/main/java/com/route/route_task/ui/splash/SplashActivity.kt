package com.route.route_task.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.route.route_task.databinding.ActivitySplashBinding
import com.route.route_task.ui.product.activity.ProductActivity

class SplashActivity : AppCompatActivity() {
    private var _binding: ActivitySplashBinding? = null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()
        NavigateToProducts()
    }

    private fun NavigateToProducts() {
        Handler(mainLooper).postDelayed({
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}