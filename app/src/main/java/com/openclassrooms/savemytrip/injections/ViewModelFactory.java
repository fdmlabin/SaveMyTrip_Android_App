package com.openclassrooms.savemytrip.injections;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.openclassrooms.savemytrip.repositories.ItemDataRepository;
import com.openclassrooms.savemytrip.repositories.UserDataRepository;
import com.openclassrooms.savemytrip.todolist.ItemViewModel;

import java.util.concurrent.Executor;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final ItemDataRepository itemDataRepository;
    private final UserDataRepository userDataRepository;
    private final Executor executor;

    public ViewModelFactory(ItemDataRepository itemDataRepository,
                            UserDataRepository userDataRepository,
                            Executor executor) {
        this.itemDataRepository = itemDataRepository;
        this.userDataRepository = userDataRepository;
        this.executor = executor;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ItemViewModel.class)) {
            return (T) new ItemViewModel(itemDataRepository, userDataRepository, executor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
