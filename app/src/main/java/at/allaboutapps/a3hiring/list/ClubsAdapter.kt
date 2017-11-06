package at.allaboutapps.a3hiring.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import at.allaboutapps.a3hiring.R
import at.allaboutapps.a3hiring.api.models.Club
import at.allaboutapps.a3hiring.list.vh.ClubsAdapterViewHolder

/**
 * View v=  LayoutInflater.from(context).inflate(R.layout.item_club, parent, false)
 */
class ClubsAdapter(val context: Context) : RecyclerView.Adapter<ClubsAdapterViewHolder>() {

  private var dataset = arrayListOf<Club>()

  fun setDataset(newDataset: List<Club>) {
    dataset.clear()
    dataset.addAll(newDataset)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubsAdapterViewHolder {
    val layout = LayoutInflater.from(context).inflate(R.layout.item_club, parent, false)
    return ClubsAdapterViewHolder(layout)
  }

  override fun onBindViewHolder(holder: ClubsAdapterViewHolder, position: Int) {
    holder.bind(dataset[position])
  }

  override fun getItemCount() = dataset.size
}