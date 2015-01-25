# Servlicle

Provide a Java Servlet which will respond with a file in a decent way.

It's pretty annoying how each Servlet container has a "default" servlet which
will return a file from your web app but only if said file exists in the web
archive space of your web app. For those cases when the file comes from
somewhere else you have to do some tedious stream mangling.

Servlicle provides container specific hacks to re-use the containers default
servlet to return a file whose path you provide. This adds a lot of benefits
such as re-use, support for weird annoying to implement things like Range's and
it avoids stupid boilerplate code in your Servlet app.

Currently there is support for:

- Tomcat 8

The hacks will be tried in the order of the above list. If the hacks fail to
start up for the containers mentioned above then it will fall back to a rubbish
implementation.

If your choice of container isn't available above then please add it and submit
a pull request!

Oh and just to note that if you're thinking of using this in Production then
maybe have a re-think of how you're doing things as for static resources in the
majority of cases it'd be better to serve them from some kind of CDN.

## How to Servlicle

Add the dependency to your pom.xml as follows:

```
<dependency>
  <groupId>com.totalchange.servlicle</groupId>
  <artifactId>servlicle</artifactId>
  <version>1.0.0</version>
</dependency>
```

or download from
http://mvnrepository.com/artifact/com.totalchange.servlicle/servlicle

Then add a Servlet which extends Servliclet as follows:

```
@WebServlet("/servliclet")
public final class MyServliclet extends Servliclet {
    @Override
    protected File gimmeFile(HttpServletRequest request,
            HttpServletResponse response) {
        return new File("/my/file.mp4");
    }
}
```
