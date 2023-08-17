package com.example.notepad.model;

public class Note {
    private int id;
    private String title;
    private String date;
    private String note;

    public Note() {
    }

    public Note(int id, String title, String date, String note) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.note = note;
    }

    public Note(String title, String date, String note) {
        this.title = title;
        this.date = date;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
