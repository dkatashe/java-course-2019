package com.javacourse.lection2.tempconverter.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

public class AuthUtil
{
  private CsvUtil csvUtil;
  private ArrayList<User> users;

  public AuthUtil() throws IOException
  {
    csvUtil=new CsvUtil();
    this.users=getUsers();
  }

  public static class User
  {
    private String login;
    private String password;

    User(String login, String password)
    {
      this.login=login;
      this.password=password;
    }

    public String getLogin()
    {
      return login;
    }

    String getPassword()
    {
      return password;
    }

    void setPassword(String password)
    {
      this.password=password;
    }

    @Override
    public String toString()
    {
      return login;
    }
  }

  public int getUserCount()
  {
    return users.size();
  }

  public void printUsers()
  {
    for (User user : users)
    {
      System.out.println(user.getLogin());
    }
  }

  private ArrayList<User> getUsers()
  {
    ArrayList<User> users=new ArrayList<>();

    try
    {
      users=csvUtil.parse("res/lec2_tempconverter/users.csv");
    }
    catch (NoSuchFileException e)
    {
      File userFile=new File("res/lec2_tempconverter/users.csv");
      try
      {
        userFile.createNewFile();
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
      System.out.println("Users file didn't exist, empty file created.");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return users;
  }

  private void saveStateToFile()
  {
    try
    {
      csvUtil.save(this.users, "res/lec2_tempconverter/users.csv");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public User authenticate(String login, String password)
  {
    for (User user : users)
    {
      if (user.getLogin().equals(login))
      {
        if (user.getPassword().equals(password))
        {
          return user;
        }
        else
        {
          throw new IllegalArgumentException("Password is incorrect");
        }
      }
    }

    throw new IllegalArgumentException("No user with such login exists");
  }

  public void createUser(String login, String password)
  {
    for (User user : users)
    {
      if (user.getLogin().equals(login))
        throw new IllegalArgumentException("User with this login already exists");
    }

    User user=new User(login, password);
    users.add(user);
    saveStateToFile();
  }

  public void deleteUser(String login)
  {
    for (int i=0; i < users.size(); i++)
    {
      if (users.get(i).getLogin().equals(login))
      {
        users.remove(i);
        saveStateToFile();
        return;
      }
    }

    throw new IllegalArgumentException("No such user registered");
  }

  public void changePassword(String login, String newPassword)
  {
    for (User user : users)
    {
      if (user.getLogin().equals(login))
      {
        user.setPassword(newPassword);
        saveStateToFile();
        return;
      }
    }

    throw new IllegalArgumentException("Inconsistent user state");
  }
}
