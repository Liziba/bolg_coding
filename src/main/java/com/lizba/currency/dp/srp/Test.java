package com.lizba.currency.dp.srp;

/**
 * <p>
 *
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/20 11:38
 */
public class Test {

    public static void main(String[] args) {

        // 修改前
//        IUserInfo userInfo = new UserInfo();
//        userInfo.setAddress("中国广东深圳");
//        userInfo.deleteUser("10000000001");

        // 修改后
        IUserInfo userInfo = new UserInfo();
        IUserBO userBO = (IUserBO)userInfo;
        userBO.setAddress("中国广东深圳");

        IUserBiz userBiz = (IUserBiz)userInfo;
        userBiz.deleteUser("10000000001");

    }

}
