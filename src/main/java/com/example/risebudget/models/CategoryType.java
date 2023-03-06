package com.example.risebudget.models;

public enum CategoryType {

    GROCERIES("GROCERIES"),
    UTILITIES("UTILITIES"),
    RENT("RENT"),
    MORTGAGE("MORTGAGE"),
    SUBSCRIPTIONS("SUBSCRIPTIONS"),
    ENTERTAINMENT("ENTERTAINMENT"),
    TRANSPORT("TRANSPORT"),
    EATING_OUT("EATING_OUT"),
    HEALTH("HEALTH"),
    GENERAL("GENERAL");

    private String value;

    CategoryType(String value) {
        this.value = value;
    }
    public String getString(){
        return this.value;
    }
}
