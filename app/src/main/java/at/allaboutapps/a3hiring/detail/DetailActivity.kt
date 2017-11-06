package at.allaboutapps.a3hiring.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.TextUtils
import android.view.MenuItem
import at.allaboutapps.a3hiring.R
import at.allaboutapps.a3hiring.api.models.Club
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

  companion object {
    fun newIntent(context: Context, club: Club): Intent {
      val intent = Intent(context, DetailActivity::class.java)
      intent.putExtra("club", club)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    val club = intent.getParcelableExtra<Club>("club")
    title = club.name

    tvClubCountry.text = club.country

    val clubDescription = getString(R.string.club_description, club.name, club.country, club.value)
    tvClubDescription.text = Html.fromHtml(clubDescription)

    val imageUrl: Any = if (TextUtils.isEmpty(club.image)) {
      R.drawable.club_placeholder
    } else {
      club.image ?: R.drawable.club_placeholder
    }
    Glide.with(this).load(imageUrl).into(ivClubImage)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == android.R.id.home) {
      finish()
      return true
    }
    return super.onOptionsItemSelected(item)
  }
}