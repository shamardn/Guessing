package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieList {

    private ArrayList <String> movies;


    public MovieList(String pathName) {
       movies = new ArrayList<>();
       File file = new File(pathName);

       try{
           Scanner scanner = new Scanner(file);
           while (scanner.hasNextLine()){
               movies.add(scanner.nextLine());
           }
       } catch (FileNotFoundException e) {
           System.out.println("file doesn't exist!");
       }
    }

    public String getRandomMovie(){
        int movieIndex = (int)Math.random() * movies.size();
        return movies.get(movieIndex);
    }
}
