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
class ClubsAdapter(private val context: Context, private val listener: (Club) -> Unit) : RecyclerView.Adapter<ClubsAdapterViewHolder>() {

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
    val item = dataset[position]
    holder.bind(item)
    holder.vgClub.setOnClickListener {
      listener(item)
    }
  }

  override fun getItemCount() = dataset.size
}