/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easyjob.Controller.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author Deb
 */
@Entity
public class UserTable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int serial_no;
   private String user_name;
   private String email_id;   // log in id
   private String occupation;
   private String gender;
   private String password;
   private String other_mailId;
   private String profilePic;
   private String Company;
   private String aboutUser;
   private String question;
   private String answer;
   @Lob
   private byte [] ProfileImage;
   
   public UserTable(){
      
   }

   public UserTable(String user_name, String email_id, String occupation, String gender, String password, String other_mailId, String profilePic, String Company, String aboutUser, String quextion, String answer) {
      this.user_name = user_name;
      this.email_id = email_id;
      this.occupation = occupation;
      this.gender = gender;
      this.password = password;
      this.other_mailId = other_mailId;
      this.profilePic = profilePic;
      this.Company = Company;
      this.aboutUser = aboutUser;
      this.question = quextion;
      this.answer = answer;
   }

   public UserTable(String user_name, String email_id, String occupation, String gender, String password, String quextion, String answer) {
      this.user_name = user_name;
      this.email_id = email_id;
      this.occupation = occupation;
      this.gender = gender;
      this.password = password;
      this.question = quextion;
      this.answer = answer;
   }
   
   
   
   
   
   
   

   public UserTable(String user_name, String email_id, String occupation, String gender, String password) {
      this.user_name = user_name;
      this.email_id = email_id;
      this.occupation = occupation;
      this.gender = gender;
      this.password = password;
   }

   public UserTable(String user_name, String occupation, String gender, String password, String other_mailId, String profilePic, String Company, String aboutUser) {
      this.user_name = user_name;
      this.occupation = occupation;
      this.gender = gender;
      this.password = password;
      this.other_mailId = other_mailId;
      this.profilePic = profilePic;
      this.Company = Company;
      this.aboutUser = aboutUser;

   }

   public String getOther_mailId() {
      return other_mailId;
   }

   public void setOther_mailId(String other_mailId) {
      this.other_mailId = other_mailId;
   }

   public String getProfilePic() {
      return profilePic;
   }

   public void setProfilePic(String profilePic) {
      this.profilePic = profilePic;
   }

   public String getCompany() {
      return Company;
   }

   public void setCompany(String Company) {
      this.Company = Company;
   }

   public String getAboutUser() {
      return aboutUser;
   }

   public void setAboutUser(String aboutUser) {
      this.aboutUser = aboutUser;
   }

 
   
   
   
   
   public String getOccupation() {
      return occupation;
   }

   public void setOccupation(String occupation) {
      this.occupation = occupation;
   }
   
   
   public int getSerial_no() {
      return serial_no;
   }

   public void setSerial_no(int serial_no) {
      this.serial_no = serial_no;
   }

   public String getUser_name() {
      return user_name;
   }

   public void setUser_name(String user_name) {
      this.user_name = user_name;
   }

   public String getEmail_id() {
      return email_id;
   }

   public void setEmail_id(String email_id) {
      this.email_id = email_id;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getQuestion() {
      return question;
   }

   public void setQuestion(String question) {
      this.question = question;
   }

   public String getAnswer() {
      return answer;
   }

   public void setAnswer(String answer) {
      this.answer = answer;
   }

   public byte[] getProfileImage() {
      return ProfileImage;
   }

   public void setProfileImage(byte[] ProfileImage) {
      this.ProfileImage = ProfileImage;
   }

  
   
   
   
   

   @Override
   public String toString() {
      return "UserTable{" + "serial_no=" + serial_no + ", user_name=" + user_name + ", email_id=" + email_id + ", occupation=" + occupation + ", gender=" + gender + ", password=" + password + ", other_mailId=" + other_mailId + ", profilePic=" + profilePic + ", Company=" + Company + ", aboutUser=" + aboutUser + ", quextion=" + question + ", answer=" + answer + '}';
   }


   
   
   
   
   
   
   
   
   
   
   
   
   
  

  



 
}
