package io.swagger.client;

import io.swagger.client.api.*;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Made by Gavryuskin S.I. 28.07.2019 23:04
 */
public class Main {
    private static  ApiClient defaultClient = Configuration.getDefaultApiClient();
    public static void main(String[] args) {
        defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey("odT-mosirJjliY_cJ14FUZU7");

       //user("1564489167");
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
        apiSignature.setApiKey("73fa98ee8401113591f25e397e9655969f8dcfa3f51292809869458473a2473a");
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey("1564489167");
        PositionApi apiInstance = new PositionApi();
        String filter = null; // String | Table filter. For example, send {\"symbol\": \"XBTUSD\"}.
        String columns = null; // String | Which columns to fetch. For example, send [\"columnName\"].
        BigDecimal count = null; // BigDecimal | Number of rows to fetch.
        try {
            List<Position> result = apiInstance.positionGet(filter, columns, count);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PositionApi#positionGet");
            e.printStackTrace();
        }
    }
    private static void user(String time){
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
      apiSignature.setApiKey("a5302e0341342a95351ec428e373525b2a3ab9b3f6c2a34b83102c7249d09659");
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey("1564489167");
        UserApi apiInstance = new UserApi();
        try {
            User result = apiInstance.userGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#userGet");
            e.printStackTrace();
        }
    }
    private static void announcement(String time){
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
        apiSignature.setApiKey("f2fe97164d4be2f5981b50aa11713efc8674f2ac42a1923d0d42af6a6e048930");
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey("1564489167");
        AnnouncementApi apiInstance = new AnnouncementApi();
        try {
            List<Announcement> result = apiInstance.announcementGetUrgent();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AnnouncementApi#announcementGetUrgent");
            e.printStackTrace();
        }
    }
    private static void position(String time){
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
        apiSignature.setApiKey("73fa98ee8401113591f25e397e9655969f8dcfa3f51292809869458473a2473a");
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey("1564489167");
        PositionApi apiInstance = new PositionApi();
        String filter = "{\"symbol\": \"XBTM15\"}"; // String | Table filter. For example, send {\"symbol\": \"XBTUSD\"}.
        String columns = null; // String | Which columns to fetch. For example, send [\"columnName\"].
        BigDecimal count = null; // BigDecimal | Number of rows to fetch.
        try {
            List<Position> result = apiInstance.positionGet(filter, columns, count);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PositionApi#positionGet");
            e.printStackTrace();
        }
    }
}
