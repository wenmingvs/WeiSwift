package com.wenming.weiswift.app.common.entity;

/**
 * 图片实体类
 * <p>
 * Created by wenmingvs on 2018/1/10.
 */
public class ImgUrlEntity {
    private String thumbnailPic;
    private String bmiddlePic;
    private String originalPic;

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
}
