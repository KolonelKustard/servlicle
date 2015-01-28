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

    /**
     * This is the beast that overrides the original wrapped getResource to
     * allow access to files outside the webapp root.
     */
    public WebResource getResource(String path) {
        return new FileResource(wrapped, path, new File(path), true);
    }

    public void addLifecycleListener(LifecycleListener listener) {
        wrapped.addLifecycleListener(listener);
    }

    public LifecycleListener[] findLifecycleListeners() {
        return wrapped.findLifecycleListeners();
    }

    public void removeLifecycleListener(LifecycleListener listener) {
        wrapped.removeLifecycleListener(listener);
    }

    public void init() throws LifecycleException {
        wrapped.init();
    }

    public void start() throws LifecycleException {
        wrapped.start();
    }

    public void stop() throws LifecycleException {
        wrapped.stop();
    }

    public void destroy() throws LifecycleException {
        wrapped.destroy();
    }

    public LifecycleState getState() {
        return wrapped.getState();
    }

    public String getStateName() {
        return wrapped.getStateName();
    }

    public WebResource[] getResources(String path) {
        return wrapped.getResources(path);
    }

    public WebResource getClassLoaderResource(String path) {
        return wrapped.getClassLoaderResource(path);
    }

    public WebResource[] getClassLoaderResources(String path) {
        return wrapped.getClassLoaderResources(path);
    }

    public String[] list(String path) {
        return wrapped.list(path);
    }

    public Set<String> listWebAppPaths(String path) {
        return wrapped.listWebAppPaths(path);
    }

    public WebResource[] listResources(String path) {
        return wrapped.listResources(path);
    }

    public boolean mkdir(String path) {
        return wrapped.mkdir(path);
    }

    public boolean write(String path, InputStream is, boolean overwrite) {
        return wrapped.write(path, is, overwrite);
    }

    public void createWebResourceSet(ResourceSetType type, String webAppMount,
            URL url, String internalPath) {
        wrapped.createWebResourceSet(type, webAppMount, url, internalPath);
    }

    public void createWebResourceSet(ResourceSetType type, String webAppMount,
            String base, String archivePath, String internalPath) {
        wrapped.createWebResourceSet(type, webAppMount, base, archivePath,
                internalPath);
    }

    public void addPreResources(WebResourceSet webResourceSet) {
        wrapped.addPostResources(webResourceSet);
    }

    public WebResourceSet[] getPreResources() {
        return wrapped.getPreResources();
    }

    public void addJarResources(WebResourceSet webResourceSet) {
        wrapped.addJarResources(webResourceSet);
    }

    public WebResourceSet[] getJarResources() {
        return wrapped.getJarResources();
    }

    public void addPostResources(WebResourceSet webResourceSet) {
        wrapped.addPostResources(webResourceSet);
    }

    public WebResourceSet[] getPostResources() {
        return wrapped.getPostResources();
    }

    public Context getContext() {
        return wrapped.getContext();
    }

    public void setContext(Context context) {
        wrapped.setContext(context);
    }

    public void setAllowLinking(boolean allowLinking) {
        wrapped.setAllowLinking(allowLinking);
    }

    public boolean getAllowLinking() {
        return wrapped.getAllowLinking();
    }

    public void setCachingAllowed(boolean cachingAllowed) {
        wrapped.setCachingAllowed(cachingAllowed);
    }

    public boolean isCachingAllowed() {
        return wrapped.isCachingAllowed();
    }

    public void setCacheTtl(long ttl) {
        wrapped.setCacheTtl(ttl);
    }

    public long getCacheTtl() {
        return wrapped.getCacheTtl();
    }

    public void setCacheMaxSize(long cacheMaxSize) {
        wrapped.setCacheMaxSize(cacheMaxSize);
    }

    public long getCacheMaxSize() {
        return wrapped.getCacheMaxSize();
    }

    public void setCacheObjectMaxSize(int cacheObjectMaxSize) {
        wrapped.setCacheObjectMaxSize(cacheObjectMaxSize);
    }

    public int getCacheObjectMaxSize() {
        return wrapped.getCacheObjectMaxSize();
    }

    public void setTrackLockedFiles(boolean trackLockedFiles) {
        wrapped.setTrackLockedFiles(trackLockedFiles);
    }

    public boolean getTrackLockedFiles() {
        return wrapped.getTrackLockedFiles();
    }

    public void backgroundProcess() {
        wrapped.backgroundProcess();
    }

    public void registerTrackedResource(TrackedWebResource trackedResource) {
        wrapped.registerTrackedResource(trackedResource);
    }

    public void deregisterTrackedResource(TrackedWebResource trackedResource) {
        wrapped.deregisterTrackedResource(trackedResource);
    }

    public List<URL> getBaseUrls() {
        return wrapped.getBaseUrls();
    }
}
