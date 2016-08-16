package first.mvp.service;

import first.mvp.model.Github;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface GithubService {
    @GET("users/{login}") Observable<Github> getUser(@Path("login") String login);
}
