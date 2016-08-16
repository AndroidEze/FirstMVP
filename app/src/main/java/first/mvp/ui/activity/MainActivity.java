package first.mvp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import first.mvp.data.Data;
import first.mvp.model.Github;
import first.mvp.model.User;
import first.mvp.service.GithubService;
import first.mvp.service.ServiceFactory;
import first.mvp.service.UserService;
import first.mvp.ui.adapter.GithubAdapter;
import first.mvp.ui.adapter.UserAdapter;
import plyom.firstmvp.R;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private GithubAdapter githubAdapter;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = ButterKnife.findById(this, R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        githubAdapter = new GithubAdapter();
        recyclerView.setAdapter(githubAdapter);

        RecyclerView recyclerViewUser = ButterKnife.findById(this, R.id.recycler_view_user);
        recyclerViewUser.setHasFixedSize(true);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);
    }
    @OnClick(R.id.button_find)
    public void getGithubRepos(View v){
        GithubService service = ServiceFactory.createRetrofitService(GithubService.class, ServiceFactory.GITHUB_ENDPOINT);
        for (String login : Data.githubList) {
            service.getUser(login)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Github>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("GithubDemo", e.getMessage());
                        }

                        @Override
                        public void onNext(Github github) {
                            githubAdapter.addData(github);
                        }
                    });
        }
    }
    @OnClick(R.id.button_clear)
    public void getUserData(View v){
        UserService service = ServiceFactory.createRetrofitService(UserService.class, ServiceFactory.USER_ENDPOINT);
            service.getUser(1)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<User>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("Users", e.getMessage());
                        }

                        @Override
                        public void onNext(User user) {
                            userAdapter.addData(user);
                        }
                    });
    }
}
