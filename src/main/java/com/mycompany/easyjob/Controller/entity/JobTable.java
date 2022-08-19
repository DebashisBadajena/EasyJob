/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Deb
 */
@Entity
public class JobTable {
   
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int serial_no;
   private String job_id;
   private String user_mail_id;//userId
   private String post_time;
   private String post_date;
   private String post_titel;
   private String experience;
   private String qualification;
   @Column(length = 50000)
   private String post_description;
   private String company;
   private String Other_Mail_id;

   public JobTable() {
   }

   public JobTable(int serial_no, String job_id, String user_mail_id, String post_time, String post_date, String post_titel, String experience, String qualification, String post_description) {
      this.serial_no = serial_no;
      this.job_id = job_id;
      this.user_mail_id = user_mail_id;
      this.post_time = post_time;
      this.post_date = post_date;
      this.post_titel = post_titel;
      this.experience = experience;
      this.qualification = qualification;
      this.post_description = post_description;
   }

   public JobTable(String job_id, String user_mail_id, String post_time, String post_date, String post_titel, String experience, String qualification, String post_description, String company) {
      this.job_id = job_id;
      this.user_mail_id = user_mail_id;
      this.post_time = post_time;
      this.post_date = post_date;
      this.post_titel = post_titel;
      this.experience = experience;
      this.qualification = qualification;
      this.post_description = post_description;
      this.company = company;
   }

   public JobTable(String job_id, String user_mail_id, String post_time, String post_date, String post_titel, String experience, String qualification, String post_description, String company, String Other_Mail_id) {
      this.job_id = job_id;
      this.user_mail_id = user_mail_id;
      this.post_time = post_time;
      this.post_date = post_date;
      this.post_titel = post_titel;
      this.experience = experience;
      this.qualification = qualification;
      this.post_description = post_description;
      this.company = company;
      this.Other_Mail_id = Other_Mail_id;
   }

   public String getOther_Mail_id() {
      return Other_Mail_id;
   }

   public void setOther_Mail_id(String Other_Mail_id) {
      this.Other_Mail_id = Other_Mail_id;
   }
   
   
   
   

   public String getCompany() {
      return company;
   }

   public void setCompany(String company) {
      this.company = company;
   }

   

   public int getSerial_no() {
      return serial_no;
   }

   public void setSerial_no(int serial_no) {
      this.serial_no = serial_no;
   }

   public String getJob_id() {
      return job_id;
   }

   public void setJob_id(String job_id) {
      this.job_id = job_id;
   }

   public String getUser_mail_id() {
      return user_mail_id;
   }

   public void setUser_mail_id(String user_mail_id) {
      this.user_mail_id = user_mail_id;
   }

   public String getPost_time() {
      return post_time;
   }

   public void setPost_time(String post_time) {
      this.post_time = post_time;
   }

   public String getPost_date() {
      return post_date;
   }

   public void setPost_date(String post_date) {
      this.post_date = post_date;
   }

   public String getPost_titel() {
      return post_titel;
   }

   public void setPost_titel(String post_titel) {
      this.post_titel = post_titel;
   }

   public String getExperience() {
      return experience;
   }

   public void setExperience(String experience) {
      this.experience = experience;
   }

   public String getQualification() {
      return qualification;
   }

   public void setQualification(String qualification) {
      this.qualification = qualification;
   }

   public String getPost_description() {
      return post_description;
   }

   public void setPost_description(String post_description) {
      this.post_description = post_description;
   }

   @Override
   public String toString() {
      return "JobTable{" + "serial_no=" + serial_no + ", job_id=" + job_id + ", user_mail_id=" + user_mail_id + ", post_time=" + post_time + ", post_date=" + post_date + ", post_titel=" + post_titel + ", experience=" + experience + ", qualification=" + qualification + ", post_description=" + post_description + '}';
   }
   
   
   
   
   
}
