package me.daniel.ch4.book;

import me.daniel.ch4.book.BookService;

public class Client {
    public static void main(String[] args) {
        BookService svc = new BookService();
        System.out.println(svc.getBook());
        System.out.println(svc.fetchData());
    }


}
