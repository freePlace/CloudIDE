package org.freeplace.cloudide.controller.webservice.model;

/**
 * Created by Ruslan on 06.12.2015.
 */
/**
 * Created by Ruslan on 06.12.2015.
 */
public class ExecutionModule {
    private String executableCode;
    private String language;
    private int compilationResult;
    private String inputStreamResult;
    private String errorStreamResult;

    public String getExecutableCode() {
        return executableCode;
    }

    public void setExecutableCode(String executableCode) {
        this.executableCode = executableCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCompilationResult() {
        return compilationResult;
    }

    public void setCompilationResult(int compilationResult) {
        this.compilationResult = compilationResult;
    }

    public String getInputStreamResult() {
        return inputStreamResult;
    }

    public void setInputStreamResult(String inputStreamResult) {
        this.inputStreamResult = inputStreamResult;
    }

    public String getErrorStreamResult() {
        return errorStreamResult;
    }

    public void setErrorStreamResult(String errorStreamResult) {
        this.errorStreamResult = errorStreamResult;
    }
}