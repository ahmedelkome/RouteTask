package com.route.route_task.ui.product.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.route.domain.models.Product
import com.route.route_task.R
import com.route.route_task.databinding.FragmentProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {
    var dialog: AlertDialog? = null
    private var _binding: FragmentProductBinding? = null
    val binding get() = _binding!!
    val productFragmentViewModel: ProductFragmentViewModel by viewModels<ProductFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getProducts()
        observeLiveData()
    }

    private fun getProducts() {
        productFragmentViewModel.getAllProducts()
    }

    private fun observeLiveData() {
        productFragmentViewModel.loadingLiveData.observe(viewLifecycleOwner) {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }
        productFragmentViewModel.errorMessage.observe(viewLifecycleOwner) {
            showError(
                title = it.title,
                message = it.message,
                posTitle = it.posTitle,
                navTitle = it.navTitle,
                posBtn = it.posBtn!!,
                navBtn = it.navBtn!!

            )
        }
        productFragmentViewModel.prodcutListLiveData.observe(viewLifecycleOwner){
            bindProduct(it)
        }
    }

    private fun bindProduct(it: List<Product>) {

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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}