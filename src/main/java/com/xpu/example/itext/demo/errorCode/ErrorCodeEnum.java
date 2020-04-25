/**
 * @(#)ErrorEnum.java, 2018/12/29.
 * <p/>
 */
package com.xpu.example.itext.demo.errorCode;

/**
 * @author L.Wen
 */
public enum ErrorCodeEnum {

    OPERATE_OK("处理成功！", 00000),
    EXCEPTION("程序异常！", 00001),
    NULL_USERID("用户未登录！", 00002),
    MARK_READ_FAILURE("标记已读失败！", 00003),
    BATCH_DEL_FAILURE("批量删除失败！", 00004),
    DEL_FAILURE("单条删除失败！", 00005),
    GET_NOTICE_FAILURE("获取信息失败！", 00006),
    INCOMING_MSG_NULL("传入信息为空！", 00010),
    SAVE_FAILURE("保存失败！", 00011),
    FILE_UPLOAD_FAILURE("文件上传失败！", 00012),
    FILE_TYPE_WRONG("文件类型不正确！", 00013),
    PDF_EDIT_WRONG("pdf文件处理失败！", 00014);
    String errorMsg;
    Integer errorCode;

    ErrorCodeEnum(final String errorMsg, final Integer errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
