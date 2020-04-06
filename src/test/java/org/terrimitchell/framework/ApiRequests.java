package org.terrimitchell.framework;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiRequests {
    
    /**
     * Set up a basic URL Request Specification.
     * @param base - base URI
     * @param path - base path
     * @return built request spec
     */
    public static RequestSpecification setUrl(String base, String path) {
        RequestSpecification request = RestAssured.given();
        request.baseUri(base);
        request.basePath(path);
        return request;
    }
    
    /**
     * Set up a URL Request Specification with Query Params.
     * @param base - base URI
     * @param path - base path
     * @return built request spec
     */
    public static RequestSpecification setUrlWithQueryParams(String base, String path, 
            Map<String,?> params) {
        RequestSpecification request = setUrl(base, path);
        request.queryParams(params);
        return request;
    }
        
}