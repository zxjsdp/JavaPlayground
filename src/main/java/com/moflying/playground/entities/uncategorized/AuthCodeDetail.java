package com.moflying.playground.entities.uncategorized;

import java.util.List;

public class AuthCodeDetail {
    private String authCode;
    private List<AuthRequest> authRequestList;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public List<AuthRequest> getAuthRequestList() {
        return authRequestList;
    }

    public void setAuthRequestList(List<AuthRequest> authRequestList) {
        this.authRequestList = authRequestList;
    }
}
