/**
 * 
 */
package livesmart.com.messaging;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;

import livesmart.com.dataModel.Notification;

/**
 * @author Dominik Poppek
 *
 */
public class FCMNotification {

    //FCM-Serverkey
    public final static String AUTH_KEY_FCM = "AAAAYREccG8:APA91bGu38HFsSbP43HA-6FJ8fsWB2ZcyroUY_B9D0tURq5moGEULwZBmis3_y5pfRZzOqjhLE7JEeUyKwSvv3MXLZxUcjEAV6mQDa7GGTjQBswYKugQNTLSCkb1-qQAwPdRRLPbWCNW";
    //FCM-URL
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    /**
     * Send notification from server to client via FCM
     * @param firebaseClientKey
     * @throws Exception
     */
    public void pushFCMNotification(String firebaseClientKey, Notification notification) throws Exception {


        URL url = new URL(API_URL_FCM);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject data = buildJSONObject(firebaseClientKey, notification);
        
        System.out.println(data.toString());

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data.toString());
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        //TODO if OK, save notification in db!

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        conn.disconnect();
   	}
    
    /**
     * Creates JSON-Object containing client-destination + notification data
     * @param n
     * @param firebaseClientKey
     * @return
     */
    private JSONObject buildJSONObject(String firebaseClientKey, Notification notification) throws Exception {
    	//Destination
    	JSONObject messageJSON = new JSONObject();
    	messageJSON.put("to", firebaseClientKey.trim());
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //if notification with body, title, icon is needed
//        JSONObject notificationJSON = new JSONObject();
  //      notificationJSON.put("title", "LiveSmart-Notification");
    //    notificationJSON.put("body", notification.getNotificationText());
      //  messageJSON.put("notification", notificationJSON);
        
        JSONObject dataJSON = new JSONObject(mapper.writeValueAsString(notification));
        messageJSON.put("data", dataJSON);
        
        
        return messageJSON;
    }
}