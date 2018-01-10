package com.wenming.weiswift.app.common.entity;

import java.util.ArrayList;

/**
 * 单条微博实体类
 * <p>
 * Created by wenmingvs on 2018/1/10.
 */
public class Status {
    /**
     * 微博创建时间
     */
    private String createdAt;
    /**
     * 微博ID
     */
    private String id;
    /**
     * 微博MID
     */
    private String mid;
    /**
     * 字符串型的微博ID
     */
    private String idstr;

    private boolean canEdit;
    /**
     * 微博信息内容
     */
    private String text;
    /**
     * 微博文本内容长度
     */
    private int textLength;
    /**
     * 微博来源是否允许点击，如果允许
     */
    private int sourceAllowClick;
    /**
     * 微博来源类型
     */
    private int sourceType;
    /**
     * 微博来源
     */
    private String source;
    /**
     * 是否已收藏，true：是，false：否
     */
    private boolean favorited;
    /**
     * 是否被截断，true：是，false：否
     */
    private boolean truncated;
    /**
     * （暂未支持）回复ID
     */
    private String inReplyToStatusId;
    /**
     * （暂未支持）回复人UID
     */
    private String inReplyToUserId;
    /**
     * （暂未支持）回复人昵称
     */
    private String inReplyToScreenName;
    /**
     * 微博图片字段
     */
    private ArrayList<PicUrlEntity> picUrls;
    /**
     * 缩略图片地址（小图），没有时不返回此字段
     */
    private String thumbnailPic;
    /**
     * 中等尺寸图片地址（中图），没有时不返回此字段
     */
    private String bmiddlePic;
    /**
     * 原始图片地址（原图），没有时不返回此字段
     */
    private String originalPic;

    private boolean isPaid;
    private int mBlogVipType;
    /**
     * 微博作者的用户信息字段
     */
    private User user;
    /**
     * 被转发的原微博信息字段，当该微博为转发微博时返回
     */
    private Status retweetedStatus;
    /**
     * 转发数
     */
    private int repostsCount;
    /**
     * 评论数
     */
    private int commentsCount;
    /**
     * 表态数
     */
    private int attitudesCount;
    private int pendingApprovalCount;
    /**
     * 是否是超过140个字的长微博
     */
    private boolean isLongText;
    private int mLevel;
    //visible object
    private int bizFeature;
    private int hasActionTypeCard;
    //darwin_tags array
    //hot_weibo_tags array
    //text_tag_tips array
    private int rid;
    private int userType;
    private int moreInfoType;
    private int positiveRecomFlag;
    private int contentAuth;
    private String gifIds;
    private int isShowBulletin;
    //comment_manage_info	Object


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextLength() {
        return textLength;
    }

    public void setTextLength(int textLength) {
        this.textLength = textLength;
    }

    public int getSourceAllowClick() {
        return sourceAllowClick;
    }

    public void setSourceAllowClick(int sourceAllowClick) {
        this.sourceAllowClick = sourceAllowClick;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(String inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public String getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(String inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public ArrayList<PicUrlEntity> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(ArrayList<PicUrlEntity> picUrls) {
        this.picUrls = picUrls;
    }

    public String getThumbnailPic() {
        return thumbnailPic;
    }

    public void setThumbnailPic(String thumbnailPic) {
        this.thumbnailPic = thumbnailPic;
    }

    public String getBmiddlePic() {
        return bmiddlePic;
    }

    public void setBmiddlePic(String bmiddlePic) {
        this.bmiddlePic = bmiddlePic;
    }

    public String getOriginalPic() {
        return originalPic;
    }

    public void setOriginalPic(String originalPic) {
        this.originalPic = originalPic;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getmBlogVipType() {
        return mBlogVipType;
    }

    public void setmBlogVipType(int mBlogVipType) {
        this.mBlogVipType = mBlogVipType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(Status retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getAttitudesCount() {
        return attitudesCount;
    }

    public void setAttitudesCount(int attitudesCount) {
        this.attitudesCount = attitudesCount;
    }

    public int getPendingApprovalCount() {
        return pendingApprovalCount;
    }

    public void setPendingApprovalCount(int pendingApprovalCount) {
        this.pendingApprovalCount = pendingApprovalCount;
    }

    public boolean isLongText() {
        return isLongText;
    }

    public void setLongText(boolean longText) {
        isLongText = longText;
    }

    public int getmLevel() {
        return mLevel;
    }

    public void setmLevel(int mLevel) {
        this.mLevel = mLevel;
    }

    public int getBizFeature() {
        return bizFeature;
    }

    public void setBizFeature(int bizFeature) {
        this.bizFeature = bizFeature;
    }

    public int getHasActionTypeCard() {
        return hasActionTypeCard;
    }

    public void setHasActionTypeCard(int hasActionTypeCard) {
        this.hasActionTypeCard = hasActionTypeCard;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getMoreInfoType() {
        return moreInfoType;
    }

    public void setMoreInfoType(int moreInfoType) {
        this.moreInfoType = moreInfoType;
    }

    public int getPositiveRecomFlag() {
        return positiveRecomFlag;
    }

    public void setPositiveRecomFlag(int positiveRecomFlag) {
        this.positiveRecomFlag = positiveRecomFlag;
    }

    public int getContentAuth() {
        return contentAuth;
    }

    public void setContentAuth(int contentAuth) {
        this.contentAuth = contentAuth;
    }

    public String getGifIds() {
        return gifIds;
    }

    public void setGifIds(String gifIds) {
        this.gifIds = gifIds;
    }

    public int getIsShowBulletin() {
        return isShowBulletin;
    }

    public void setIsShowBulletin(int isShowBulletin) {
        this.isShowBulletin = isShowBulletin;
    }
}
