package com.route.route_task.ui.models

data class ViewMessage(
    val title: String = "",
    val message: String = "",
    val posTitle: String = "",
    val navTitle: String = "",
    val posBtn: (() -> Unit)? = null,
    val navBtn: (() -> Unit)? = null,
) {
}