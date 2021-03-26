package AntiVirusList;


import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller

public class MainController {
    //COINMARKETECAP PRIVATE API KEY
    static String apiKey = "b4666977-739e-47bd-8ad6-02ad69bfd85f";


    @GetMapping("/")
    public String Home(@RequestParam(value = "tall1", required = false) String tall1,


                       @RequestParam(value = "mathType", required = false) String mathType, Model model) throws Exception {

        if (tall1 != null && mathType != null) {
            switch (tall1) {
                case "binance":


                    model.addAttribute("svar", getUrlContents(tall1));


//                    String shutdownCmd = "shutdown -s";

                    break;
                case "coinmarketcap":
                    String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
                    List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
                    paratmers.add(new BasicNameValuePair("start", "1"));
                    paratmers.add(new BasicNameValuePair("limit", "5"));
                    paratmers.add(new BasicNameValuePair("convert", "USD"));

                    makeAPICall(uri,paratmers);
                    System.out.println(makeAPICall(uri,paratmers));
                    model.addAttribute("svar",getUrlContentsCMC(tall1));

                default:
                    break;
            }
        }
        return "index";


    }
    // RESTFUL ENDPOINT TO RETRIVE DATA
    @GetMapping("coinmarketcap")
    public ResponseEntity<String> binance(@RequestParam String info) throws IOException {
        if(info.equals("BTC")){
//            getUrlContentsCMC(info);
            getUrlContents(info);

            System.out.println("GARANTED , BITCOIN PRICE IN DOLLAR");

            return ResponseEntity.ok(getUrlContents(info));


        }
        else if(info.equals("ETH")){
            getUrlContentsETH(info);
            System.out.println("ETHEREUM DATA GARANTED");
            return ResponseEntity.ok(getUrlContentsETH(info));


        }
        return ResponseEntity.ok("ITS 200 OK EVERYTHINGDS FINE");
    }




    private static String getUrlContents(String theUrl) throws IOException {
        URL uri = new URL("https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT");
        URLConnection ec = uri.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                ec.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        System.out.println(a.toString());
        return a.toString();

    }
    private static String getUrlContentsCMC(String theUrl) throws IOException {
        URL uri = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest");
        URLConnection ec = uri.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                ec.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        System.out.println(a.toString());
        return a.toString();

    }

    public static String makeAPICall(String uri, List<NameValuePair> parameters)
            throws URISyntaxException, IOException {
        String response_content = "";

        URIBuilder query = new URIBuilder(uri);
        query.addParameters(parameters);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());

        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", apiKey);

        CloseableHttpResponse response = client.execute(request);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            response_content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return response_content;
    }
    private static String getUrlContentsETH(String theUrl) throws IOException {
        URL uri = new URL("https://api.binance.com/api/v3/ticker/price?symbol=ETHUSDT");
        URLConnection ec = uri.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                ec.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        System.out.println(a.toString());
        return a.toString();

    }


}




//    public void getDataFromApi(String exchange) throws IOException {
//
//        URL url = new URL("https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT");
//        URLConnection con = url.openConnection();
//
//        con.setDoOutput(true); // we want the response
//        con.setRequestProperty("Cookie", "myCookie=test123");
//        con.connect();
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//
//        StringBuilder response = new StringBuilder();
//        String inputLine;
//
//        String newLine = System.getProperty("line.separator");
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine + newLine);
//        }
//
//        in.close();

//    }

