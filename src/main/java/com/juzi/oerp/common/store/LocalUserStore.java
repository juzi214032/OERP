package com.juzi.oerp.common.store;

/**
 * LocalUser 存储
 * 将登陆用户和当前线程绑定在一起
 *
 * @author Juzi
 * @date 2020/7/16 11:27
 */
public class LocalUserStore {

    private static final ThreadLocal<Integer> LOCAL_USER = new ThreadLocal<>();

    /**
     * 设置 LocalUser
     *
     * @param userId 用户 id
     */
    public static void setLocalUser(Integer userId) {
        LocalUserStore.LOCAL_USER.set(userId);
    }

    /**
     * 获取 LocalUser
     *
     * @return 用户信息
     */
    public static Integer getLocalUser() {
        return LocalUserStore.LOCAL_USER.get();
    }

    /**
     * 清除 LocalUser
     */
    public static void remove(){
        LocalUserStore.LOCAL_USER.remove();
    }
}
