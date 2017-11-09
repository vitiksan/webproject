<%@ page autoFlush="true"%>
<%@ page buffer="1000kb"%>
<jsp:useBean id="person" class="com.test.beans.Person">
    <jsp:setProperty name="person" property="name" param="vasa"/>
    <jsp:setProperty name="person" property="surname" param="dada"/>
</jsp:useBean>

<h2>Name:</h2> <jsp:getProperty name="person" property="name"/><br>
<h2>Surname:</h2> <jsp:getProperty name="person" property="surname"/><br>
<h2>Birthday:</h2> <jsp:getProperty name="person" property="birthday"/><br>

