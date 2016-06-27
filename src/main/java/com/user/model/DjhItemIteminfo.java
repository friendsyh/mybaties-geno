/*
 * DjhItemIteminfo.java
 * Copyright(C) 2014-2016 宁波大家好科技有限公司深圳分公司
 * All rights reserved.
 * -------------------------------------------------------
 * 15-8-28 下午4:45 Created.
 * author:苏阳华
 */
package com.user.model;

import java.math.BigDecimal;

public class DjhItemIteminfo {

    /** 主键，商品ID标识，包括用品、课程等 */
    private String itemId;

    /** 商品所属卖家ID */
    private String sellerId;

    /** 商品所属卖家名称 */
    private String sellerName;

    /** 商品标题 */
    private String itemTitle;

    /** 商品首图 */
    private String itemImage;

    /** 商品一级类目ID */
    private Long itemFirstCate;

    /** 商品二级类目ID
goodsClsId/courseClsId/secondHandClsId */
    private Long itemSecondCate;

    /** 商品三级类目ID
goodsClsId/courseClsId/secondHandClsId */
    private Long itemThirdCate;

    /** 商品类型
1：实体商品
2：视频课程
3：同步课程
4：线下课程
5：课件课程
6：二手商品 */
    private Integer itemType;

    private Integer itemSubType;

    /** 商品来源 */
    private Integer itemFrom;

    /** 商品状态
1：已上架
2：已下架
3：强制下架 */
    private Integer itemStatus;

    /** 商品徽标 */
    private Integer itemMark;

    /** 商品权重，默认为0 */
    private Integer itemWeight;

    /** 商品销量 */
    private Integer itemSales;

    /** 商品浏览量 */
    private Integer itemViewCount;

    /** 商品库存量 */
    private Integer itemStock;

    /** 商品库存量 */
    private Integer stockChangeRule;

    /** 是否包邮1：免费2：不免费。默认为1 */
    private Integer isItemFree;

    /** 商品价格 */
    private BigDecimal itemPrice;

    /** 是否包邮1：包邮2：不包邮。默认为1 */
    private Integer isExpressFree;

    /** 商品运费 */
    private String itemExpressInfo;

    /** 商品折扣，默认为1 */
    private BigDecimal itemDiscount;

    /** 商品扣点 */
    private BigDecimal itemDiscountPoint;

    /** 商品属性信息 */
    private String itemAttrInfo;

    /** 商品规格信息 */
    private String itemSpecInfo;

    /** 商品运费 */
    private BigDecimal itemExpressFee;

    /** 商品编号 */
    private String itemSerialNumber;

    /** 商品评论数 */
    private Integer itemEvaCount;

    /** 商品关注数 */
    private Integer itemFavCount;

    /** 商品自定义类目ID */
    private String itemCustomCls;

    /** 课程单位，预约课程特有
1：小时
2：分钟
 */
    private Integer courseUnit;

    /** 一个课时时长，预约课程特有 */
    private Integer coursePerTime;

    /** 课程教学目标 */
    private String courseGoal;

    /** 课程适用对象 */
    private String courseSuitObject;

    /** 课程安排 */
    private String courseArrange;

    /** 第几节课之后不可以退款，开班课程特有
-1：未开课部分可以随时退款
正整数N：第N节课之后不可以退款
 */
    private Integer courseRefundIndex;

    /** 第几节课之后不可以插班，开班课程特有
-1：不可以插班
0：随时可以插班
正整数N：第N节课之后不可以插班 
 */
    private Integer courseInsertIndex;

    /** 商品发布时间 */
    private String itemPostTime;

    /** 商品最后修改时间 */
    private String itemUpdateTime;

    /** 商品上架时间 */
    private String itemPutTime;

    /** 商品下架时间 */
    private String itemDropTime;

    /** 商品消费过期时间 */
    private String itemExpireTime;

    /** 商品消费过期时间 */
    private String itemDisableTime;

    private String itemAddressDetail;

    /** 省份ID */
    private String provinceId;

    /** 市ID */
    private String cityId;

    /** 县/区 ID  */
    private String areaId;

    private String itemLocation;

    /** 商品二维码 */
    private String qrCode;

    private BigDecimal itemLongitude;

    private BigDecimal itemLatitude;

    private String itemDescribe;

    /** 商品购买人数 */
    private Integer buyerCount;

    private String itemVideo;

    private BigDecimal itemDiscountPrice;

    private String itemPaymentPlan;

    private Integer itemPaymentRule;

    private String itemDescribeDetail;
}