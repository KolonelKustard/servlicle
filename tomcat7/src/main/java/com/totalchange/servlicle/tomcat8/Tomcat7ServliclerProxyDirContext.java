package com.totalchange.servlicle.tomcat8;

import java.util.Hashtable;

import javax.naming.directory.DirContext;

import org.apache.naming.resources.ProxyDirContext;

public class Tomcat7ServliclerProxyDirContext extends ProxyDirContext {
    public Tomcat7ServliclerProxyDirContext(ProxyDirContext wrapped) {
        super(wrapped.getEnvironment(), wrapped.getDirContext());
    }
}
