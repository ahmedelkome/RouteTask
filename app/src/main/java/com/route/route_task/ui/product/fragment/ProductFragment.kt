package com.route.route_task.ui.product.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.route.route_task.R
import com.route.route_task.databinding.FragmentProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {
    var dialog: AlertDialog? = null
    private var _binding: FragmentProductBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun showLoading() {
        val builder = AlertDialog.Builder(requireActivity())
            .setView(R.layout.loading_layout)
        dialog = builder.create()
        dialog?.let {
            it.show()
        }
    }

    private fun hideLoading() {
        dialog?.let {
            it.dismiss()
        }
    }

    private fun showError(
        title: String,
        message: String,
        posTitle: String,
        posBtn: () -> Unit,
        navTitle: String,
        navBtn: () -> Unit
    ) {
        val dialog = AlertDialog.Builder(requireActivity())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(posTitle) { _, _ ->
                posBtn.invoke()
            }
            .setNegativeButton(navTitle) { _, _ ->
                navBtn.invoke()
            }
            .create()
            .show()
    }
}