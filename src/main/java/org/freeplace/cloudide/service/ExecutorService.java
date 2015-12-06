package org.freeplace.cloudide.service;

import com.google.common.io.CharStreams;
import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.controller.webservice.ProgrammingLanguageWebService;
import org.freeplace.cloudide.controller.webservice.model.ExecutionModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void execute(ExecutionModule executionModule) {
        // tmp dummy data
        String fileName = FileUtils.createFileName(executionModule.getExecutableCode(), programmingLanguageService.findProgramingLanguageKeywordsByProgrammingLanguage(1));
        Process process = null;
        String result = null;
        try {
            FileUtils.writeToFile(TMP_FOLDER_PATH + fileName + ".java", executionModule.getExecutableCode());
            int compilationResult = ToolProvider.getSystemJavaCompiler().run(null, null, null, TMP_FOLDER_PATH + fileName + ".java");
            executionModule.setCompilationResult(compilationResult);
            process = Runtime.getRuntime().exec(ApplicationData.EXEC_COMMAND + " " + TMP_FOLDER_PATH + " " + fileName);
            result = CharStreams.toString(new InputStreamReader(process.getInputStream()));
            executionModule.setInputStreamResult(result);
        } catch (IOException e) {
            throw new IllegalArgumentException("!!!"); // todo: create exception
        }
    }
}
