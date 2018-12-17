package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();


    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        List<User> fakeUsers = new ArrayList<>();
        fakeUsers.add(new User("Ivanov", 1 , 1));
        fakeUsers.add(new User("Petrov", 2 , 1));
        fakeUsers.add(new User("Sidorov", 3 , 2));

        modelData.setUsers(fakeUsers);

    }

    @Override
    public void loadDeletedUsers() {
       throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();

    }
}
