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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a pretty poor implementation of Servlicler which will only be used as
 * a last resort.
 */
public class RubbishServlicler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final int BUFFER_SIZE = 4 * 1024;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        File file = new File(request.getServletPath());
        FileInputStream in = new FileInputStream(file);
        try {
            response.setContentType(getServletContext().getMimeType(
                    file.getName()));
            response.setContentLength((int) file.length());
            OutputStream out = response.getOutputStream();

            byte[] buf = new byte[BUFFER_SIZE];
            int read;
            while ((read = in.read(buf)) > -1) {
                out.write(buf, 0, read);
            }
        } finally {
            in.close();
        }
    }
}
