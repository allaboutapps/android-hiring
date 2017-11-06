package at.allaboutapps.a3hiring.list.vh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import at.allaboutapps.a3hiring.R;
import at.allaboutapps.a3hiring.api.models.Club;

/**
 * ViewHolderGenerator: version 0.24.0 (15.04.2016)
 * <p>
 * file last modified: 06.11.2017
 */
public class ClubsAdapterViewHolder extends RecyclerView.ViewHolder {

  // CHECKSTYLE:OFF
  public final ImageView ivClubImage;
  public final TextView tvClubName;
  public final TextView tvClubCountry;
  public final TextView tvClubValue;
  // CHECKSTYLE:ON

  public ClubsAdapterViewHolder(View root) {
    super(root);
    ivClubImage = root.findViewById(R.id.ivClubImage);
    tvClubName = root.findViewById(R.id.tvClubName);
    tvClubCountry = root.findViewById(R.id.tvClubCountry);
    tvClubValue = root.findViewById(R.id.tvClubValue);
  }

  public void bind(@NotNull Club club) {
    Context context = ivClubImage.getContext();

    if (TextUtils.isEmpty(club.getImage())) {
      Glide.with(context).load(R.drawable.club_placeholder).into(ivClubImage);
    } else {
      ivClubImage.setImageBitmap(null);
      Glide.with(context).load(club.getImage()).into(ivClubImage);
    }

    tvClubName.setText(club.getName());
    tvClubCountry.setText(club.getCountry());
    tvClubValue.setText(context.getString(R.string.club_value, club.getValue()));
  }
}