package com.github.antoniocsilva.enums;

public enum Level {
    ERROR("error"),
    WARNING("warning"),
    INFO("info");

    private String type;

    Level(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
}
