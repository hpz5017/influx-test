/**
 * 
 */
package edu.pitt.medschool.framework.rest;

/**
 * @author Isolachine
 *
 */
public class RestfulResponse {
    private Integer code;
    private String msg;
    private Object data;
    
    public RestfulResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
    
}
