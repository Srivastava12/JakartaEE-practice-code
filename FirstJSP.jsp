<html>
 <head>
   <title>First JSP</title>
 </head>
 <body>
   <%!
    String name="Shubham !";
    public int add(int a,int b){
        return a+b;
    }
   %>
   <%
    int ans=add(20,50);
   %>
   <%="Hello "+name%>
   <%="20+50="+ans%>
 </body>
</html>