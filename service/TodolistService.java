package service;


public interface TodolistService {
     void showTodoList();

     void addTodoList(String todo);

    void removeTodoList(Integer number);

     void changeTodoList(Integer number, String todo);

     void SearchTodoList(String keyword);

     void sortingTodoList(boolean ascending);
}
