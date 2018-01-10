package com.wenming.weiswift.app.common.constants;

/**
 * 新浪微博请求接口
 * <p>
 * Created by wenmingvs on 2018/1/10.
 */
public class APIConstants {
    /**
     * 访问微博服务接口的地址
     */
    public static final String API_SERVER = "https://api.weibo.com/2";

    /**
     * 获取当前登录用户及其所关注（授权）用户的最新微博
     */
    public static final String FRIENDS_TIMELINE = API_SERVER + "/statuses/friends_timeline.json";

    /**
     * 根据用户ID获取用户信息
     */
    public static final String USER_SHOW = API_SERVER + "/users/show.json";

    /**
     * 获取当前登陆用户好友分组列表
     */
    public static final String GROUPS = API_SERVER + "/friendships/groups.json";

    /**
     * 获取当前登录用户某一好友分组的微博列表
     */
    public static final String GROUPS_TIMELINE = API_SERVER + "/friendships/groups/timeline.json";

    /**
     * 将一个或多个短链接还原成原始的长链接
     */
    public static final String SHORT_URL_EXPAND = API_SERVER + "/short_url/expand.json";
}
