package com.lizba.currency.dp.srp;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/20 11:13
 */
public class UserInfo implements IUserInfo {
    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public void setAddress(String address) {

    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public boolean addOrg(int orgId) {
        return false;
    }

    @Override
    public boolean addRole(int roleId) {
        return false;
    }
}
