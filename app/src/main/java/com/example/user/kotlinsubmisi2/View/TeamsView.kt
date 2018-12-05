package com.example.user.kotlinsubmisi2.View

import com.example.user.kotlinsubmisi2.Model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}