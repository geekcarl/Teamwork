package com.teamwork.common;

public class ResponseBean {
    private int code;
    private String errorMsg;
    private Object payload;

    public static ResponseBean instance(int code,String errorMsg,Object payload) {
        return new ResponseBean(code, errorMsg, payload);
    }

    public static ResponseBean OkInstance(Object payload) {
        return new ResponseBean(TWConstants.NORMAL_CODE, TWConstants.NORMAL_CODE_MSG, payload);
    }

    public static ResponseBean EInstance(Object payload) {
        return new ResponseBean(TWConstants.ERROR_CODE, TWConstants.ERROR_CODE_MSG,null);
    }
    public static ResponseBean loginErrorInstance(Object payload) {
        return new ResponseBean(TWConstants.LOGIN_ERROR, TWConstants.LOGIN_ERROR_MSG,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "code=" + code +
                ", errorMsg='" + errorMsg + '\'' +
                ", payload=" + payload +
                '}';
    }

    private ResponseBean(int code, String errorMsg, Object payload) {
        this.code = code;
        this.errorMsg = errorMsg;
        this.payload = payload;
    }
}
