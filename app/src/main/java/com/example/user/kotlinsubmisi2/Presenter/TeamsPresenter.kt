package com.example.user.kotlinsubmisi2.Presenter

import com.example.user.kotlinsubmisi2.Model.ApiConfig.ApiRepository
import com.example.user.kotlinsubmisi2.View.TeamsView
import com.example.user.kotlinsubmisi2.Model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson
) {
    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(ApiRepository.TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}