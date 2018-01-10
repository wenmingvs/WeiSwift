package com.wenming.weiswift.app.common.entity;

/**
 * 用户信息实体类
 * <p>
 * Created by wenmingvs on 2018/1/10.
 */
public class UserEntity {
    /**
     * 用户UID
     */
    private long id;
    /**
     * 字符串型的用户 UID
     */
    private String idStr;
    /**
     * 用户昵称
     */
    private String screenName;
    /**
     * 好友显示名称
     */
    private String name;
    /**
     * 用户所在省级ID
     */
    private int province;
    /**
     * 用户所在城市ID
     */
    private int city;
    /**
     * 用户所在地
     */
    private String location;
    /**
     * 用户个人描述
     */
    private String description;
    /**
     * 用户博客地址
     */
    private String url;
    /**
     * 用户头像地址，50×50像素
     */
    private String profileImageUrl;
    /**
     * 用户的个性化背景(手机)
     */
    private String coverImagePhone;
    /**
     * 用户的微博统一URL地址
     */
    private String profileUrl;
    /**
     * 用户的个性化域名
     */
    private String domain;
    /**
     * 用户的微号
     */
    private String weihao;
    /**
     * 性别，m：男、f：女、n：未知
     */
    private String gender;
    /**
     * 粉丝数
     */
    private long followersCount;
    /**
     * 关注数
     */
    private long friendsCount;

    private long pageFriendsCount;
    /**
     * 微博数
     */
    private long statusesCount;
    /**
     * 收藏数
     */
    private long favouritesCount;
    /**
     * 用户创建（注册）时间
     */
    private String createdAt;
    /**
     * 暂未支持
     */
    private boolean following;
    /**
     * 是否允许所有人给我发私信，true：是，false：否
     */
    private boolean allowAllActMsg;
    /**
     * 是否允许标识用户的地理位置，true：是，false：否
     */
    private boolean geoEnabled;
    /**
     * 是否是微博认证用户，即加V用户，true：是，false：否
     */
    private boolean verified;
    /**
     * 暂未支持
     */
    private int verifiedType;
    /**
     * 用户备注信息，只有在查询用户关系时才返回此字段
     */
    private String remark;

    /**
     * 用户的最近一条微博信息字段
     */
    private StatusEntity statusEntity;

    private String pType;

    /**
     * 是否允许所有人对我的微博进行评论，true：是，false：否
     */
    private boolean allowAllComment;
    /**
     * 用户大头像地址
     */
    private String avatarLarge;
    /**
     * 用户高清大头像地址
     */
    private String avatarHd;
    /**
     * 认证原因
     */
    private String verifiedReason;

    private String verifiedTrade;
    private String verifiedReasonUrl;
    private String verifiedSource;
    private String verifiedSourceUrl;

    /**
     * 该用户是否关注当前登录用户，true：是，false：否
     */
    private boolean followMe;

    private boolean like;
    private boolean likeMe;
    /**
     * 用户的在线状态，0：不在线、1：在线
     */
    private int onlineStatus;
    /**
     * 用户的互粉数
     */
    private int biFollowersCount;
    /**
     * 用户当前的语言版本，zh-cn：简体中文，zh-tw：繁体中文，en：英语
     */
    private int lang;
    private int star;
    private int mbType;
    private int mbRank;
    private int blockWord;
    private int blockApp;
    private int creaitScore;
    private int userAbility;
    private int uRank;
    private int storyReadState;
    private int vclubMember;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getCoverImagePhone() {
        return coverImagePhone;
    }

    public void setCoverImagePhone(String coverImagePhone) {
        this.coverImagePhone = coverImagePhone;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWeihao() {
        return weihao;
    }

    public void setWeihao(String weihao) {
        this.weihao = weihao;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(long followersCount) {
        this.followersCount = followersCount;
    }

    public long getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(long friendsCount) {
        this.friendsCount = friendsCount;
    }

    public long getPageFriendsCount() {
        return pageFriendsCount;
    }

    public void setPageFriendsCount(long pageFriendsCount) {
        this.pageFriendsCount = pageFriendsCount;
    }

    public long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public long getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(long favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isAllowAllActMsg() {
        return allowAllActMsg;
    }

    public void setAllowAllActMsg(boolean allowAllActMsg) {
        this.allowAllActMsg = allowAllActMsg;
    }

    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getVerifiedType() {
        return verifiedType;
    }

    public void setVerifiedType(int verifiedType) {
        this.verifiedType = verifiedType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public StatusEntity getStatusEntity() {
        return statusEntity;
    }

    public void setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }

    public String get() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public boolean isAllowAllComment() {
        return allowAllComment;
    }

    public void setAllowAllComment(boolean allowAllComment) {
        this.allowAllComment = allowAllComment;
    }

    public String getAvatarLarge() {
        return avatarLarge;
    }

    public void setAvatarLarge(String avatarLarge) {
        this.avatarLarge = avatarLarge;
    }

    public String getAvatarHd() {
        return avatarHd;
    }

    public void setAvatarHd(String avatarHd) {
        this.avatarHd = avatarHd;
    }

    public String getVerifiedReason() {
        return verifiedReason;
    }

    public void setVerifiedReason(String verifiedReason) {
        this.verifiedReason = verifiedReason;
    }

    public String getVerifiedTrade() {
        return verifiedTrade;
    }

    public void setVerifiedTrade(String verifiedTrade) {
        this.verifiedTrade = verifiedTrade;
    }

    public String getVerifiedReasonUrl() {
        return verifiedReasonUrl;
    }

    public void setVerifiedReasonUrl(String verifiedReasonUrl) {
        this.verifiedReasonUrl = verifiedReasonUrl;
    }

    public String getVerifiedSource() {
        return verifiedSource;
    }

    public void setVerifiedSource(String verifiedSource) {
        this.verifiedSource = verifiedSource;
    }

    public String getVerifiedSourceUrl() {
        return verifiedSourceUrl;
    }

    public void setVerifiedSourceUrl(String verifiedSourceUrl) {
        this.verifiedSourceUrl = verifiedSourceUrl;
    }

    public boolean isFollowMe() {
        return followMe;
    }

    public void setFollowMe(boolean followMe) {
        this.followMe = followMe;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isLikeMe() {
        return likeMe;
    }

    public void setLikeMe(boolean likeMe) {
        this.likeMe = likeMe;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public int getBiFollowersCount() {
        return biFollowersCount;
    }

    public void setBiFollowersCount(int biFollowersCount) {
        this.biFollowersCount = biFollowersCount;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getMbType() {
        return mbType;
    }

    public void setMbType(int mbType) {
        this.mbType = mbType;
    }

    public int getMbRank() {
        return mbRank;
    }

    public void setMbRank(int mbRank) {
        this.mbRank = mbRank;
    }

    public int getBlockWord() {
        return blockWord;
    }

    public void setBlockWord(int blockWord) {
        this.blockWord = blockWord;
    }

    public int getBlockApp() {
        return blockApp;
    }

    public void setBlockApp(int blockApp) {
        this.blockApp = blockApp;
    }

    public int getCreaitScore() {
        return creaitScore;
    }

    public void setCreaitScore(int creaitScore) {
        this.creaitScore = creaitScore;
    }

    public int getUserAbility() {
        return userAbility;
    }

    public void setUserAbility(int userAbility) {
        this.userAbility = userAbility;
    }

    public int getuRank() {
        return uRank;
    }

    public void setuRank(int uRank) {
        this.uRank = uRank;
    }

    public int getStoryReadState() {
        return storyReadState;
    }

    public void setStoryReadState(int storyReadState) {
        this.storyReadState = storyReadState;
    }

    public int getVclubMember() {
        return vclubMember;
    }

    public void setVclubMember(int vclubMember) {
        this.vclubMember = vclubMember;
    }
}
