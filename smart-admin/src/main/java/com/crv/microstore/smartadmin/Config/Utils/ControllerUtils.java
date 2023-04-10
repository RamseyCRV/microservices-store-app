package com.crv.microstore.smartadmin.Config.Utils;


import org.apache.commons.lang.StringUtils;

public final class ControllerUtils {

    private final static String REDIRECT = "redirect:";
    /**
     * Function what build an url
     * @param redirect true or false
     * @param path the path
     * @param page the page query
     * @param category the category query
     * @return url
     */
    public static  String urlBuilder(boolean redirect, String path, String page, String category){
        StringBuilder urlBuilder = new StringBuilder();

        if (redirect == true){
            urlBuilder.append(REDIRECT);
        }
        if (path != null){
            urlBuilder.append(path);
        }
        if(page != null){
            urlBuilder.append("?page=" + page);
        }
        if(category != null){
            urlBuilder.append("&category=" + category);
        }

        return urlBuilder.toString();
    }

    /**
     * Function what build an url
     * @param redirect true or false
     * @param path the path
     * @return url
     */
    public static String urlBuilder(boolean redirect, final String path){
        StringBuilder urlBuilder = new StringBuilder();

        if(redirect == true){
            urlBuilder.append(REDIRECT);
        }

        if(path != null) {
            urlBuilder.append(path);
        }

        return urlBuilder.toString();
    }

    public static String titleBuilder(final String host, final String page){
        StringBuilder titleBuilder = new StringBuilder();

        if (StringUtils.isNotEmpty(host)){
            titleBuilder.append(host + " | ");
        }
        if(StringUtils.isNotEmpty(page)){
            titleBuilder.append(page);
        }

        return titleBuilder.toString();
    }
}
