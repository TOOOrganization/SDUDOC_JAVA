package cn.edu.sdu.api;

public enum ResultCode implements IErrorCode {

    SUCCESS(200, "操作成功"),

    FAILED(500, "操作失败"),

    VALIDATE_FAILED(404, "参数检验失败"),

    UNAUTHORIZED(401, "暂未登录或token已经过期"),

    FORBIDDEN(403, "没有相关权限"),

    /**
     * 用户码
     */
    USERNAME_NOT_FOUND(10000, "用户名未找到"),

    USER_NOT_EXIST(10001, "用户不存在"),

    USER_AVATAR_UPLOAD_FAILURE(10002, "用户头像上传失败"),

    ROLE_NOT_EXIST(10003, "角色不存在"),

    ROLE_SAVE_FAILURE(10004, "角色存储失败"),

    PASSWORD_NOT_MATCH(10005, "密码错误"),

    LOGIN_SUCCESS(10006, "登录成功"),

    USER_ALREADY_EXIST(10007, "用户已存在"),

    PASSWORD_IS_NULL(10008, "密码为空"),

    PASSWORD_IS_NOT_EQUAL(10009, "两次密码不匹配"),

    PASSWORD_UPDATE_SUCCESS(10010, "密码更新成功"),

    /**
     * 网络请求码
     * */
    PICTURE_GET_FAILURE(20001, "服务器内部网络波动，图片请求失败");

    private long code;

    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
