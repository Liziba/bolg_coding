package com.lizba.currency.dp.srp;

/**
 * <p>
 *      用户接口定义 -- 不符合单一职责原则
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/20 11:06
 */
public interface IUserInfo extends IUserBiz, IUserBO{

    /**
     * 用户属性相关
     */
    void setPassword(String password);
    String getPassword();
    void setUserName(String userName);
    String getUserName();
    void setAddress(String address);
    String getAddress();

    /**
     * 用户行为相关
     */
    boolean changePassword(String oldPassword, String newPassword);
    boolean deleteUser(String userId);
    boolean addOrg(int orgId);
    boolean addRole(int roleId);

}
