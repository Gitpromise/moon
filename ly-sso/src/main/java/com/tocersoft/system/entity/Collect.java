package com.tocersoft.system.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/7/17.
 */
public class Collect implements Serializable {
 /** id*/
 private Integer id;
 /** 收藏编号*/
 private String collectNo;
 /** 会员id*/
 private String memberId;
 /** 收藏类型*/
 private Integer type;
 /** 删除字段*/
 private Integer flag;


 public String getCollectNo() {
  return collectNo;
 }

 public void setCollectNo(String collectNo) {
  this.collectNo = collectNo;
 }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getMemberId() {
  return memberId;
 }

 public void setMemberId(String memberId) {
  this.memberId = memberId;
 }

 public Integer getType() {
  return type;
 }

 public void setType(Integer type) {
  this.type = type;
 }

 public Integer getFlag() {
  return flag;
 }

 public void setFlag(Integer flag) {
  this.flag = flag;
 }
}
