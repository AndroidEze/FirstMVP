package first.mvp.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import first.mvp.view.GithubMVPView;
import plyom.firstmvp.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_clear) Button buttonClear;
    @BindView(R.id.button_find) Button buttonFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
    }
}
