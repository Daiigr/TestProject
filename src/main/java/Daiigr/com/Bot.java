package Daiigr.com;

import java.awt.Color;
import java.io.IOException;

import javax.swing.event.SwingPropertyChangeSupport;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    private String temp;

        
public static void main(String[] args) throws Exception{
    try {
       config = new Config("config.properties");
        JDABuilder.createDefault(config.getToken())
        .addEventListeners(new Bot())
        .setActivity(Activity.playing("test"))
        .build();

     


    } catch (Exception e) {
        e.printStackTrace();
      
    }

}
    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        Message msg = event.getMessage();

       temp = msg.getContentRaw().toLowerCase(); 

       if(temp.toLowerCase().equals("-activity")){

        MessageChannel channel = event.getChannel();

        try {

            channel.sendMessage(getActivity()).queue();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }  

      


        
              }      

              public String getActivity() throws IOException{

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()

                   .url("https://www.boredapi.com/api/activity")
                   .build(); // defaults to GET
                
                Response response = client.newCall(request).execute();
                
                String jsonString = response.body().string();

                JSONObject obj = new JSONObject(jsonString);
                String activity = obj.getString("activity");
                System.out.println(activity);
                
            
                  return activity;
              }
    }

    

