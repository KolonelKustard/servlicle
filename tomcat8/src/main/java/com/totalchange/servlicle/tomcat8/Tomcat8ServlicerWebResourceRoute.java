/**
 * Copyright 2015 Ralph Jones
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.totalchange.servlicle.tomcat8;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.TrackedWebResource;
import org.apache.catalina.WebResource;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.webresources.FileResource;

class Tomcat8ServlicerWebResourceRoute implements WebResourceRoot {
    private WebResourceRoot wrapped;

    public Tomcat8ServlicerWebResourceRoute(WebResourceRoot wrapped) {
        this.wrapped = wrapped;
    }

    public void addLifecycleListener(LifecycleListener listener) {
        // TODO Auto-generated method stub
        
    }

    public LifecycleListener[] findLifecycleListeners() {
        // TODO Auto-generated method stub
        return null;
    }

    public void removeLifecycleListener(LifecycleListener listener) {
        // TODO Auto-generated method stub
        
    }

    public void init() throws LifecycleException {
        // TODO Auto-generated method stub
        
    }

    public void start() throws LifecycleException {
        // TODO Auto-generated method stub
        
    }

    public void stop() throws LifecycleException {
        // TODO Auto-generated method stub
        
    }

    public void destroy() throws LifecycleException {
        // TODO Auto-generated method stub
        
    }

    public LifecycleState getState() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getStateName() {
        // TODO Auto-generated method stub
        return null;
    }

    public WebResource getResource(String path) {
        return new FileResource(wrapped, path, new File(path), true);
    }

    public WebResource[] getResources(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    public WebResource getClassLoaderResource(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    public WebResource[] getClassLoaderResources(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    public String[] list(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    public Set<String> listWebAppPaths(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    public WebResource[] listResources(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean mkdir(String path) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean write(String path, InputStream is, boolean overwrite) {
        // TODO Auto-generated method stub
        return false;
    }

    public void createWebResourceSet(ResourceSetType type, String webAppMount,
            URL url, String internalPath) {
        // TODO Auto-generated method stub
        
    }

    public void createWebResourceSet(ResourceSetType type, String webAppMount,
            String base, String archivePath, String internalPath) {
        // TODO Auto-generated method stub
        
    }

    public void addPreResources(WebResourceSet webResourceSet) {
        // TODO Auto-generated method stub
        
    }

    public WebResourceSet[] getPreResources() {
        // TODO Auto-generated method stub
        return null;
    }

    public void addJarResources(WebResourceSet webResourceSet) {
        // TODO Auto-generated method stub
        
    }

    public WebResourceSet[] getJarResources() {
        // TODO Auto-generated method stub
        return null;
    }

    public void addPostResources(WebResourceSet webResourceSet) {
        // TODO Auto-generated method stub
        
    }

    public WebResourceSet[] getPostResources() {
        // TODO Auto-generated method stub
        return null;
    }

    public Context getContext() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setContext(Context context) {
        // TODO Auto-generated method stub
        
    }

    public void setAllowLinking(boolean allowLinking) {
        // TODO Auto-generated method stub
        
    }

    public boolean getAllowLinking() {
        // TODO Auto-generated method stub
        return false;
    }

    public void setCachingAllowed(boolean cachingAllowed) {
        // TODO Auto-generated method stub
        
    }

    public boolean isCachingAllowed() {
        // TODO Auto-generated method stub
        return false;
    }

    public void setCacheTtl(long ttl) {
        // TODO Auto-generated method stub
        
    }

    public long getCacheTtl() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setCacheMaxSize(long cacheMaxSize) {
        // TODO Auto-generated method stub
        
    }

    public long getCacheMaxSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setCacheObjectMaxSize(int cacheObjectMaxSize) {
        // TODO Auto-generated method stub
        
    }

    public int getCacheObjectMaxSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setTrackLockedFiles(boolean trackLockedFiles) {
        // TODO Auto-generated method stub
        
    }

    public boolean getTrackLockedFiles() {
        // TODO Auto-generated method stub
        return false;
    }

    public void backgroundProcess() {
        // TODO Auto-generated method stub
        
    }

    public void registerTrackedResource(TrackedWebResource trackedResource) {
        // TODO Auto-generated method stub
        
    }

    public void deregisterTrackedResource(TrackedWebResource trackedResource) {
        // TODO Auto-generated method stub
        
    }

    public List<URL> getBaseUrls() {
        // TODO Auto-generated method stub
        return null;
    }

}
