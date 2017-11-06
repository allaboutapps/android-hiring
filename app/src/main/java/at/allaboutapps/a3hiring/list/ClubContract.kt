package at.allaboutapps.a3hiring.list

import at.allaboutapps.a3hiring.api.models.Club

/**
 *
 */

interface ClubContract {

  interface View {
    fun showListData(clubList: List<Club>)
    fun showError(error: Throwable)
  }

  interface Presenter {

    fun loadListData()
    fun toggleSort()
  }
}
