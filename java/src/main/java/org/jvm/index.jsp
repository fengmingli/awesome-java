<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@page import="org.jvm.*" %>
<%@ page import="org.jvm.JavaClassExecutor" %>
<%
    InputStream is = new FileInputStream("/Users/mockuai/lifengming/github/awesome-java/java/src/main/java/com/lifengming/github/CloassLoader/TestClass.class");
    byte[] b = new byte[is.available()];
    is.read();
    is.close();

    System.out.println("<textarea system='width:1000;height=800'>");
    System.out.println(JavaClassExecutor.execute(b));
    System.out.println("</textarea>");
%>
