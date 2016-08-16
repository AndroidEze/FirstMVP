package first.mvp.service;

import first.mvp.model.User;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface UserService {
    @GET("api/") Observable<User> getUser(@Query("amount") long amount);
}
