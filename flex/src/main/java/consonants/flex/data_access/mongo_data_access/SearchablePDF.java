package consonants.flex.data_access.mongo_data_access;


import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

public class SearchablePDF{

    private final String base64PDF;
    String url = "https://api.ocr.space/parse/image"; // OCR API Endpoints

        public SearchablePDF(String base64PDF) {

            this.base64PDF = base64PDF;
        }

    public String sendPost() throws Exception {
        System.out.println("In sendPost()");

        URL obj = new URL(url); // OCR API Endpoints
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


        JSONObject postDataParams = new JSONObject();

        postDataParams.put("apikey", "K88786854088957");//TODO: add to .env file
        postDataParams.put("isOverlayRequired", false);
        //TODO: hard-code base64 for now since postman is messing up the format
        postDataParams.put("base64Image", "data:application/pdf;" + base64PDF);
        //postDataParams.put("OCREngine", "2");
        postDataParams.put("isCreateSearchablePdf", true);
        postDataParams.put("isSearchablePdfHideTextLayer", true);


        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(getPostDataString(postDataParams));
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // convert response to a JSONObject to extract the url via a key query
        JSONObject urlField = new JSONObject(String.valueOf(response));
        System.out.println(urlField.get("SearchablePDFURL").toString());
        return urlField.get("SearchablePDFURL").toString();
    }


    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while (itr.hasNext()) {

            String key = itr.next();

            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }

        return result.toString();
    }
}