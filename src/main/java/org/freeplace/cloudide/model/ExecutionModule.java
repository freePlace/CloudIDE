package org.freeplace.cloudide.model;

/**
 * Created by Ruslan on 06.12.2015.
 */
public class ExecutionModule {
    private String executableCode;
    private String language;
    private int compilationResult;
    private String inputStreamResult;

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
}
