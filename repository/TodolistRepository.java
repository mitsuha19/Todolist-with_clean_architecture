package repository;

import java.util.ArrayList;

import entity.Todolist;

public interface TodolistRepository {
    ArrayList<Todolist> getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);

    boolean change(Integer number, Todolist todolist);

    void search(String keyword);

    void sorting(boolean ascending);

}
