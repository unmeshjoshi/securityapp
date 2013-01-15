package com.tripadvisor.auth.controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer implements ServletContextListener
{
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        try
        {
            Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:aname", "sa", "");
            Statement statement = c.createStatement();
            statement.execute("create table user(user varchar(50), password varchar(50)) ");
            c.commit();
            System.out.println("user table created");
        } catch (SQLException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
