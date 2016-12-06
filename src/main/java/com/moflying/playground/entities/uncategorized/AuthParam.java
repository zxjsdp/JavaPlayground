package com.moflying.playground.entities.uncategorized;

import java.util.List;

public class AuthParam {
    private String paramType;
    private List<String> paramList;

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public List<String> getParamList() {
        return paramList;
    }

    public void setParamList(List<String> paramList) {
        this.paramList = paramList;
    }
}
