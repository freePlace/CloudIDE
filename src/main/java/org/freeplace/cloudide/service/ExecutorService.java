package org.freeplace.cloudide.service;

import com.google.common.io.CharStreams;
import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.applicationinfo.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Service
public class ExecutorService {

    @Autowired
    private ProgrammingLanguageService programmingLanguageService;

    public static final String TMP_FOLDER_PATH = "c:\\Users\\Public\\";

    public String execute(String data, int languageId) {
        // tmp dummy data
        data = "public class X {	public static void main(String [] args) {		System.out.println(\"here we are!\");	}}";
        String fileName = FileUtils.createFileName(data, programmingLanguageService.findProgramingLanguageKeywordsByProgrammingLanguage(languageId));
        Process process = null;
        try {
            FileUtils.writeToFile(TMP_FOLDER_PATH + fileName + ".java", data);
            int compilationResult = ToolProvider.getSystemJavaCompiler().run(null, null, null, TMP_FOLDER_PATH + fileName + ".java");
            if(compilationResult != 0) throw new IllegalArgumentException("CompilationException");//TODO:create exception type!
            process = Runtime.getRuntime().exec(ApplicationData.EXEC_COMMAND + " " + TMP_FOLDER_PATH + " " + fileName);
            return CharStreams.toString(new InputStreamReader(process.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            throw new IllegalArgumentException("!!!"); // todo: create exception
        }
    }
}
