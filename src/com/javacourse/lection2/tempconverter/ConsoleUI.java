package com.javacourse.lection2.tempconverter;

import com.javacourse.lection2.tempconverter.util.AuthUtil;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class ConsoleUI
{
  private static boolean isRunning=true;
  private static AuthUtil.User currentUser;
  private static Scanner sc=new Scanner(System.in).useLocale(Locale.US);

  private static void convert(int mode)
  {
    Converter converter=new Converter();
    double result;

    System.out.print("Enter temperature: ");

    try
    {
      double input=sc.nextDouble();

      if (mode == 1)
      {
        result=converter.convertToFahrenheit(currentUser.getLogin(), input);
      }
      else
      {
        result=converter.convertToCelsius(currentUser.getLogin(), input);
      }

      System.out.println("Result: " + result + "\n");
    }
    catch (InputMismatchException e)
    {
      System.out.println("Input value is invalid.\n");
      convert(mode);
    }
  }

  private static void listUsers()
  {
    try
    {
      System.out.println("\nRegistered users:");
      AuthUtil auth=new AuthUtil();
      auth.printUsers();
      System.out.println();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private static void createUser()
  {
    System.out.print("Enter login: ");
    String login=sc.nextLine();
    System.out.print("Enter password: ");
    String password=sc.nextLine();

    try
    {
      AuthUtil auth=new AuthUtil();
      auth.createUser(login, password);
      System.out.println("User created.\n");
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("Error: " + e.getMessage());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private static void deleteUser()
  {
    System.out.print("Enter login: ");
    String login=sc.nextLine();

    if (login.equals(currentUser.getLogin()))
    {
      System.out.println("You can't delete yourself.\n");
      return;
    }

    try
    {
      AuthUtil auth=new AuthUtil();
      auth.deleteUser(login);
      System.out.println("User deleted.\n");
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("Error: " + e.getMessage());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private static void changeUserPassword()
  {
    System.out.print("Enter new password: ");
    String newPass=sc.nextLine();

    try
    {
      AuthUtil auth=new AuthUtil();
      auth.changePassword(currentUser.getLogin(), newPass);
      System.out.println("Password changed.\n");
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("Error: " + e.getMessage());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private static void manageUsers()
  {
    boolean isEnded=false;

    while (!isEnded)
    {
      try
      {
        System.out.println("User management\n");
        System.out.println("1) List all users");
        System.out.println("2) Create user");
        System.out.println("3) Delete user");
        System.out.println("4) Change your password");
        System.out.println("5) Back to main menu\n");
        System.out.print("Your choice: ");

        int selection=sc.nextInt();
        sc.nextLine();

        switch (selection)
        {
          case 1:
            listUsers();
            break;
          case 2:
            createUser();
            break;
          case 3:
            deleteUser();
            break;
          case 4:
            changeUserPassword();
            break;
          case 5:
            isEnded=true;
            break;
          default:
            System.out.println("Unrecognized option\n");
            break;
        }
      }
      catch (InputMismatchException e)
      {
        System.out.println("Input value is invalid.\n");
        sc.nextLine();
      }
    }
  }

  private static void selectMode()
  {
    System.out.println("Available actions:\n");
    System.out.println("1) Convert Celsius to Fahrenheit");
    System.out.println("2) Convert Fahrenheit to Celsius");
    System.out.println("3) User management");
    System.out.println("4) Exit\n");
    System.out.print("Your choice: ");
    int opt;

    try
    {
      opt=sc.nextInt();
    }
    catch (InputMismatchException e)
    {
      System.out.println("Input value is invalid.\n");

      return;
    }

    switch (opt)
    {
      case 1:
      case 2:
        String modeStr=(opt == 1) ? "Celsius to Fahrenheit" : "Fahrenheit to Celsius";
        System.out.println(modeStr + " conversion\n");
        convert(opt);
        break;
      case 3:
        manageUsers();
        break;
      case 4:
        sc.close();
        isRunning=false;
        break;
      default:
        System.out.println("Unrecognized option\n");
        break;
    }
  }

  private static boolean authenticate()
  {
    try
    {
      boolean isLoggedIn=false;

      while (!isLoggedIn)
      {
        try
        {
          AuthUtil auth=new AuthUtil();
          if (auth.getUserCount() == 0)
          {
            System.out.println("Create first user before start.\n");
            createUser();
          }
          else
          {
            System.out.print("Login: ");
            String login=sc.nextLine();
            System.out.print("Password: ");
            String password=sc.nextLine();

            currentUser=auth.authenticate(login, password);
            isLoggedIn=true;
          }
        }
        catch (IllegalArgumentException e)
        {
          System.out.println("Error: " + e.getMessage());
        }
      }

      return true;
    }
    catch (IOException e)
    {
      System.err.println(e.getMessage());
      return false;
    }
  }

  public static void main(String[] args)
  {
    boolean authenticated=authenticate();

    if (!authenticated)
      return;

    System.out.println("Welcome " + currentUser + "!\n");

    while (isRunning)
      selectMode();
  }
}
