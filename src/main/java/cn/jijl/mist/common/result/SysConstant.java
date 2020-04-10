package cn.jijl.mist.common.result;

/**
 * @Author jijl
 * @Description: 系统公共常量
 * @Date 11:51 2019/10/28
 * @Param
 * @return
 **/
public class SysConstant {

    public static final String PROJECT_NAME = "JIJL_";
    public static final String MANAGER = "manager";
    public static final String MANAGER_ID = "managerId";
    public static final String TOKEN = "Authorization";
    public static final String ADMIN = "admin";
    /**
     * 管理员授权过期时间
     */
    public static final long ADMIN_AUTH_TIMEOUT = 259200000;

    public static class Redis {
        public final static String MESSAGE1 = "jijl_message1";
        public final static String MESSAGE2 = "jijl_message2";
    }
}
