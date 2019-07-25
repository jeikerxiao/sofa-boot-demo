package com.jeiker.api.model;

/**
 * Description: sofa-boot-demo
 * User: jeikerxiao
 * Date: 2019/7/25 4:15 PM
 */
public class ResultModel {

    private String name;
    private String value;

    public ResultModel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
