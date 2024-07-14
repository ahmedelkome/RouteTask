package com.route.route_task.ui.product.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
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
import com.route.route_task.ui.product.fragment.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {
    private var adapter: ProductAdapter? = null
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
        initRecyclerView()

        observeLiveData()
    }

    private fun initRecyclerView() {
        adapter = ProductAdapter(listOf())
        binding.rvProduct.adapter = adapter
    }

    private fun getProducts() {

    }

    private fun observeLiveData() {
        productFragmentViewModel.getAllProducts()
        productFragmentViewModel.loadingLiveData.observe(viewLifecycleOwner) {
            if (it == true) {
                showLoading()
            } else {
                hideLoading()
            }
        }
        productFragmentViewModel.errorMessage.observe(viewLifecycleOwner) {
            it.posBtn?.let { it1 ->
                it.navBtn?.let { it2 ->
                    showError(
                        title = it.title,
                        message = it.message,
                        posTitle = it.posTitle,
                        navTitle = it.navTitle,
                        posBtn = it1,
                        navBtn = it2

                    )
                }
            }
        }
        productFragmentViewModel.prodcutListLiveData.observe(viewLifecycleOwner) {
            bindProduct(it)
        }
    }

    private fun bindProduct(list: List<Product>) {
        adapter?.let {
            it.updateList(list)
        }
        binding.rvProduct.adapter = adapter
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
        title: String? = null,
        message: String? = null,
        posTitle: String? = null,
        posBtn: (() -> Unit),
        navTitle: String? = null,
        navBtn: (() -> Unit)
    ) {
        val builder = AlertDialog.Builder(requireActivity())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                posTitle
            ) { dialog, which -> posBtn.invoke() }
            .setNegativeButton(
                navTitle
            ) { dialog, which -> navBtn.invoke() }
        builder.create().show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}