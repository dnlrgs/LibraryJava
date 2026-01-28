package com.dnlrgs.library.controller;

import com.dnlrgs.library.model.Book;
import com.dnlrgs.library.view.LibraryView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LibraryController {
    private final String BOOKS_FILE_PATH = "./src/resources/data/books.txt";
    private static final String FILE_HEADER = "TITLE; AUTHOR; ID; BORROWED";

    public String getBOOKS_FILE_PATH() {
        return BOOKS_FILE_PATH;
    }

    private static List<Book> bookList = new ArrayList<>();

    public void startsApplication() throws IOException {
        doesFilesExists();
        new LibraryView().startMenu();
        bookList = readBookList(BOOKS_FILE_PATH);

    }

    public List<Book> readBookList(String filePath) {
        bookList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String bookLine;
            while ((bookLine = br.readLine()) != null) {
                if(!bookLine.equals(FILE_HEADER)) {
                    Book book = convertBookLineToObj(bookLine);
                    if (book != null) {
                        bookList.add(book);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    private static Book convertBookLineToObj(String bookLine) {
        String[] attribuits = bookLine.split(";");
        if (attribuits.length == 4) {
            try {
                String title = attribuits[0].trim();
                String author = attribuits[1].trim();
                int id = Integer.parseInt(attribuits[2].trim());
                boolean isBorrowed = Boolean.parseBoolean(attribuits[3].trim());
                return new Book(title, author, id, isBorrowed);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void addNewBook(String title, String author) throws IOException {
        Book newBook = new Book(title, author, createId());
        writeFile(newBook);
        bookList = readBookList(BOOKS_FILE_PATH);

    }

    public void doesFilesExists() throws IOException {
        Path path = Paths.get(BOOKS_FILE_PATH);

        if (!Files.exists(path)) {
            new File(BOOKS_FILE_PATH).createNewFile();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(BOOKS_FILE_PATH))) {
                bufferedWriter.write(FILE_HEADER);
                bufferedWriter.newLine();
            }
        }
        bookList = readBookList(BOOKS_FILE_PATH);
    }

    public void writeFile(Book newBook) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(BOOKS_FILE_PATH, true))) {
            bufferedWriter.write(String.format("%s; %s; %d; %b", newBook.getTitle(), newBook.getAuthor(), newBook.getId(), newBook.getIsBorrowed()));
            bufferedWriter.newLine();
        }
    }

/*    public void readFiles() throws RuntimeException, IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKS_FILE_PATH))) {


        }
    }*/

    public int createId() {
        System.out.println(bookList.stream()
                .mapToInt(Book::getId)
                .max()
                .orElse(0) + 1);
        return bookList.stream()
                .mapToInt(Book::getId)
                .max()
                .orElse(0) + 1;


    }


}
