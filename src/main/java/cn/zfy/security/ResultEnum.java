package cn.zfy.security;

public enum ResultEnum {
	/**
    *
    */
   SUCCESS(200, "成功"),
   /**
    *
    */
   ERROR(500, "网络错误，请稍后重试"),
   /**
    *
    */
   SYS_ERROR(505, "系统错误"),
   /**
    *
    */
   FAULT_TOLERANT(501, "网络链接失败，请稍后重试"),
   /**
    *
    */
   FAIL(201, "操作失败，请稍后重试"),
   /**
    *
    */
   NO_LOGIN(401, "未登陆"),
   LOGIN_OUT(402, "登陆过期"),
   
   /**
    *
    */
   NO_PARAM(202, "参数缺失"),
   /**
    *
    */
   PARAM_CHECK(203, "参数校验失败"),
   /**
    *
    */
   NO_DATA(204, "无数据"),
   /**
    *
    */
   FILE_MAX(206, "文件过大"),
   /**
    *
    */
   NO_FILE(207, "文件为空"),
   
   FREQUENTLY(209, "频繁请求"),

   ACCOUNT(211, "账号过期"),
   
   NO_TOURIST(213, "未授权，无法操作"),
   ;

   private Integer code;
   private String message;

   ResultEnum(Integer code, String message) {
       this.code = code;
       this.message = message;
   }

   /**
    * @return
    */
   public String getMessage() {
       return message;
   }

   public void setMessage(String message) {
       this.message = message;
   }

   /**
    * @return
    */
   public Integer getCode() {
       return code;
   }

   public void setCode(Integer code) {
       this.code = code;
   }
}