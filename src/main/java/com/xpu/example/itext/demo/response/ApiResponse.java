package com.xpu.example.itext.demo.response;

/**
 * @author L.Wen
 */
public class ApiResponse implements java.io.Serializable {
    private int code;
    private String message;
    private Object data;
    private boolean more;

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public static ApiResponse ofMessage(int code, String message) {
        return new ApiResponse(code, message, null);
    }

    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    public static ApiResponse ofStatus(Status status) {
        return new ApiResponse(status.getCode(), status.getStandardMessage(), null);
    }

    public static ApiResponse ofNotPermitted() {
        return new ApiResponse(Status.Not_Permitted.getCode(), Status.Not_Permitted.getStandardMessage(), null);
    }

    public static ApiResponse ofCompanyExist() {
        return new ApiResponse(Status.CompanyExist.getCode(), Status.CompanyExist.getStandardMessage(), null);
    }

    public static ApiResponse ofNumber400Exist() {
        return new ApiResponse(Status.Number400Exist.getCode(), Status.Number400Exist.getStandardMessage(), null);
    }

    public static ApiResponse ofBlacklistExist() {
        return new ApiResponse(Status.BlacklistExist.getCode(), Status.BlacklistExist.getStandardMessage(), null);
    }

    public static ApiResponse ofBusinessNotUseable() {
        return new ApiResponse(Status.BusinessNotUseable.getCode(), Status.BusinessNotUseable.getStandardMessage(), null);

    }

    public static ApiResponse ofGuideNumberExist() {
        return new ApiResponse(Status.GuideNumberExist.getCode(), Status.GuideNumberExist.getStandardMessage(), null);
    }

    public static ApiResponse ofVoiceException(String message) {
        return new ApiResponse(Status.VoiceException.getCode(), message, null);
    }

    public static ApiResponse ofRemoteException(String message) {
        return new ApiResponse(Status.RemoteException.getCode(), message, null);
    }

    public static ApiResponse ofRelevanceError(String message) {
        return new ApiResponse(Status.RelevanceError.getCode(), message, null);
    }

    public static ApiResponse ofRedirect() {
        return new ApiResponse(Status.Redirect.getCode(), Status.Redirect.getStandardMessage(), null);
    }

    public static ApiResponse ofChannelByName() {
        return new ApiResponse(Status.ChannelByName.getCode(), Status.ChannelByName.getStandardMessage(), null);
    }

    public static ApiResponse ofChannelByEngName() {
        return new ApiResponse(Status.ChannelByEngName.getCode(), Status.ChannelByEngName.getStandardMessage(), null);
    }

    public static ApiResponse ofAccountsNotArrive() {
        return new ApiResponse(Status.AccountsNotArrive.getCode(), Status.AccountsNotArrive.getStandardMessage(), null);
    }

    public static ApiResponse ofExistUseBusiness() {
        return new ApiResponse(Status.ExistUseBusiness.getCode(), Status.ExistUseBusiness.getStandardMessage(), null);
    }

    public enum Status {
        SUCCESS(200, "OK"),
        Redirect(302, "redirect"),

        BAD_REQUEST(400, "Bad Request"),
        Not_Permitted(4005, "您无权限操作"),
        CompanyExist(4006, "该公司已经存在库中或正在审核"),
        GuideNumberExist(4007, "该引示号已经存在"),
        Number400Exist(4008, "该400号码已存在"),
        BlacklistExist(4008, "该黑名单已存在"),
        BusinessNotUseable(4009, "该公司的业务受理未审核通过或未办理"),
        ChannelByName(4011, "新增渠道中文名字已经存在"),
        ChannelByEngName(4012, "新增渠道英文名字已经存在"),
        AccountsNotArrive(4013, "账户未到账不能开通"),

        RelevanceError(4010, ""),
        ExistUseBusiness(4015, "该企业存在未注销业务"),

        VoiceException(5000, "VoiceException"),
        //底层接口错误
        RemoteException(5001, "RemoteException"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
        NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
        NOT_LOGIN(50000, "Not Login"),
        NOT_VALID_PARAM(40005, "Not valid Params"),
        DATA_EXISTS(60000, "Data already exists"),// 数据已存在
        OPERATE_ERROR(60001, "Operation failed");// 操作失败

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }
}
