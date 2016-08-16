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
import first.mvp.model.User;
import plyom.firstmvp.R;

/**
 * Created by ezequiel.garcia on 8/16/16.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    List<User> userList;
    public UserAdapter(){
        super();
        userList = new ArrayList<User>();
    }
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.surname.setText(user.getSurname());
        holder.gender.setText(user.getGender());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name) TextView name;
        @BindView(R.id.surname) TextView surname;
        @BindView(R.id.gender) TextView gender;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public void addData(User user) {
        userList.add(user);
        notifyDataSetChanged();
    }
}
