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

  override fun loadListData() {
    apiService.clubs

            .subscribeOn(Schedulers.io())

            .observeOn(AndroidSchedulers.mainThread())

            .subscribe({ data ->
              Collections.sort(data, SortClub())
              view.showListData(data)

            }, { error -> view.showError(error) })

  }

  private class SortClub : Comparator<Club> {
    override fun compare(club1: Club, club2: Club): Int {

      return club1.name.compareTo(club2.name)
    }
  }
}