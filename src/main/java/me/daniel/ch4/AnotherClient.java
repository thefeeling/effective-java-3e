package me.daniel.ch4;

import me.daniel.ch4.book.BookService;

public class AnotherClient {

    public static void main(String[] args) {
        BookService svc = new BookService();
        System.out.println(svc.getBook());
        // default or package-privete 접근자는 외부 패키지에서 접근이 불가
        // System.out.println(svc.fetchData());
    }


}
