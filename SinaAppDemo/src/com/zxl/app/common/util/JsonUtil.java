package com.zxl.app.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

/**
 * @Author  wh
 */
public class JsonUtil
{

    public static void printJSONObject(JSONObject obj) {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            try {
                writer = response.getWriter();
                writer.print(obj.toString());
            } catch (IOException e) {
            	e.printStackTrace();
            }
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
        
    public static void printJSONArray(JSONArray jsonarray) {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            try {
                writer = response.getWriter();
                writer.print(jsonarray.toString());
            } catch (IOException e) {
            	e.printStackTrace();
            } 
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}

