package service;

import java.util.ArrayList;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {
    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodoList() {
        ArrayList<Todolist> model = todolistRepository.getAll();

        System.out.println("To-Do List :");
        if (model.size() > 0) {
            for (var i = 0; i < model.size(); i++) {
              var todolist = model.get(i);
              var no = i + 1;

              if (todolist != null) {
                  System.out.println(no + ". " + todolist.getTodo());
              }
            }
        } else {
            System.out.println("Belum ada todo tersedia");
        }

        System.out.println();
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);

        if (todo.length() < 6 ) {
            System.out.println("GAGAL MENAMBAH TODO : " + todo + ". Panjang karakter minimal 6.");
        } else {
            todolistRepository.add(todolist);
            System.out.println("SUKSES MENAMBAH TODO : " + todolist.getTodo());
        }
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success) {
            System.out.println("SUKSES MENGHAPUS TODO : posisi ke-" + number);
        } else {
            System.out.println("GAGAL MENGHAPUS TODO : " + number);
        }
    }

    @Override
    public void changeTodoList(Integer number, String todo) {
        Todolist todolist = new Todolist(todo);
        boolean success = todolistRepository.change(number, todolist);
        if (success) {
            System.out.println("SUKSES MENGUBAH TODO : posisi ke-" + number + " menjadi " + todolist.getTodo());
        } else if(!success && todo.length() < 6) {
            System.out.println("GAGAL MENGUBAH TODO : posisi ke-" + number + " menjadi " + todolist.getTodo() + ". Panjang karakter minimal 6.");
        } else {
            System.out.println("GAGAL MENGUBAH TODO : posisi ke-" + number + " menjadi " + todolist.getTodo() + ". Todo tidak tersedia.");
        }
    }

    @Override
    public void SearchTodoList(String keyword) {
        todolistRepository.search(keyword);
    }

    @Override
    public void sortingTodoList(boolean ascending) {
        todolistRepository.sorting(ascending);
    }
}
