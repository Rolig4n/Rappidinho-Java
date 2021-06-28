/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fbrcmmelo
 */
public class Conversoes {
    
     public static Date converterData(String data){
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        
        if (data != null && !data.trim().equals("")){
            try{
                return fmt.parse(data);
            } catch (Exception ex){
                System.out.println("Problemas ao converter data! Erro: " + ex.getMessage());
                ex.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
        
    }
    
}
