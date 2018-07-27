package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author pwwu@chinaums123
 * @since 2018-07-10
 */
@TableName("t_mcht")
public class TMcht extends Model<TMcht> {

    private static final long serialVersionUID = 1L;

    /**
     * 银商商户号
     */
    @TableId("MCHTNO")
    private String mchtno;
    /**
     * 商户名称
     */
    @TableField("MCHTNAME")
    private String mchtname;
    /**
     * 商户简称
     */
    @TableField("BRIEFNAME")
    private String briefname;
    /**
     * 商户状态
     */
    @TableField("STATE")
    private String state;
    /**
     * 签名类型
     */
    @TableField("SIGN_TYPE")
    private String signType;
    /**
     * 公钥
     */
    @TableField("PUBLIC_KEY")
    private String publicKey;
    /**
     * 私钥，预留字段
     */
    @TableField("PRIVATE_KEY")
    private String privateKey;
    /**
     * MD5校验值
     */
    @TableField("MD5KEY")
    private String md5key;
    /**
     * 是否允许隔日退货
     */
    @TableField("REFUND_FLAG")
    private String refundFlag;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private String createTime;
    /**
     * 更新时间
     */
    @TableField("REFRESH_TIME")
    private String refreshTime;
    /**
     * 商户类别，详见类目表
     */
    @TableField("CATEGORYID")
    private String categoryid;
    /**
     * 所属综合体,取值为T_MALL的CODE
     */
    @TableField("MALL_CODE")
    private String mallCode;
    /**
     * 备注
     */
    @TableField("NOTE")
    private String note;


    public String getMchtno() {
        return mchtno;
    }

    public void setMchtno(String mchtno) {
        this.mchtno = mchtno;
    }

    public String getMchtname() {
        return mchtname;
    }

    public void setMchtname(String mchtname) {
        this.mchtname = mchtname;
    }

    public String getBriefname() {
        return briefname;
    }

    public void setBriefname(String briefname) {
        this.briefname = briefname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == ""? null:state;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType == ""? null:signType;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getMd5key() {
        return md5key;
    }

    public void setMd5key(String md5key) {
        this.md5key = md5key;
    }

    public String getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(String refundFlag) {
        this.refundFlag = refundFlag == "" ? null : refundFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getMallCode() {
        return mallCode;
    }

    public void setMallCode(String mallCode) {
        this.mallCode = mallCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    protected Serializable pkVal() {
        return this.mchtno;
    }

    @Override
    public String toString() {
        return "TMcht{" +
        "mchtno=" + mchtno +
        ", mchtname=" + mchtname +
        ", briefname=" + briefname +
        ", state=" + state +
        ", signType=" + signType +
        ", publicKey=" + publicKey +
        ", privateKey=" + privateKey +
        ", md5key=" + md5key +
        ", refundFlag=" + refundFlag +
        ", createTime=" + createTime +
        ", refreshTime=" + refreshTime +
        ", categoryid=" + categoryid +
        ", mallCode=" + mallCode +
        ", note=" + note +
        "}";
    }
}
