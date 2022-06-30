package cl.mobdev.trainee.rickandmorty.models;

import java.util.Date;

public class ErrorDto {

    private int code;
    private String message;
    private String error;

    private Date date;

    public ErrorDto(int code, String message, String error, Date date) {
        this.code = code;
        this.message = message;
        this.error = error;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}
