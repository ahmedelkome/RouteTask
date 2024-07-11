package com.route.route_task.ui.models

data class ViewMessage(
    val title: String? = null,
    val message: String? = null,
    val posTitle: String? = null,
    val navTitle: String? = null,
    val posBtn: (() -> Unit)? = null,
    val navBtn: (() -> Unit)? = null,
) {
}