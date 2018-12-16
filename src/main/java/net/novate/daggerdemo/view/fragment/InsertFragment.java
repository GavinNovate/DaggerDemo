package net.novate.daggerdemo.view.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.novate.daggerdemo.R;
import net.novate.daggerdemo.databinding.InsertFragmentBinding;
import net.novate.daggerdemo.model.User;
import net.novate.daggerdemo.view.event.InsertFragmentEvent;
import net.novate.daggerdemo.viewmodel.UserViewModel;
import net.novate.daggerdemo.viewmodel.ViewModelFactory;

import java.util.Objects;

import javax.inject.Inject;

public class InsertFragment extends Fragment implements InsertFragmentEvent {

    private InsertFragmentBinding binding;
    private UserViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory factory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_insert, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity()), factory).get(UserViewModel.class);
        binding.setUser(new User());
        binding.setEvent(this);
    }

    private static final String TAG = "InsertFragment";

    @Override
    public void onInsertClick(@Nullable User user) {
        Log.d(TAG, "onInsertClick() called with: user = [" + user + "]");
        if (user != null) {
            viewModel.insert(user);
            binding.setUser(new User());
        }
    }
}
