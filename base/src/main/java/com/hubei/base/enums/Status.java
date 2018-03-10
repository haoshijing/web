package com.hubei.base.enums;

public enum  Status {

    OK(1,"状态正常"),CLOSED(2,"已禁止");

     Status(Integer c,String mark){
        this.code =c;
        this.mark = mark;
    }
    @lombok.Getter
    private Integer code;
    @lombok.Getter
    private String mark;
}
