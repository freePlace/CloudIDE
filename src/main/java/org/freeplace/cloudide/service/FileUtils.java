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

    public static String createFileName(String data, List<ProgrammingLanguageKeyword> keywords) {
        Scanner sc = new Scanner(data);
        List<String> keywordNames = keywords.stream().map(keyword -> keyword.getName()).collect(Collectors.toList());
        while(sc.hasNext()) {
            String current  = sc.next();
            if(!keywordNames.contains(current)) return current;
        }
        return null;
    }
}
