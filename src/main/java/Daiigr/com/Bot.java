package Daiigr.com;

import java.awt.Color;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.*;

import Daiigr.Config;
import Daiigr.FileList;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;




public class Bot extends ListenerAdapter{

    private static Config config;
    private static String[] temp;
    private static FileList nonUser;
    private static FileList nonWord;
        
public static void main(String[] args) throws Exception{
    try {
       // config = new Config("config.properties");
       // JDABuilder.createDefault(config.getToken())
       // .addEventListeners(new Bot())
       // .setActivity(Activity.playing("Anna Simulator(v.2)"))
       // .build();

     

OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
   .url("https://www.boredapi.com/api/activity?type=social")
   .build(); // defaults to GET

Response response = client.newCall(request).execute();

String jsonString = response.body().string();
JSONObject obj = new JSONObject(jsonString);
String activity = obj.getString("activity");
System.out.println(activity);

    } catch (Exception e) {
        e.printStackTrace();
       // System.out.print("invalid Token: " + config.getToken());
    }

}

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        Message msg = event.getMessage();
       temp = msg.getContentRaw().toLowerCase().split(" ");   

      


        
              }      
    }

    

