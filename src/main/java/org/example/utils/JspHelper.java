package org.example.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {
    private final static String JSP_FORMAT = "/%s.jsp";
    public String getPath(String path) {
        return JSP_FORMAT.formatted(path);
    }
}
