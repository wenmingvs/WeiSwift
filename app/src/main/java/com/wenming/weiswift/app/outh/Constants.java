package com.wenming.weiswift.app.outh;

import android.text.TextUtils;

/**
 * Created by wenmingvs on 2018/1/9.
 */
public class Constants {
    public static final String APP_KEY = "4037909131";
    public static final String APP_REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    public static final String APP_SCOPE = "email,direct_messages_read,direct_messages_write,"
            + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
            + "follow_app_official_microblog," + "invitation_write";

    public static final String WEICO_APP_KEY = "211160679";
    public static final String WEICO_REDIRECT_URL = "http://oauth.weico.cc";
    public static final String WEICO_SCOPE = "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write";
    public static final String WEICO_APP_SECRET = "1e6e33db08f9192306c4afa0a61ad56c";
    public static final String WEICO_PACKAGENAME = "com.eico.weico";

    public static final String AUTHURL = "https://open.weibo.cn/oauth2/authorize?"
            + "client_id=" + APP_KEY
            + "&response_type=token&redirect_uri=" + APP_REDIRECT_URL
            + "&key_hash=" + WEICO_APP_SECRET + (TextUtils.isEmpty(WEICO_PACKAGENAME) ? "" : "&packagename=" + WEICO_PACKAGENAME)
            + "&display=mobile" + "&scope=" + APP_SCOPE;
}
