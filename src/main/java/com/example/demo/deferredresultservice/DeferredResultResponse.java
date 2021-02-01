package com.example.demo.deferredresultservice;

import lombok.Data;
import lombok.Getter;

/**
 * @author lidongliang
 * create at: 2021/1/14  5:19 下午
 */
@Data
public class DeferredResultResponse {

    private Integer code;
    private String msg;

    public enum Msg {
        TIMEOUT("超时"),
        FAILED("失败"),
        SUCCESS("成功");

        @Getter
        private String desc;

        Msg(String desc) {
            this.desc = desc;
        }
    }

}
