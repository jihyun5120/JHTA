package semishit;

import java.util.Date;

import javax.swing.Icon;

public class EmployeesVo {
   int eNum;
   String eName;
   Date bDate;
   String phone;
   String email;
   String address;
   String jName;
   Date hDate;
   String remark;
   String ePhoto;
   int salary;
   String ePName;
   
   public EmployeesVo() {
      
   }
   
   public EmployeesVo(int eNum, String eName, Date bDate, String phone, String email, String address, String jName, Date hDate, String remark, String ePhoto, int salary, String ePName) {
      this.eNum = eNum;
      this.eName = eName;
      this.bDate = bDate;
      this.phone = phone;
      this.email = email;
      this.address = address;
      this.jName = jName;
      this.hDate = hDate;
      this.remark = remark;
      this.ePhoto = ePhoto;
      this.salary = salary;
      this.ePName = ePName;
   }

   public int geteNum() {
      return eNum;
   }

   public void seteNum(int eNum) {
      this.eNum = eNum;
   }

   public String geteName() {
      return eName;
   }

   public void seteName(String eName) {
      this.eName = eName;
   }

   public Date getbDate() {
      return bDate;
   }

   public void setbDate(Date bDate) {
      this.bDate = bDate;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getjName() {
      return jName;
   }

   public void setjName(String jName) {
      this.jName = jName;
   }

   public Date gethDate() {
      return hDate;
   }

   public void sethDate(Date hDate) {
      this.hDate = hDate;
   }

   public String getRemark() {
      return remark;
   }

   public void setRemark(String remark) {
      this.remark = remark;
   }

   public String getePhoto() {
      return ePhoto;
   }

   public void setePhoto(String ePhoto) {
      this.ePhoto = ePhoto;
   }

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
   }

   public String getePName() {
      return ePName;
   }

   public void setePName(String ePName) {
      this.ePName = ePName;
   }
}