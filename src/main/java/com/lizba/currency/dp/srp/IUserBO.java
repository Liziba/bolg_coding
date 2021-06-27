package com.lizba.currency.dp.srp;

/**
 * <p>
 *      用户属性相关（Business Object)
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/20 11:11
 */
public interface IUserBO {

    void setPassword(String password);
    String getPassword();
    void setUserName(String userName);
    String getUserName();
    void setAddress(String address);
    String getAddress();

}
