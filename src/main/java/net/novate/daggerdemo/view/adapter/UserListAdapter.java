package net.novate.daggerdemo.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.novate.daggerdemo.R;
import net.novate.daggerdemo.databinding.UserItemBinding;
import net.novate.daggerdemo.model.User;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private User[] users = new User[]{};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_user, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.binding.setUser(users[i]);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public void setUsers(User[] users) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return UserListAdapter.this.users.length;
            }

            @Override
            public int getNewListSize() {
                return users.length;
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return UserListAdapter.this.users[oldItemPosition].getId() == users[newItemPosition].getId();
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return UserListAdapter.this.users[oldItemPosition].getName().equals(users[newItemPosition].getName())
                        && UserListAdapter.this.users[oldItemPosition].getPhone().equals(users[newItemPosition].getPhone());
            }
        });
        this.users = users;
        diffResult.dispatchUpdatesTo(this);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        UserItemBinding binding;

        ViewHolder(@NonNull UserItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
