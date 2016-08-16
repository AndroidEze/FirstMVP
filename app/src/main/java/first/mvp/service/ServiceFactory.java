package first.mvp.service;

import retrofit2.Retrofit;

public class ServiceFactory {
    public static final String GITHUB_ENDPOINT = "https://api.github.com";
    public static <T> T createRetrofitService(final Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GITHUB_ENDPOINT)
                .build();
        T service = retrofit.create(clazz);

        return service;
    }
}
