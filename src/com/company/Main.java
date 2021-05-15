package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(readInFile("germany", new File("src.txt")));
        writeInFile("bulgaria", new File("src.txt"));
    }

    public static void writeInFile(String name, File file) throws FileNotFoundException{
        ArrayList<String> lines = new ArrayList<>();
        lines.add(name);
        try(Scanner in = new Scanner(file)){
            while(in.hasNext()){
                lines.add(in.nextLine());
            }
        }
        Collections.sort(lines);

        try(PrintWriter out = new PrintWriter(file)){
            for (String line : lines) {
                out.println(line);
            }
        }
    }

    public static int readInFile(String line, File file) throws FileNotFoundException{
        int n = -1;

        if(file.exists()){
            Scanner in = new Scanner(file);
            int ctr = 0;
            while(in.hasNext()){
                if(in.nextLine().equals(line)){
                    n = ctr;
                    break;
                }
                ++ctr;
            }
        }
        return n;
    }
}
