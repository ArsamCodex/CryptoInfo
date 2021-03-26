package AntiVirusList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetURLContent {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void i(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

//    public static void d(String message) {
//        System.out.println(ANSI_BLUE + message + ANSI_RESET);
//    }
//
//    public String[] GetURLContent(URL url_passed) {
//        //System.out.println(""+url_passed);
//        URL url;
//        String inputLine = "";
//        String Buffered_string_captured = "";
//
//        String[] data_crypto_coins_2d_array = new String[1];
//
//        try {
//            // get URL content
//            url = url_passed;
//            //url = new URL("https://api.coinmarketcap.com/v1/ticker/bitcoin/");
//            URLConnection conn = url.openConnection();
//
//            // open the stream and put it into BufferedReader
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//
//
//            crypto_data_string_into_substring data_crypto = new crypto_data_string_into_substring();
//
//
//            while ((inputLine = br.readLine()) != null) {
//                //GetURLContent.i(inputLine);
//                Buffered_string_captured = Buffered_string_captured + inputLine;
//
//            }
//
//            br.close();
//            //GetURLContent.d(Buffered_string_captured);
//            data_crypto_coins_2d_array = data_crypto.split_into_substrings(Buffered_string_captured);
//            //System.out.println("\n---------------------------------------\n");
//
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return data_crypto_coins_2d_array;
//
//    }
}