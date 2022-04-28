package com.database.gymdbms_application;

public class Employees
{
   String Employee_ID;
   String Employee_FirstName;
   String Employee_LastName;
   String Employee_BirthDate;
   String Primary_Location;
   String Employee_Type;

   public Employees(String ID, String firstName, String lastName, String birthDate, String location, String type)
   {
      Employee_ID = ID;
      Employee_FirstName = firstName;
      Employee_LastName = lastName;
      Employee_BirthDate = birthDate;
      Primary_Location = location;
      Employee_Type = type;
   }

   public String getEmployee_ID()
   {
      return Employee_ID;
   }

   public void setEmployee_ID(String employee_ID)
   {
      Employee_ID = employee_ID;
   }

   public String getEmployee_FirstName()
   {
      return Employee_FirstName;
   }

   public void setEmployee_FirstName(String employee_FirstName)
   {
      Employee_FirstName = employee_FirstName;
   }

   public String getEmployee_LastName()
   {
      return Employee_LastName;
   }

   public void setEmployee_LastName(String employee_LastName)
   {
      Employee_LastName = employee_LastName;
   }

   public String getEmployee_BirthDate()
   {
      return Employee_BirthDate;
   }

   public void setEmployee_BirthDate(String employee_BirthDate)
   {
      Employee_BirthDate = employee_BirthDate;
   }

   public String getPrimary_Location()
   {
      return Primary_Location;
   }

   public void setPrimary_Location(String primary_Location)
   {
      Primary_Location = primary_Location;
   }

   public String getEmployee_Type()
   {
      return Employee_Type;
   }

   public void setEmployee_Type(String employee_Type)
   {
      Employee_Type = employee_Type;
   }
}
