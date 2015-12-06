package org.freeplace.cloudide.service;

import org.freeplace.cloudide.model.ProgrammingLanguageKeyword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Ruslan on 05.12.2015.
 */
public class FileUtils {

    public static void writeToFile(String path, String data) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
            writer.write(data);
        }
    }

    public static String readFromFile(String path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            return reader.lines().collect(Collectors.joining());
        }
    }

    // todo: change to more general form
    public static String createFileName(String data) {
        Scanner scanner = new Scanner(data);
        while(scanner.hasNext()) {
            if(scanner.hasNext("class")) {
                scanner.next();
                if(scanner.hasNext()) {
                    String tmpClassName = scanner.next();
                    if(scanner.hasNext() && scanner.next().equals("{")) {
                        return tmpClassName;
                    }
                }
            } else {
                scanner.next();
            }
        }
        scanner.close();
        return null;
    }
}
