package Daiigr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties prop;
    private FileInputStream ip;
    private FileOutputStream output;
    private File config;

    public Config(String fileName) throws IOException{
    prop=new Properties();
    config = new File(fileName);

        if(config.isFile()){
            ip= new FileInputStream(config.getAbsolutePath());
            prop.load(ip);
            System.out.println("Token:" + prop.getProperty("TOKEN"));

        }else{
            System.out.println("Config.properties does not exist");
            if(config.createNewFile()){
                System.out.println("config file created. Token Required");
            }
        
            output = new FileOutputStream(config.getAbsolutePath());
            prop.setProperty("TOKEN","null");
            prop.store(output,null);
        }
    }
    public String getToken(){
        return prop.getProperty("TOKEN");

    }
    public void setToken(String value){
        prop.setProperty("TOKEN", value);
    }
}