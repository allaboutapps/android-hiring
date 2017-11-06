package at.allaboutapps.a3hiring.api;

import java.util.List;

import at.allaboutapps.a3hiring.api.models.Club;
import io.reactivex.Flowable;
import retrofit2.http.GET;
/**
 *
 */

public interface ApiService {

  @GET ("clubs.json?alt=media&token=118520e4-b25b-40be-bb1e-a2784f656efc")
  Flowable<List<Club>> getClubs();
}
