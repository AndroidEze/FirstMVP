package first.mvp.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import first.mvp.view.GithubMVPView;
import plyom.firstmvp.R;

public class MainActivity extends AppCompatActivity implements GithubMVPView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public Context getContext() {
        return getContext();
    }
}
