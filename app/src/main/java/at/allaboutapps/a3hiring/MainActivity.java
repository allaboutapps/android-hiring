package at.allaboutapps.a3hiring;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import at.allaboutapps.a3hiring.api.ApiHelper;
import at.allaboutapps.a3hiring.api.models.Club;
import at.allaboutapps.a3hiring.detail.DetailActivity;
import at.allaboutapps.a3hiring.list.ClubContract;
import at.allaboutapps.a3hiring.list.ClubsAdapter;
import at.allaboutapps.a3hiring.list.ClubsPresenter;
import at.allaboutapps.a3hiring.vh.MainActivityViewHolder;
import at.allaboutapps.recyclerview.decorations.A3SeparatorDecoration;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity implements ClubContract.View {

  private MainActivityViewHolder mViewHolder;

  private ClubsAdapter mAdapter;
  private ClubContract.Presenter mClubsPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mViewHolder = new MainActivityViewHolder(this);

    setSupportActionBar(mViewHolder.toolbar);
    initList();
    initPresenter();
  }

  private void initPresenter() {
    mClubsPresenter = new ClubsPresenter(this, ApiHelper.buildRetrofit());
    mClubsPresenter.loadListData();
  }

  private void initList() {
    mAdapter = new ClubsAdapter(this, mClubClickListener);
    mViewHolder.clubList.setLayoutManager(new LinearLayoutManager(this));
    mViewHolder.clubList.setAdapter(mAdapter);

    mViewHolder.clubList.addItemDecoration(new A3SeparatorDecoration(getResources(), ContextCompat.getColor(this, R.color.list_divider)));
  }

  private Function1<? super Club, Unit> mClubClickListener = new Function1<Club, Unit>() {
    @Override
    public Unit invoke(Club club) {
      startActivity(DetailActivity.Companion.newIntent(MainActivity.this, club));
      return null;
    }
  };

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    if (id == R.id.menuSort) {
      mClubsPresenter.toggleSort();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void showListData(@NotNull List<Club> clubList) {
    mViewHolder.progress.setVisibility(View.GONE);
    mAdapter.setDataset(clubList);
  }

  @Override
  public void showError(@NotNull Throwable error) {
    mViewHolder.progress.setVisibility(View.GONE);
    Snackbar.make(mViewHolder.vgMainLayout, error.getLocalizedMessage(), Snackbar.LENGTH_SHORT).show();
  }
}
