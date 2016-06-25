<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: deepaksood619
  Date: 25/6/16
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    try{
        String s[]=null;

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
        Statement st=con.createStatement();
        st.executeQuery("USE connectbook");
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from users");

        List li = new ArrayList();

        while(rs.next())
        {
            li.add(rs.getString(1));
        }

        String[] str = new String[li.size()];
        Iterator it = li.iterator();

        int i = 0;
        while(it.hasNext())
        {
            String p = (String)it.next();
            str[i] = p;
            i++;
        }

        //jQuery related start
        String query = (String)request.getParameter("q");

        int cnt=1;
        for(int j=0;j<str.length;j++)
        {
            if(str[j].toUpperCase().startsWith(query.toUpperCase()))
            {
                out.print(str[j]+"\n");
                if(cnt>=5)// 5=How many results have to show while we are typing(auto suggestions)
                    break;
                cnt++;
            }
        }
        //jQuery related end

        rs.close();
        st.close();
        con.close();

    }
    catch(Exception e){
        e.printStackTrace();
    }

%>
