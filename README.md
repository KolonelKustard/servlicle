Servlicle
---------

Provide a Java Servlet which will respond with a file in a decent way.

It's pretty annoying how each Servlet container has a "default" servlet which
will return a file from your web app but only if said file exists in the web
archive space of your web app. For those cases when the file comes from
somewhere else you have to do some tedious stream mangling.

