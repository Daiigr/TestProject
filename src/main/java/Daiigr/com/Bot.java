package Daiigr.com;

import java.awt.Color;
import java.io.IOException;

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
        nonUser = new FileList("BlacklistedUsers.txt");
        nonWord = new FileList("BlacklistedWords.txt");

        config = new Config("config.properties");

        JDABuilder.createDefault(config.getToken())
        .addEventListeners(new Bot())
        .setActivity(Activity.playing("Anna Simulator(v.2)"))
        .build();

    } catch (Exception e) {
        System.out.print("invalid Token: " + config.getToken());
    }

}

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        Message msg = event.getMessage();
       temp = msg.getContentRaw().toLowerCase().split(" ");   
       try {
        if(temp[0].equals("%block")&& !nonUser.doesExist(msg.getAuthor().getId())){
               try {
                nonUser.AddItem(temp[1]);
               } catch (Exception e) {

                MessageChannel channel = event.getChannel();
                channel.sendMessage("Error Detected: " + e.toString()).queue();
                   
            
               }


            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("BLOCKING USER: " + temp[1], null);
            eb.setColor(Color.red);
            eb.setDescription("User: " + temp[1] + " has been blacklisted from using Arsonist Bot Commands" );  
            MessageChannel channel = event.getChannel();
            channel.sendMessage(eb.build()).queue();

               System.out.println("blocking: " + temp[1]);

           }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }        }      
    }

    

