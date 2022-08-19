/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.ws.rs.GET;

/**
 *
 * @author Deb
 */
@Entity
public class ShortlistedApplicatiionTable {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int serialNo;
   private String jobId;
   private String userId;//shortlisted candidate id
   private String ShortlistedTime;
   private String ShortlistedDate;

   public ShortlistedApplicatiionTable() {
   }

   public ShortlistedApplicatiionTable(String jobId, String userId, String ShortlistedTime, String ShortlistedDate) {
      this.jobId = jobId;
      this.userId = userId;
      this.ShortlistedTime = ShortlistedTime;
      this.ShortlistedDate = ShortlistedDate;
   }

   public int getSerialNo() {
      return serialNo;
   }

   public void setSerialNo(int serialNo) {
      this.serialNo = serialNo;
   }

   public String getJobId() {
      return jobId;
   }

   public void setJobId(String jobId) {
      this.jobId = jobId;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getShortlistedTime() {
      return ShortlistedTime;
   }

   public void setShortlistedTime(String ShortlistedTime) {
      this.ShortlistedTime = ShortlistedTime;
   }

   public String getShortlistedDate() {
      return ShortlistedDate;
   }

   public void setShortlistedDate(String ShortlistedDate) {
      this.ShortlistedDate = ShortlistedDate;
   }

   @Override
   public String toString() {
      return "ShortlistedApplicatiionTable{" + "serialNo=" + serialNo + ", jobId=" + jobId + ", userId=" + userId + ", ShortlistedTime=" + ShortlistedTime + ", ShortlistedDate=" + ShortlistedDate + '}';
   }
   
   
   
}
