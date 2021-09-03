package cn.zfy.security;

import java.io.Serializable;

public class ResultModel<T> implements Serializable {
    //标识码
    private Integer code;
    //数据
    private T data;
    //成功状态
    private boolean isSuccess;
    //返回信息
    private String message;

    public ResultModel() {
    }

    public ResultModel(cn.zfy.security.ResultEnum resultEnum) {
        if (resultEnum.getCode().equals(cn.zfy.security.ResultEnum.SUCCESS.getCode())) {
            isSuccess = true;
        } else {
            isSuccess = false;
        }
        code = resultEnum.getCode();
        message = resultEnum.getMessage();
    }

    public ResultModel(cn.zfy.security.ResultEnum resultEnum, String detail) {
        if (resultEnum.getCode().equals(cn.zfy.security.ResultEnum.SUCCESS.getCode())) {
            isSuccess = true;
        } else {
            isSuccess = false;
        }
        code = resultEnum.getCode();
        message = resultEnum.getMessage() + " : " + detail;
    }

    public ResultModel(T t) {
        this.code = cn.zfy.security.ResultEnum.SUCCESS.getCode();
        this.message = cn.zfy.security.ResultEnum.SUCCESS.getMessage();
        this.data = t;
    }

    public ResultModel(String messages) {
        code = cn.zfy.security.ResultEnum.FAIL.getCode();
        message = messages;
    }

    /**
     * 参数缺失
     *
     * @return
     */
    public static <T> cn.zfy.security.ResultModel<T> checkParamFail() {
        return new cn.zfy.security.ResultModel<>(cn.zfy.security.ResultEnum.NO_PARAM);
    }

    /**
     * 参数缺失
     *
     * @return
     */
    public static <T> cn.zfy.security.ResultModel<T> checkParamFail(String detail) {
        return new cn.zfy.security.ResultModel<>(cn.zfy.security.ResultEnum.NO_PARAM, detail);
    }

    /**
     * 操作失败
     *
     * @return
     */
    public static cn.zfy.security.ResultModel error() {
        return new cn.zfy.security.ResultModel(cn.zfy.security.ResultEnum.ERROR);
    }

    /**
     * 自定义异常消息
     */
    public static cn.zfy.security.ResultModel fail(String message) {
        return new cn.zfy.security.ResultModel(message);
    }

    /**
     * 账号过期
     *
     * @return
     */
    public static cn.zfy.security.ResultModel account() {
        return new cn.zfy.security.ResultModel(cn.zfy.security.ResultEnum.ACCOUNT);
    }

    static cn.zfy.security.ResultModel account(String message) {
        cn.zfy.security.ResultModel resultModel = new cn.zfy.security.ResultModel();
        resultModel.setCode(cn.zfy.security.ResultEnum.ACCOUNT.getCode());
        resultModel.setMessage(message);
        return resultModel;
    }

    /**
     * 操作失败 默认201
     *
     * @return
     */
    public static cn.zfy.security.ResultModel fail() {
        return new cn.zfy.security.ResultModel(cn.zfy.security.ResultEnum.FAIL);
    }

    public static cn.zfy.security.ResultModel faultTolerant() {
        return new cn.zfy.security.ResultModel(cn.zfy.security.ResultEnum.FAULT_TOLERANT);
    }

    /**
     * 无数据
     */
    public static cn.zfy.security.ResultModel noData() {
        return new cn.zfy.security.ResultModel(cn.zfy.security.ResultEnum.NO_DATA);
    }

    /**
     * 操作成功带参数
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> cn.zfy.security.ResultModel success(T t) {
        return new cn.zfy.security.ResultModel(t);
    }

    /**
     * 操作成功不带参数
     *
     * @return
     */
    public static cn.zfy.security.ResultModel success() {
        return new cn.zfy.security.ResultModel(cn.zfy.security.ResultEnum.SUCCESS);
    }

    

    /**
     * 操作失败
     *
     * @return
     */
    public static cn.zfy.security.ResultModel fail(cn.zfy.security.ResultEnum resultEnum, String errorDetail) {
        return new cn.zfy.security.ResultModel(resultEnum, errorDetail);
    }
    
    public static cn.zfy.security.ResultModel bool(boolean result) {
    	if(result) {
    		return new cn.zfy.security.ResultModel(cn.zfy.security.ResultEnum.SUCCESS);
    	}else {
    		return new cn.zfy.security.ResultModel(cn.zfy.security.ResultEnum.FAIL);
    	}
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        if (code == null) {
            return false;
        }
        if (code.equals(cn.zfy.security.ResultEnum.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setT(T t) {
        this.data = t;
    }
}