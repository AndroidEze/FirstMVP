package first.mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import first.mvp.data.Data;
import first.mvp.model.Github;
import first.mvp.service.GithubService;
import first.mvp.service.ServiceFactory;
import plyom.firstmvp.R;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_clear) Button buttonClear;
    @BindView(R.id.button_find) Button buttonFind;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
    }
    @OnClick(R.id.button_find)
    public void getGithubRepos(View v){
        GithubService service = ServiceFactory.createRetrofitService(GithubService.class);
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

                        }

                        @Override
                        public void onNext(Github github) {

                        }
                    });
        }
    }
}
