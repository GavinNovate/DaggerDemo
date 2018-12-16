package net.novate.daggerdemo.view.event;

import android.support.annotation.Nullable;

import net.novate.daggerdemo.model.User;

public interface InsertFragmentEvent {
    void onInsertClick(@Nullable User user);
}
