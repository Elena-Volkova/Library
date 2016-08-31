package com.example.application.client.controller.admin;

public enum AdminMessage {

    LIBRARY_ADDED("Библиотека успешно добавлена!"),
    LIBRARY_UPDATED("Библиотека успешно обновлена!"),
    LIBRARY_DELETED("Библиотека успешно удалена!"),
    USER_ADDED("Пользователь успешно добавлен!"),
    USER_UPDATED("Пользователь успешно обновлен!"),
    USER_DELETED("Пользователь успешно удален!");

    AdminMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
