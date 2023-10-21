package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository {

    public ArrayList<Todolist> data = new ArrayList<Todolist>();

    @Override
    public ArrayList<Todolist> getAll() {
        return data;
    }

    @Override
    public void add(Todolist todolist) {
        data.add(todolist);
    }

    @Override
    public boolean remove(Integer number) {
        if (data.size() <= 0 || number > data.size())
            return false;

        Todolist todolist = data.get(number - 1);
        if (todolist != null) {
            data.remove(todolist);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean change(Integer number, Todolist todolist) {
        if (data.size() <= 0 || number > data.size()) {
            return false;
        } else if(todolist.getTodo().length() < 6) {
            return false;
        } else {
            data.set(number - 1, todolist);
            return true;
        }
    }

    @Override
    public void search(String keyword) {
        ArrayList<Todolist> save = new ArrayList<>();
        for (Todolist todolist : data) {
            if (String.valueOf(todolist.getTodo()).contains(keyword)) {
                save.add(todolist);
            }
        }

        System.out.println("Ditemukan " + save.size() + " todo untuk hasil pencarian " + keyword );
        for (Todolist todolist : data) {
            if (String.valueOf(todolist.getTodo()).contains(keyword)) {
                System.out.println(data.indexOf(todolist) + 1 + ". " + todolist.getTodo());
            }
        }

        System.out.println();
    }

    @Override
    public void sorting(boolean ascending) {
        Comparator<Todolist> comparator = Comparator.comparing(Todolist::getTodo);
        if (!ascending) {
            comparator = comparator.reversed();
        }

        Collections.sort(data,comparator);

    }
}
