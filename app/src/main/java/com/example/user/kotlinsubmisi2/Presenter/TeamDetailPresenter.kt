package com.example.user.kotlinsubmisi2.Presenter

import com.example.user.kotlinsubmisi2.Model.ApiConfig.ApiRepository
import com.example.user.kotlinsubmisi2.Model.TeamResponse
import com.example.user.kotlinsubmisi2.View.TeamDetailView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson
) {
    fun getTeamDetail(teamId: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(ApiRepository.TheSportDBApi.getTeamDetail(teamId)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}