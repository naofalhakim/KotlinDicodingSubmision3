package com.example.user.kotlinsubmisi2.View

import com.example.user.kotlinsubmisi2.Model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}