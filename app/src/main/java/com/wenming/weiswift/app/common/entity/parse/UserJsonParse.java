package com.wenming.weiswift.app.common.entity.parse;

import com.wenming.weiswift.app.common.entity.UserEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * User的Json转换类
 * <p>
 * Created by wenmingvs on 2018/1/10.
 */
public class UserJsonParse {

    /**
     * json转对象
     *
     * @param jsonString json字符串
     * @return 返回user对象
     */
    public UserEntity parse2Entity(String jsonString) {
        //TODO 优化不必要的字段
        UserEntity userEntity = new UserEntity();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            userEntity.setId(Long.parseLong(jsonObject.optString("id")));
            userEntity.setIdStr(jsonObject.optString("idstr"));
            userEntity.setScreenName(jsonObject.optString("screen_name"));
            userEntity.setName(jsonObject.optString("name"));
            userEntity.setProvince(jsonObject.optInt("province"));
            userEntity.setCity(jsonObject.optInt("city"));
            userEntity.setLocation(jsonObject.optString("location"));
            userEntity.setDescription(jsonObject.optString("description"));
            userEntity.setUrl(jsonObject.optString("url"));
            userEntity.setProfileImageUrl(jsonObject.optString("profile_image_url"));
            userEntity.setCoverImagePhone(jsonObject.optString("cover_image_phone"));
            userEntity.setProfileUrl(jsonObject.optString("profile_url"));
            userEntity.setDomain(jsonObject.optString("domain"));
            userEntity.setWeihao(jsonObject.optString("weihao"));
            userEntity.setGender(jsonObject.optString("gender"));
            userEntity.setFollowersCount(Long.valueOf(jsonObject.optString("followers_count")));
            userEntity.setFriendsCount(Long.valueOf(jsonObject.optString("friends_count")));
            userEntity.setPageFriendsCount(Long.valueOf(jsonObject.optString("statuses_count")));
            userEntity.setStatusesCount(Long.valueOf(jsonObject.optString("statuses_count")));
            userEntity.setFavouritesCount(Long.valueOf(jsonObject.optString("favourites_count")));
            userEntity.setCreatedAt(jsonObject.optString("created_at"));
            userEntity.setFollowing(jsonObject.optBoolean("following"));
            userEntity.setAllowAllActMsg(jsonObject.optBoolean("allow_all_act_msg"));
            userEntity.setGeoEnabled(jsonObject.optBoolean("geo_enabled"));
            userEntity.setVerified(jsonObject.optBoolean("verified"));
            userEntity.setVerifiedType(jsonObject.optInt("verified_ty"));
            userEntity.setRemark(jsonObject.optString("remark"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userEntity;
    }
}
