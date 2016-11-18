package com.huamo.appservice.entity;

import com.huamo.appservice.common.Constant;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by luohh on 2016/10/17.
 */
@Document(indexName = Constant.IndexName.ORDER_INDEX,type = Constant.IndexType.ORDER_INDEX_TYPE)
public class Order {
    @Id
    @Field(type = FieldType.Integer,index = FieldIndex.not_analyzed, store = true)
    private Integer id;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String order_num;

    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private String sub_order_num;

    @Field(type = FieldType.Integer,index = FieldIndex.not_analyzed, store = true)
    private Integer order_type;

    @Field(type = FieldType.Integer,index = FieldIndex.not_analyzed, store = true)
    private Integer activity_id;

    @Field(type = FieldType.Integer,index = FieldIndex.not_analyzed, store = true)
    private Integer supplier_id;

    //@Field(type = FieldType.String,  indexAnalyzer="ik", searchAnalyzer="ik", store = true)
    @Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
    private String supplier_name;

    @Field(type = FieldType.Integer,index = FieldIndex.not_analyzed, store = true)
    private Integer user_id;


    //@Field(type = FieldType.Date,format = DateFormat.custom,index = FieldIndex.not_analyzed, store = true)

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @Field(type = FieldType.Date, store = true, format=DateFormat.date)
    private Date create_time;
    /*private String buyer_name;
    private String buyer_tel;
    private String venue_cityid;
    private String venue_session;
    private String pay_type;
    private String final_pay_money;
    private String final_pay_time;
    private String paid_money;
    private String earnest;
    private String earnest_time;
    private String full_pay_money;
    private String full_pay_time;
    private String agreement_price;
    private String jb_discount_money;
    private String freight_cost;
    private String score;
    private String coupon_code;
    private String coupon_value;
    private String coupon_get_id;
    private String order_status;
    private String jb_create_status;
    private String order_remark;
    private String receiver_name;
    private String receiver_tel;
    private String receiver_address;
    private String receiver_time;
    private String goods_deliver_time;
    private String comment;
    private String verify_code;
    private String is_verify;
    private String is_user_confirm;
    private String total_money;
    private String suopei_money;
    private String refund_money;
    private String src;
    private String uis;
    private String source_sys;
    private String staff_account_id;
    private String staff_account;
    private String supplier_account_id;
    private String supplier_account;
    private String is_checkout;
    private String finance_audit_status;
    private String create_time;
    private Integer del_flag;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getSub_order_num() {
        return sub_order_num;
    }

    public void setSub_order_num(String sub_order_num) {
        this.sub_order_num = sub_order_num;
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
