package org.terrimitchell.election_test.suites;

import java.util.HashMap;
import java.util.Map;

import org.terrimitchell.framework.ApiRequests;
import org.terrimitchell.framework.ApiResponse;
import org.terrimitchell.framework.Log;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ElectionApi {
    
    private static final String BASE_URI = "https://www.googleapis.com";
    private static final String ELECTION_PATH = "/civicinfo/v2/elections";
    private static final String KEY = "AIzaSyC3OxfPDMJ9GKwdRzp0BBMU9MhwDGf_G4Y";
    private static final String INVALID_KEY = "keyInvalid";
    private static final String ERROR_JSONPATH = "error.errors.reason";
    private static final String ELECTIONS_JSONPATH = "elections.id";

    /**
     * Set up a Map of "key" Query Param.
     * @param param - the map for the "key" param
     * @return map for "key"
     */
    private static Map<String,String> buildKeyQueryParam(String param) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("key", param);
        return map;
    }
        
    /*
     * NOTE:  for the failed query tests, I would usually set up either a spreadsheet and use 
     * TestNG DataProvider, or if using Cucumber, it would be a table of data in the feature file
     * that one @Test would use to iterate through the different scenarios.  However, that would 
     * take a significant enough longer amount of time, and I didn't want you to be waiting that long
     * to get a code sample from me.  If you would like me to show more of that methodology, let 
     * me know and I can modify.  :)
     */
    
    @Test
    public void failedApiElectionQuery1() {
        Log.printDescription("Verify response when missing query param 'key' to Elections API "
                + "call.");
        Response response = ApiRequests.setUrl(BASE_URI, ELECTION_PATH).get();
        ApiResponse.printResponse(response);
        ApiResponse.verifyStatusCode(response, 403);
    }

    @Test
    public void failedApiElectionQuery2() {
        Log.printDescription("Verify response when pass empty query param 'key' to Elections API "
                + "call.");
        Response response = ApiRequests.setUrlWithQueryParams(BASE_URI, ELECTION_PATH, 
                buildKeyQueryParam("")).get();
        ApiResponse.printResponse(response);
        ApiResponse.verifyStatusCode(response, 400);
        ApiResponse.verifySingleContent(response, ERROR_JSONPATH, INVALID_KEY);
    }

    @Test
    public void failedApiElectionQuery3() {
        Log.printDescription("Verify response when pass invalid query param 'key' to Elections "
                + "API call.");
        Response response = ApiRequests.setUrlWithQueryParams(BASE_URI, ELECTION_PATH, 
                buildKeyQueryParam("invalid")).get();
        ApiResponse.printResponse(response);
        ApiResponse.verifyStatusCode(response, 400);
        ApiResponse.verifySingleContent(response, ERROR_JSONPATH, INVALID_KEY);
    }

    @Test
    public void failedApiElectionQuery4() {
        Log.printDescription("Verify response attempt to POST instead of GET to Elections API "
                + "call with no key.");
        Response response = ApiRequests.setUrl(BASE_URI, ELECTION_PATH).post();
        ApiResponse.printResponse(response);
        ApiResponse.verifyStatusCode(response, 404);
    }

    @Test
    public void failedApiElectionQuery5() {
        Log.printDescription("Verify response attempt to POST instead of GET to Elections API "
                + "call with empty key.");
        Response response = ApiRequests.setUrlWithQueryParams(BASE_URI, ELECTION_PATH, 
                buildKeyQueryParam("")).post();
        ApiResponse.printResponse(response);
        ApiResponse.verifyStatusCode(response, 404);
    }

    @Test
    public void failedApiElectionQuery6() {
        Log.printDescription("Verify response attempt to POST instead of GET to Elections API "
                + "call with valid key.");
        Response response = ApiRequests.setUrlWithQueryParams(BASE_URI, ELECTION_PATH, 
                buildKeyQueryParam(KEY)).post();
        ApiResponse.printResponse(response);
        ApiResponse.verifyStatusCode(response, 404);
    }

    @Test
    public void failedApiElectionQuery7() {
        Log.printDescription("Verify response attempt to PUT instead of GET to Elections API "
                + "call with valid key.");
        Response response = ApiRequests.setUrlWithQueryParams(BASE_URI, ELECTION_PATH, 
                buildKeyQueryParam(KEY)).put();
        ApiResponse.printResponse(response);
        ApiResponse.verifyStatusCode(response, 404);
    }

    @Test
    public void validApiElectionQuery1() {
        Log.printDescription("Verify response when have valid query param 'key' attached to "
                + "Elections API call.");
        Response response = ApiRequests.setUrlWithQueryParams(BASE_URI, ELECTION_PATH, 
                buildKeyQueryParam(KEY)).get();
        ApiResponse.printResponse(response);
        ApiResponse.verifyStatusCode(response, 200);
        ApiResponse.verifyCountGreaterThanZero(response, ELECTIONS_JSONPATH);
    }
    
}
