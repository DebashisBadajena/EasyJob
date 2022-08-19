/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Deb
 */
@Entity

public class ApplicationTable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int serialNo;
   private String jobId;
   private String userId;
   private String applyDate;
   private String applyTime;
   private String ApplicantQualification;
   private String applicantExperience;
   private String ApplicantDescription;

   public ApplicationTable() {
   }

   public ApplicationTable(String jobId, String userId, String applyDate, String applyTime) {
      this.jobId = jobId;
      this.userId = userId;
      this.applyDate = applyDate;
      this.applyTime = applyTime;
   }

   public ApplicationTable(String jobId, String userId, String applyDate, String applyTime, String ApplicantQualification, String applicantExperience, String ApplicantDescription) {
      this.jobId = jobId;
      this.userId = userId;
      this.applyDate = applyDate;
      this.applyTime = applyTime;
      this.ApplicantQualification = ApplicantQualification;
      this.applicantExperience = applicantExperience;
      this.ApplicantDescription = ApplicantDescription;
   }
   
   

   public String getApplicantQualification() {
      return ApplicantQualification;
   }

   public void setApplicantQualification(String ApplicantQualification) {
      this.ApplicantQualification = ApplicantQualification;
   }

   public String getApplicantExperience() {
      return applicantExperience;
   }

   public void setApplicantExperience(String applicantExperience) {
      this.applicantExperience = applicantExperience;
   }

   public String getApplicantDescription() {
      return ApplicantDescription;
   }

   public void setApplicantDescription(String ApplicantDescription) {
      this.ApplicantDescription = ApplicantDescription;
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

   public String getApplyDate() {
      return applyDate;
   }

   public void setApplyDate(String applyDate) {
      this.applyDate = applyDate;
   }

   public String getApplyTime() {
      return applyTime;
   }

   public void setApplyTime(String applyTime) {
      this.applyTime = applyTime;
   }

   @Override
   public String toString() {
      return "ApplicationTable{" + "serialNo=" + serialNo + ", jobId=" + jobId + ", userId=" + userId + ", applyDate=" + applyDate + ", applyTime=" + applyTime + ", ApplicantQualification=" + ApplicantQualification + ", applicantExperience=" + applicantExperience + ", ApplicantDescription=" + ApplicantDescription + '}';
   }

   
  
   
   
   
}
