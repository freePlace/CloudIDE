package org.freeplace.cloudide.controller.webservice.model;

/**
 * Created by Ruslan on 06.12.2015.
 */
public class ValidationModule {
    private String code;
    private int cursorPosition;
    private boolean isKeyword;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(int cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public boolean isKeyword() {
        return isKeyword;
    }

    public void setIsKeyword(boolean isKeyword) {
        this.isKeyword = isKeyword;
    }
}
