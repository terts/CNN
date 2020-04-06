package org.terrimitchell.framework;

import org.testng.Reporter;

import io.restassured.response.Response;

public class ApiResponse {
    
    /**
     * Verify the Status Code from response.
     * @param response - contents of response
     * @param expCode - expected Status Code value
     */
    public static void verifyStatusCode(Response response, int expCode) {
        Log.assertTrue(response.getStatusCode() == expCode, 
                "Status code = " + expCode, 
                "Expected status code = " + expCode + ", Actual status code = " 
                        + response.getStatusCode());
    }
    
    /**
     * Verify specific contents from response.
     * @param response - contents of response
     * @param path - JSON path to value wish to verify contents of
     * @param expected - expected value
     */
    public static void verifySingleContent(Response response, String path, String expected) {
        String actual = response.getBody().jsonPath().getString(path)
                .replaceAll("[^a-zA-Z0-9 ]", "");
        Log.assertTrue(actual.equals(expected), 
                "Content = " + expected, 
                "Expected content = '" + expected + "', Actual content = '" + actual + "'");
    }
    
    /**
     * Verify there is more than one value for given path in response.
     * @param response - contents of response
     * @param path - JSON path to value wish to verify count of
     * @param expected - expected value
     */
    public static void verifyCountGreaterThanZero(Response response, String path) {
        int count = response.getBody().jsonPath().getList(path).size();
        Log.assertTrue(count > 0, 
                "Count = " + count, 
                "Expected count to be greater than 0, Actual = " + count);
    }
    
    /**
     * Print the response to report.
     * @param response - contents of response
     */
    public static void printResponse(Response response) {
        Reporter.log(response.prettyPrint());
    }
        
}