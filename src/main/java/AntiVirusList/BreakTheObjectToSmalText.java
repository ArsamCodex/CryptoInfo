package AntiVirusList;

import org.apache.commons.lang.StringUtils;


public class BreakTheObjectToSmalText {

    //public int counter_x = 0;


    public String[] split_into_substrings(String crypto_data) {
        String[] crypto_data_2d_array = new String[2];

        String crypto_data_string = " " + crypto_data;


        // Hier im splliting object into 2 pieces
        String crypto_price_btc = StringUtils.substringBetween(crypto_data_string, "price\":\"", "\"}");


        crypto_data_2d_array[1] = crypto_price_btc;


        GetURLContent.i("price_btc = " + crypto_price_btc);
//        GetURLContent.i("24h_volume_usd = " + crypto_24h_volume_usd);


        //counter_x++;


        return crypto_data_2d_array;
    }
   /*
    public void print_2d_array ()
   {
       for (int i = 0; i < crypto_data_2d_array.length; i++)
       {
            GetURLContent.d(crypto_data_2d_array[i][0] + ": ");
            for (int j = 1; j < crypto_data_2d_array[i].length; j++)
            {
              GetURLContent.d(crypto_data_2d_array[i][j] + " ");
            }
       }
   }

    */

}
