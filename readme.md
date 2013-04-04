Mostly a Java EE 6 Sample enterprise application. The code is purposely trivial to focus on the technical capabilities of 
JEE 6 to  produce  a Spring/Hibernate type application.  The component projects are as follows:

- EJB 3.0 session bean with client. The session bean exposes its access method as a SOAP web service. 
- Web application with servlet, RESTful service  and JSF 2.0 interfaces. REST service returns info as XML (using JAXB), 
  JSON and plain text.
- JPA Entity bean (database: Oracle 11g)

(For additional code samples, see Gists: [a link] https://gist.github.com/cab1729)
