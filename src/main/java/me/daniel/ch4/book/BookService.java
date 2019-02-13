package me.daniel.ch4.book;

import java.util.Collections;
import java.util.List;

public class BookService {

    Book fetchData() {
        Book book = new Book();
        book.setId("1");
        book.setTitle("이펙티브자바");
        book.setSummary("이펙티브 자바 요약하기");
        return book;
    }

    public List<Book> getBook() {
        return Collections.singletonList(fetchData());
    }

}
