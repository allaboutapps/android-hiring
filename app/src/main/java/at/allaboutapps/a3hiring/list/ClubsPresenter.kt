package at.allaboutapps.a3hiring.list

import at.allaboutapps.a3hiring.api.ApiService
import at.allaboutapps.a3hiring.api.models.Club
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 *
 */
class ClubsPresenter(private val view: ClubContract.View,
                     private val apiService: ApiService) : ClubContract.Presenter {

  private var dataset: List<Club>? = null
  private var currentToggleMode: Boolean = true

  override fun loadListData() {
    apiService.clubs

            .subscribeOn(Schedulers.io())

            .observeOn(AndroidSchedulers.mainThread())

            .subscribe({ data ->
              dataset = data
              Collections.sort(data, SortClubByName())
              view.showListData(data)

            }, { error -> view.showError(error) })

  }

  override fun toggleSort() {
    when (currentToggleMode) {
      true -> sortByValue()
      false -> sortByName()
    }
    view.showListData(dataset!!)
    currentToggleMode = !currentToggleMode
  }

  private fun sortByValue() {
    Collections.sort(dataset, SortClubByValue())
  }

  private fun sortByName() {
    Collections.sort(dataset, SortClubByName())

  }


  private class SortClubByName : Comparator<Club> {
    override fun compare(club1: Club, club2: Club): Int {

      return club1.name.compareTo(club2.name)
    }
  }

  private class SortClubByValue : Comparator<Club> {
    override fun compare(club1: Club, club2: Club): Int {

      return club2.value.compareTo(club1.value)
    }
  }
}