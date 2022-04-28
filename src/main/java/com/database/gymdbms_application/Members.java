package com.database.gymdbms_application;

public class Members
{
   String Member_ID;
   String Member_FirstName;
   String Member_LastName;
   String Member_BirthDate;

   public Members(String Member_ID, String Member_FirstName, String Member_LastName, String Member_BirthDate)
   {
      this.Member_ID = Member_ID;
      this.Member_FirstName = Member_FirstName;
      this.Member_LastName = Member_LastName;
      this.Member_BirthDate = Member_BirthDate;
   }

   public String getMember_ID() {
      return Member_ID;
   }

   public void setMember_ID(String member_ID) {
      this.Member_ID = member_ID;
   }

   public String getMember_FirstName() {
      return Member_FirstName;
   }

   public void setMember_FirstName(String member_FirstName) {
      this.Member_FirstName = member_FirstName;
   }

   public String getMember_LastName() {
      return Member_LastName;
   }

   public void setMember_LastName(String member_LastName) {
      this.Member_LastName = member_LastName;
   }

   public String getMember_BirthDate() {
      return Member_BirthDate;
   }

   public void setMember_BirthDate(String Member_BirthDay) {
      this.Member_BirthDate = Member_BirthDay;
   }
}
