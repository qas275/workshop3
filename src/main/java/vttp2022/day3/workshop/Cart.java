package vttp2022.day3.workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Cart {
    private List<String> contents = new LinkedList<>();
    private String username;

    public Cart(String name){
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void add(String item){
        for(String inCart: contents)
            if(inCart.equals(item))
                return;
        contents.add(item);
    }
    
    public String delete(int index){
        if( index < contents.size())
            return contents.remove(index);//if one line of code no need {}, the next line will run the else condition
        return "nothing";//else condition
    }
    //MEMORISE THE BELOW 2 METHODS
    //read file but need choose correct reader to read the stream
    public void load(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is);//raw file reading
        BufferedReader br = new BufferedReader(isr);//actual content line by line reading
        String item;
        while((item = br.readLine()) != null) //read until end of file using null
            contents.add(item);
        br.close();
        isr.close();//must close in reverse order of readers!!!
    }

    public void save(OutputStream os) throws IOException{
        OutputStreamWriter ows = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(ows);//pass the info to write from previous writer
        for(String item: contents)
            bw.write(item + "\n");

        ows.flush();//output no need for first in last out to close but good to follow
        bw.flush();
        bw.close();
        ows.close();
    }

    public List<String> getContents(){
        return contents;
    }
}