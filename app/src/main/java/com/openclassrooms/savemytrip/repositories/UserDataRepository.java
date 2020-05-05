package com.openclassrooms.savemytrip.repositories;

import android.arch.lifecycle.LiveData;

import com.openclassrooms.savemytrip.database.dao.UserDao;
import com.openclassrooms.savemytrip.models.User;

public class UserDataRepository {

    private final UserDao userDao;

    public UserDataRepository(UserDao userDao) { this.userDao = userDao; }

    // --- CREATE USER ---
    public void createUser(User user) { this.userDao.createUser(user); }

    // --- GET USER ---
    public LiveData<User> getUser(long userId) { return this.userDao.getUser(userId); }
}
