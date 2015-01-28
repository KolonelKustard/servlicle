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

import javax.servlet.ServletException;

import org.apache.catalina.servlets.DefaultServlet;

public class Tomcat7Servlicler extends DefaultServlet {
    private static final long serialVersionUID = -4308122314850536121L;

    @Override
    public void init() throws ServletException {
        super.init();
        this.resources = new Tomcat7ServliclerProxyDirContext(resources);
    }
}
