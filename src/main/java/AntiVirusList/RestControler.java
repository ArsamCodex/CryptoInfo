package AntiVirusList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class RestControler {
    
    // TODO THIS IS REST INFO CLASS ITS AN API FOR REQUESTS AND RESPONSE AS PRICE AND MORE
    
    // FOR NOW FIRST TOP 5 

    @GetMapping("coinmarketcap")
    public ResponseEntity<String> binance(@RequestParam String info) throws IOException {
        if(info.equals("BTC")){
//            getUrlContentsCMC(info);


            System.out.println("GARANTED , BITCOIN PRICE IN DOLLAR");




        }
        else if(info.equals("ETH")){

            System.out.println("ETHEREUM DATA GARANTED");
            


        }
        return ResponseEntity.ok("ITS 200 OK EVERYTHINGDS FINE");
    }

}
