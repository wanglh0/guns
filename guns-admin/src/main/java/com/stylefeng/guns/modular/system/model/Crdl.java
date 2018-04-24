package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wlh123
 * @since 2018-04-24
 */
@TableName("crdl")
public class Crdl extends Model<Crdl> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 当前时间
     */
    private Date nowdate;
    /**
     * 修改时间
     */
    private Date updatetime;
    /**
     * 联系方式
     */
    private String phone;
    private Integer dictid;
    /**
     * 代理级别
     */
    private String dictname;
    /**
     * 成本
     */
    private Float price1;
    /**
     * 应收钱
     */
    private Float price2;
    /**
     * 实际收钱
     */
    private Float price3;
    /**
     * 状态
     */
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNowdate() {
        return nowdate;
    }

    public void setNowdate(Date nowdate) {
        this.nowdate = nowdate;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDictid() {
        return dictid;
    }

    public void setDictid(Integer dictid) {
        this.dictid = dictid;
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname;
    }

    public Float getPrice1() {
        return price1;
    }

    public void setPrice1(Float price1) {
        this.price1 = price1;
    }

    public Float getPrice2() {
        return price2;
    }

    public void setPrice2(Float price2) {
        this.price2 = price2;
    }

    public Float getPrice3() {
        return price3;
    }

    public void setPrice3(Float price3) {
        this.price3 = price3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Crdl{" +
        "id=" + id +
        ", name=" + name +
        ", nowdate=" + nowdate +
        ", updatetime=" + updatetime +
        ", phone=" + phone +
        ", dictid=" + dictid +
        ", dictname=" + dictname +
        ", price1=" + price1 +
        ", price2=" + price2 +
        ", price3=" + price3 +
        ", status=" + status +
        "}";
    }
}
