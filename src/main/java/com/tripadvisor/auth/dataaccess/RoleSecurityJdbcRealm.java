package com.tripadvisor.auth.dataaccess;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.hsqldb.jdbc.JDBCDataSource;

public class RoleSecurityJdbcRealm extends JdbcRealm
{
    public RoleSecurityJdbcRealm()
    {
        JDBCDataSource dataSource = new JDBCDataSource();
        this.setDataSource(dataSource);
    }
}
