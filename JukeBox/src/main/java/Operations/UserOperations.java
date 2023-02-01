package Operations;

import Connectionaapp.Connect1;
import java.util.*;


import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class UserOperations {

    Connection conn= Connect1.establishconnection();
    Scanner sc=new Scanner(System.in);
    String userName,password;
    int userId=0;

    public UserOperations() throws SQLException, ClassNotFoundException {
    }

    public int validateUser() throws Exception {
        System.out.println("1.Log In\n2.if you are a new user then please create account");
        int choice=sc.nextInt();
        if(choice==1)
        {
            System.out.println("Enter User name for login: ");
            userName=sc.next();
            System.out.println("Enter the password: ");
            password=sc.next();
            try {
                Statement s= conn.createStatement();
                ResultSet rs=s.executeQuery("select userid from user where username='"+userName+"' and password='"+password+"'");
                if(rs.next())
                {
                    userId= rs.getInt(1);
                    System.out.println("Enjoy the songs");
                }
                else
                {
                    throw new Exception("No active user found :(");
                }
            }
            catch (Exception us) {
                us.printStackTrace();
                userId=validateUser();
            }
        }
        else if(choice==2)
        {
            createAccount();
        }
        return userId;
    }


    public int createAccount(){
        System.out.println("Enter user name to create account: ");
        userName=sc.next();
        System.out.println("Enter the password: ");
        password=sc.next();
        try{
            PreparedStatement ps=conn.prepareStatement("insert into user (username,password) values(?,?);");
            ps.setString(1,userName);
            ps.setString(2,password);
            ps.executeUpdate();
            System.out.println("Account Created Successfully :)\n");

            Statement s= conn.createStatement();
            ResultSet rs=s.executeQuery("select userid from user where username='"+userName+"'");
            while (rs.next())
            {
                userId= rs.getInt(1);
            }
        }
        catch(SQLException se){
            se.printStackTrace();
            System.out.println("User name already exists :(\n\n Please try different UserName");
            createAccount();
        }
        return userId;
    }
}

