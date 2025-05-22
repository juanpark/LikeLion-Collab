
package com.workshop.vo;

public class AuditLog {
    private String message;

    public AuditLog(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
