package view;

import service.TodolistService;
import util.InputUtil;


public class TodolistView {

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodoList() {
        while (true) {
            todolistService.showTodoList();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Ubah");
            System.out.println("4. Cari");
            System.out.println("5. Urutkan");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");
            System.out.println();
            var stop = false;
            switch (input) {
                case "1" -> addTodoList();
                case "2" -> removeTodoList();
                case "3" -> changeTodoList();
                case "4" -> searchTodoList();
                case "5" -> sortingTodoList();
                case "x" -> stop = true;
                default -> System.out.println("Pilihan tidak dimengerti");
            }

            if (stop) {
                break;
            }

            System.out.println();
        }
    }

    public void addTodoList() {
        System.out.println("Menambah To-Do List");

        var todo = InputUtil.input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            // batal
        } else {
            todolistService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("Menghapus To-Do List");

        var number = InputUtil.input("Nomor yang dihapus (x Jika Batal)");

        if (number.equals("x")) {
            // batal
        } else {
            todolistService.removeTodoList(Integer.valueOf(number));
        }
    }

    public void changeTodoList() {
        System.out.println("Mengubah To-Do List");

        var number = InputUtil.input("Nomor yang diubah (x Jika Batal)");

        if (number.equals("x")) {
            // batal
        } else {
            var string = InputUtil.input("Todo Baru");
            todolistService.changeTodoList(Integer.valueOf(number), String.valueOf(string));
        }
    }

    public void searchTodoList() {

        System.out.println("Mencari To-Do List");
        var string = InputUtil.input(" Todo yang dicari? (x Jika Batal)");
        if (string.equals("x")) {
            // batal
        } else {
            todolistService.SearchTodoList(String.valueOf(string));
        }
    }

    public void sortingTodoList() {
        System.out.println("Mengurutkan To-Do List");
        System.out.println("Urutkan data berdasarkan?");
        var string = InputUtil.input("(a Secara ascending, d Secara descending, x Jika Batal)");

        if (string.equals("a")) {
            System.out.println("Mengurutkan todolist secara ascending.");
            todolistService.sortingTodoList(true);
        } else if (string.equals("d")) {
            System.out.println("Mengurutkan todolist secara descending.");
            todolistService.sortingTodoList(false);
        } else  if (string.equals("x")){
            // batal
        } else {
            System.out.println("Pilihan tidak dimengerti");
        }
    }

}
