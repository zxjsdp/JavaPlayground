package com.moflying.playground.entities.uncategorized;

import java.util.List;

public class AuthRequest {
    private String requestName;
    private List<AuthParam> authParamList;

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public List<AuthParam> getAuthParamList() {
        return authParamList;
    }

    public void setAuthParamList(List<AuthParam> authParamList) {
        this.authParamList = authParamList;
    }
}
