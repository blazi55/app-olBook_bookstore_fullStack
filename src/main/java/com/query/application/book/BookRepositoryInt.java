package com.query.application.book;

import java.util.List;

public interface BookRepositoryInt {

    List<Book> getBooksBySortPriceDesc();

    List<Book> getBooksAlphabet();
}
