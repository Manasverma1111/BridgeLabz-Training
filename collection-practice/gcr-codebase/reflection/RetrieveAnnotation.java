package reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Author(name = "J.K. Rowling")
class Book {
}

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

public class RetrieveAnnotation {

    public static void main(String[] args) {

        Class<Book> cls = Book.class;

        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        }
    }
}

