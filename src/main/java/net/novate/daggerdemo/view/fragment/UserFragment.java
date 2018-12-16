package net.novate.daggerdemo.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.novate.daggerdemo.R;
import net.novate.daggerdemo.databinding.UserFragmentBinding;
import net.novate.daggerdemo.model.User;
import net.novate.daggerdemo.view.adapter.UserListAdapter;
import net.novate.daggerdemo.viewmodel.UserViewModel;
import net.novate.daggerdemo.viewmodel.ViewModelFactory;

import java.util.Arrays;

import javax.inject.Inject;


public class UserFragment extends Fragment {

    private static final String TAG = "UserFragment";

    private UserFragmentBinding binding;
    private UserViewModel viewModel;
    private UserListAdapter adapter;

    @Inject
    public ViewModelProvider.Factory factory;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity(), factory).get(UserViewModel.class);

        viewModel.observeAll().observe(this, new Observer<User[]>() {
            @Override
            public void onChanged(@Nullable User[] users) {
                Log.d(TAG, "onChanged() called with: users = [" + Arrays.toString(users) + "]");
                if (users != null) {
                    adapter.setUsers(users);
                }
            }
        });


        adapter = new UserListAdapter();
        binding.users.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.users.setAdapter(adapter);
    }
}
