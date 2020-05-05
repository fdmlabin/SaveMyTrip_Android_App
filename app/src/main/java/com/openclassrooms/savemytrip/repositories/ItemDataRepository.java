package com.openclassrooms.savemytrip.repositories;

import android.arch.lifecycle.LiveData;

import com.openclassrooms.savemytrip.database.dao.ItemDao;
import com.openclassrooms.savemytrip.models.Item;
import com.openclassrooms.savemytrip.models.User;

import java.util.List;

public class ItemDataRepository {

    private final ItemDao itemDao;

    public ItemDataRepository(ItemDao itemDao) { this.itemDao = itemDao; }

    // --- GET ITEMs ---
    public LiveData<List<Item>> getItems(long userId) { return this.itemDao.getItems(userId); }

    // --- CREATE ITEM ---
    public void createItem(Item item) { this.itemDao.insertItem(item); }

    // --- DELETE ---
    public void deleteItem(long itemId) { this.itemDao.deleteItem(itemId); }

    // --- UPDATE ITEM ---
    public void updateItem(Item item) { this.itemDao.updateItem(item); }
}
