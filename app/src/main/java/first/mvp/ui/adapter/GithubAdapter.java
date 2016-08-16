package first.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import first.mvp.model.Github;
import plyom.firstmvp.R;

/**
 * Created by ezequiel.garcia on 8/16/16.
 */

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder>{
    List<Github> githubList;
    public GithubAdapter(){
        super();
        githubList = new ArrayList<Github>();
    }
    @Override
    public GithubAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GithubAdapter.ViewHolder holder, int position) {
        Github github = githubList.get(position);
        holder.login.setText(github.getLogin());
        holder.repos.setText(github.getPublicRepos());
        holder.blog.setText(github.getBlog());
    }

    @Override
    public int getItemCount() {
        return githubList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.login) TextView login;
        @BindView(R.id.repos) TextView repos;
        @BindView(R.id.blog) TextView blog;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public void addData(Github github) {
        githubList.add(github);
        notifyDataSetChanged();
    }
}
