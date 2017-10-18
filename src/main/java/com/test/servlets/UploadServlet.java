package com.test.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

// Created by on 18.10.2017.
@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String path = "C:\\tomcat\\ftpserver";

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File(path));
        ServletFileUpload fileUpload = new ServletFileUpload(factory);

        try {
            List items = fileUpload.parseRequest(request);
            Iterator i = items.iterator();
            while (i.hasNext()){
                FileItem item = (FileItem) i.next();
                if (!item.isFormField()){
                    String fieldName = item.getFieldName();
                    String fileName = item.getName();
                    String contentType = item.getContentType();
                    long sizeBytes = item.getSize();

                    File uploadFile = new File(path+fileName);
                    item.write(uploadFile);
                }


            }
        } catch (FileUploadException e) {
            //TODO log
        } catch (Exception e) {
            //TODO log
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
