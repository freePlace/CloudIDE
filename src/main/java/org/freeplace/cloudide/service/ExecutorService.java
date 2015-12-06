package org.freeplace.cloudide.service;

import com.google.common.io.CharStreams;
import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.controller.webservice.model.ExecutionModule;
import org.springframework.stereotype.Service;

import javax.tools.ToolProvider;
import java.io.*;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Service
public class ExecutorService {

    public static final String TMP_FOLDER_PATH = "c:\\Users\\Public\\";

    public void execute(ExecutionModule executionModule) {
        try {
            String fileName = FileUtils.createFileName(executionModule.getExecutableCode());
            FileUtils.writeToFile(TMP_FOLDER_PATH + fileName + ".java", executionModule.getExecutableCode());
            int compilationResult = ToolProvider.getSystemJavaCompiler().run(null, null, null, TMP_FOLDER_PATH + fileName + ".java");
            executionModule.setCompilationResult(compilationResult);
            Process process = Runtime.getRuntime().exec(ApplicationData.EXEC_COMMAND + " " + TMP_FOLDER_PATH + " " + fileName);
            String inputStreamResult = CharStreams.toString(new InputStreamReader(process.getInputStream()));
            executionModule.setInputStreamResult(inputStreamResult);
            String errorStream = CharStreams.toString(new InputStreamReader(process.getErrorStream()));
            executionModule.setErrorStreamResult(errorStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("!!!"); // todo: create exception
        }
    }
}
