package com.main.FiscalIQ.common;

/**
 * This class represents response from APIs.
 */
public class Result {

    private boolean suc;

    private Object obj;

    private String msg;

    public static Result initInstance(){
        Result result = new Result();
        return result;
    }

    public void success(Object obj,String msg){
    }

    public void success(String msg){
    }

    public void fail(String msg){
    }

    public Result() {
    }

    public Result(boolean suc, Object obj, String msg) {
    }

    public Result(boolean suc, String msg) {
    }

    public boolean isSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
    }

    public void setMessage(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMessage'");
    }
}
