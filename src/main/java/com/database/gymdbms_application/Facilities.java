package com.database.gymdbms_application;

public class Facilities
{
   String Location;
   String Number_OfEmployees;
   String Number_OfMembers;

   public Facilities(String location, String number_OfEmployees, String number_OfMembers) {
      Location = location;
      Number_OfEmployees = number_OfEmployees;
      Number_OfMembers = number_OfMembers;
   }

   public String getLocation() {
      return Location;
   }

   public void setLocation(String location) {
      Location = location;
   }

   public String getNumber_OfEmployees() {
      return Number_OfEmployees;
   }

   public void setNumber_OfEmployees(String number_OfEmployees) {
      Number_OfEmployees = number_OfEmployees;
   }

   public String getNumber_OfMembers() {
      return Number_OfMembers;
   }

   public void setNumber_OfMembers(String number_OfMembers) {
      Number_OfMembers = number_OfMembers;
   }
}
