package cn.edu.sdu.api;

public interface IErrorCode {
    /**
     * 用户错误码
     */
    long CODE_USERNAME_NOT_FOUND = 10000L;

    long CODE_USER_NOT_EXIST = 10001L;

    long CODE_USER_AVATAR_UPLOAD_FAILURE = 10002L;

    /**
     * 用户错误信息
     * */
    String MESSAGE_USERNAME_NOT_FOUND = "用户名未找到";

    String MESSAGE_USER_NOT_EXIST = "用户不存在";

    String MESSAGE_USER_AVATAR_UPLOAD_FAILURE = "用户头像上传失败";

    long getCode();

    String getMessage();
}
