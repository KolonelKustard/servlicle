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
package com.totalchange.servlicle;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Extend this {@link HttpServlet servlet} to provide a decent way of streaming
 * back files form somewhere other than your web application. Just extend this
 * class and implement
 * {@link #gimmeFile(HttpServletRequest, HttpServletResponse)}.
 */
public abstract class Servliclet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String[] SERVLICLERS = new String[] { "com.totalchange.servlicle.tomcat8.Tomcat8Servlicler" };

    private HttpServlet wrapped;

    /**
     * @see HttpServlet#init()
     */
    @Override
    public void init() throws ServletException {
        wrapped = whereAmI();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        final File file = gimmeFile(request, response);
        wrapped.service(new HttpServletRequestWrapper(request) {
            @Override
            public String getPathInfo() {
                return null;
            }

            @Override
            public String getServletPath() {
                return file.getAbsolutePath();
            }
        }, response);
    }

    /**
     * Return the file you want to be streamed back.
     * 
     * @param request
     *            the originating request
     * @param response
     *            the originating response
     * @return the file you want to be returned in the response
     */
    protected abstract File gimmeFile(HttpServletRequest request,
            HttpServletResponse response) throws ServletException;

    private HttpServlet whereAmI() throws ServletException {
        for (String servliclerClassName : SERVLICLERS) {
            try {
                HttpServlet servlicler = makeAndInitMe(servliclerClassName);
                log("Servlicle can use " + servliclerClassName);
                return servlicler;
            } catch (Exception ex) {
                log("Servlicle can't use " + servliclerClassName + " because "
                        + ex.getMessage());
            }
        }

        log("Servlicle is out of luck so you're stuck with a rubbish "
                + "Servlicler. Consider adding a new better one at "
                + "https://github.com/KolonelKustard/servlicle");
        return makeRubbishOne();
    }

    private HttpServlet makeAndInitMe(String servliclerClassName)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, ServletException {
        HttpServlet servlicler = (HttpServlet) this.getClass().getClassLoader()
                .loadClass(servliclerClassName).newInstance();
        initMe(servlicler);
        return servlicler;
    }

    private void initMe(HttpServlet servlicler) throws ServletException {
        servlicler.init(getServletConfig());
    }

    private HttpServlet makeRubbishOne() throws ServletException {
        HttpServlet servlicler = new RubbishServlicler();
        initMe(servlicler);
        return servlicler;
    }
}
