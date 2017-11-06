package at.allaboutapps.a3hiring.api;

import java.util.List;

import at.allaboutapps.a3hiring.api.models.Club;
import io.reactivex.Flowable;
import retrofit2.http.GET;
/**
 *
 */

public interface ApiService {

  @GET ("clubs.json?alt=media&token=0c7aeedb-9651-4976-9ee8-e0a3c566d8c3")
  Flowable<List<Club>> getClubs();
}
