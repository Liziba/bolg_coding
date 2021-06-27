package com.lizba.currency.dp.srp;

/**
 * <p>
 *      用户行为相关
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/20 11:26
 */
public interface IUserBiz {

    boolean changePassword(String oldPassword, String newPassword);
    boolean deleteUser(String userId);
    boolean addOrg(int orgId);
    boolean addRole(int roleId);

}
