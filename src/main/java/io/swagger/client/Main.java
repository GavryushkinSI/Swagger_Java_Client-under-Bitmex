package io.swagger.client;

import io.swagger.client.api.*;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.*;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Made by Gavryuskin S.I. 28.07.2019 23:04
 */
public class Main {
    private static ApiClient defaultClient = Configuration.getDefaultApiClient();
    //       private final static String idKey="odT-mosirJjliY_cJ14FUZU7";
//   private final static String key="Ph1D3HeaNIgDcBi3SacqD0Ojt35elX-kDxjrwwFW51r1VyDY";
//    private final static String idKey = "RsuWjKfVgMT8yS4KWGNeXwMw";
//   private final static String key = "a5hHFdvB6Z-aDFnkMb9j0FrxppGnacBVe_30uDLhCVXllz1v";
    private final static String idKey = "v0_GfasE_fVwbOEX5_PtTiPC";
    private final static String key = "6Z87UN9hJK-2jFnp-mgBlnznBPmOfHz7kKxvCb7t87MmjcBj";
    //private final static String idKey="LAqUlngMIQkIUjXMUreyu3qn";
//private final static String key="chNOOS4KvNXR_Xq4k4c9qsfoKWvnDecLATCRlcBwyKDYnWgO";
    private static String method = "";
    private static String data = "";
    private static String str = "";
    private static String body = "";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        //getpozition();
        user();
        //gethistory();
        //getorder();
        createorder();
    }

    private static void user() throws InvalidKeyException, NoSuchAlgorithmException {
        method = "GET";
        data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        str = "/api/v1/user";
        body = "";
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey(idKey);
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
        apiSignature.setApiKey(Hex.hmacSha256(method + str + data + body, key));
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey(data);
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(Long.parseLong(data) * 1000)));
        UserApi apiInstance = new UserApi();
        try {
            User result = apiInstance.userGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserApi#userGet");
            e.printStackTrace();
        }
    }

    private static void getpozition() throws InvalidKeyException, NoSuchAlgorithmException {
        method = "GET";
        data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        str = "/api/v1/position?filter=%7B%22symbol%22%3A%20%22XBTUSD%22%7D";
        body = "";
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey(idKey);
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
        apiSignature.setApiKey(Hex.hmacSha256(method + str + data + body, key));
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey(data);
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(Long.parseLong(data) * 1000)));
        PositionApi apiInstance = new PositionApi();
        String filter = "{\"symbol\": \"XBTUSD\"}"; // String | Table filter. For example, send {\"symbol\": \"XBTUSD\"}.
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

    private static void gethistory() throws InvalidKeyException, NoSuchAlgorithmException {
        method = "GET";
        data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        str = "/api/v1/execution/tradeHistory";
        body = "";
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey(idKey);
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
        apiSignature.setApiKey(Hex.hmacSha256(method + str + data + body, key));
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey(data);
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(Long.parseLong(data) * 1000)));
        System.out.println(method + str + data + body);
        ExecutionApi apiInstance = new ExecutionApi();
        String symbol = null; // String | Instrument symbol. Send a bare series (e.g. XBU) to get data for the nearest expiring contract in that series.  You can also send a timeframe, e.g. `XBU:monthly`. Timeframes are `daily`, `weekly`, `monthly`, `quarterly`, and `biquarterly`.
        String filter = null; // String | Generic table filter. Send JSON key/value pairs, such as `{\"key\": \"value\"}`. You can key on individual fields, and do more advanced querying on timestamps. See the [Timestamp Docs](https://www.bitmex.com/app/restAPI#Timestamp-Filters) for more details.
        String columns = null; // String | Array of column names to fetch. If omitted, will return all columns.  Note that this method will always return item keys, even when not specified, so you may receive more columns that you expect.
        BigDecimal count = null; // BigDecimal | Number of results to fetch.
        BigDecimal start = null; // BigDecimal | Starting point for results.
        Boolean reverse = null; // Boolean | If true, will sort results newest first.
        // OffsetDateTime | Ending date filter for results.
        try {
            List<Execution> result = apiInstance.executionGetTradeHistory(symbol, filter, columns, count, start, reverse, null, null);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ExecutionApi#executionGetTradeHistory");
            e.printStackTrace();
        }

    }

    public static void getorder() throws InvalidKeyException, NoSuchAlgorithmException {
        method = "GET";
        data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        str = "/api/v1/order";
        body = "";
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey(idKey);
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
        apiSignature.setApiKey(Hex.hmacSha256(method + str + data + body, key));
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey(data);
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(Long.parseLong(data) * 1000)));
        System.out.println(method + str + data + body);
        OrderApi apiInstance = new OrderApi();
        String symbol = null; // String | Instrument symbol. Send a bare series (e.g. XBU) to get data for the nearest expiring contract in that series.  You can also send a timeframe, e.g. `XBU:monthly`. Timeframes are `daily`, `weekly`, `monthly`, `quarterly`, and `biquarterly`.
        String filter = null; // String | Generic table filter. Send JSON key/value pairs, such as `{\"key\": \"value\"}`. You can key on individual fields, and do more advanced querying on timestamps. See the [Timestamp Docs](https://www.bitmex.com/app/restAPI#Timestamp-Filters) for more details.
        String columns = null; // String | Array of column names to fetch. If omitted, will return all columns.  Note that this method will always return item keys, even when not specified, so you may receive more columns that you expect.
        BigDecimal count = null; // BigDecimal | Number of results to fetch.
        BigDecimal start = null; // BigDecimal | Starting point for results.
        Boolean reverse = null; // Boolean | If true, will sort results newest first.
        //OffsetDateTime startTime = new OffsetDateTime(); // OffsetDateTime | Starting date filter for results.
        //OffsetDateTime endTime = new OffsetDateTime(); // OffsetDateTime | Ending date filter for results.
        try {
            List<Order> result = apiInstance.orderGetOrders(symbol, filter, columns, count, start, reverse, null, null);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrderApi#orderGetOrders");
            e.printStackTrace();
        }
    }

    public static void createorder() throws InvalidKeyException, NoSuchAlgorithmException {
        method = "POST";
        data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        str = "/api/v1/order";
        body = "{\"symbol\":\"XBTUSD\",\"orderQty\":1}";
        //body="{\"order\":\"hth|\"}";
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey(idKey);
        ApiKeyAuth apiSignature = (ApiKeyAuth) defaultClient.getAuthentication("apiSignature");
        apiSignature.setApiKey(Hex.hmacSha256(method + str + data + body, key));
        ApiKeyAuth apiExpires = (ApiKeyAuth) defaultClient.getAuthentication("apiExpires");
        apiExpires.setApiKey(data);
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(Long.parseLong(data) * 1000)));
        System.out.println(method + str + data + body);
        OrderApi apiInstance = new OrderApi();
        String symbol = "XBTUSD"; // String | Instrument symbol. e.g. 'XBTUSD'.
        String side = null; // String | Order side. Valid options: Buy, Sell. Defaults to 'Buy' unless `orderQty` or `simpleOrderQty` is negative.
        Double simpleOrderQty = null; // Double | Order quantity in units of the underlying instrument (i.e. Bitcoin).
        BigDecimal orderQty = new BigDecimal(1); // BigDecimal | Order quantity in units of the instrument (i.e. contracts).
        Double price = null; // Double | Optional limit price for 'Limit', 'StopLimit', and 'LimitIfTouched' orders.
        BigDecimal displayQty = null; // BigDecimal | Optional quantity to display in the book. Use 0 for a fully hidden order.
        Double stopPx = null; // Double | Optional trigger price for 'Stop', 'StopLimit', 'MarketIfTouched', and 'LimitIfTouched' orders. Use a price below the current price for stop-sell orders and buy-if-touched orders. Use `execInst` of 'MarkPrice' or 'LastPrice' to define the current price used for triggering.
        String clOrdID = null; // String | Optional Client Order ID. This clOrdID will come back on the order and any related executions.
        String clOrdLinkID = null; // String | Optional Client Order Link ID for contingent orders.
        Double pegOffsetValue = null; // Double | Optional trailing offset from the current price for 'Stop', 'StopLimit', 'MarketIfTouched', and 'LimitIfTouched' orders; use a negative offset for stop-sell orders and buy-if-touched orders. Optional offset from the peg price for 'Pegged' orders.
        String pegPriceType = null; // String | Optional peg price type. Valid options: LastPeg, MidPricePeg, MarketPeg, PrimaryPeg, TrailingStopPeg.
        String ordType = null; // String | Order type. Valid options: Market, Limit, Stop, StopLimit, MarketIfTouched, LimitIfTouched, MarketWithLeftOverAsLimit, Pegged. Defaults to 'Limit' when `price` is specified. Defaults to 'Stop' when `stopPx` is specified. Defaults to 'StopLimit' when `price` and `stopPx` are specified.
        String timeInForce = null; // String | Time in force. Valid options: Day, GoodTillCancel, ImmediateOrCancel, FillOrKill. Defaults to 'GoodTillCancel' for 'Limit', 'StopLimit', 'LimitIfTouched', and 'MarketWithLeftOverAsLimit' orders.
        String execInst = null; // String | Optional execution instructions. Valid options: ParticipateDoNotInitiate, AllOrNone, MarkPrice, IndexPrice, LastPrice, Close, ReduceOnly, Fixed. 'AllOrNone' instruction requires `displayQty` to be 0. 'MarkPrice', 'IndexPrice' or 'LastPrice' instruction valid for 'Stop', 'StopLimit', 'MarketIfTouched', and 'LimitIfTouched' orders.
        String contingencyType = null; // String | Optional contingency type for use with `clOrdLinkID`. Valid options: OneCancelsTheOther, OneTriggersTheOther, OneUpdatesTheOtherAbsolute, OneUpdatesTheOtherProportional.
        String text = null; // String | Optional order annotation. e.g. 'Take profit'.
        try {
            Order result = apiInstance.orderNew(symbol, null, null, orderQty, null, null, null, null, null, null, null, null, null, null, null, null);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrderApi#orderNew");
            e.printStackTrace();
        }
//        OrderApi apiInstance = new OrderApi();
//        Order order=new Order();
//        order.setSymbol("XBTUSD");
//        order.setOrderQty(new BigDecimal(1));
//        String orders = order.toString(); // String | An array of orders.
//        try {
//            List<Order> result = apiInstance.orderNewBulk(orders);
//            System.out.println(result);
//        } catch (ApiException e) {
//            System.err.println("Exception when calling OrderApi#orderNewBulk");
//            e.printStackTrace();
//        }
//    }

    }
}
