package pages.controllers;

import java.util.ArrayList;
import exceptions.MessageException;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import items.ItemClass;
import pages.MainPage;
import java.text.SimpleDateFormat;
import java.util.Date;
import users.*;

public class MainController {
    
    /** 
     * @param database
     */
    // Metoda na serializaciu databazy
    public static void save(ArrayList<ItemClass> database) {
        try {
            // ArrayList zmenime na pole aby sme mohli serializovat
            ItemClass[] items = database.toArray(new ItemClass[database.size()]);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.out"));
            out.writeObject(items);
            out.close();
            new MessageException("Items saved");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    
    /** 
     * @param user
     */
    // Metoda na deserializaciu databazy
    public static void load(UserClass user) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.out"));
            ItemClass[] temp = (ItemClass[]) in.readObject();
            in.close();
            // Nahradenie databazy novou
            // Pridanie novych predmetov do databazy
            ArrayList<ItemClass> tempList = new ArrayList<>();
            for (ItemClass loopItem : temp) {
                tempList.add(loopItem);
            }
            new MainPage(user, tempList);
            new MessageException(temp.length + " items loaded");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    
    /** 
     * @return String
     */
    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}
