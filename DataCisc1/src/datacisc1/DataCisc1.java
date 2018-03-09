/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacisc1;

/**
 *
 * @author ViniO
 */
public class DataCisc1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Data x = new Data();
        x.setData("35/05/1995");
    }
    
}

class Data
{
    int component[] = {0, 0, 0};
    static int formato = 0;
    static int termos[] = {0, 1, 2};  
    static char separador[] = {'.', '/', '-'};
    
        
    public void setData(String data)
    {
       for(int i = 0; i< 3; i++)
       {
        if(data.charAt(2) == separador[i])
        {
            component[0] = Integer.parseInt(data.substring(0, 2));
            component[1] = Integer.parseInt(data.substring(3, 5));
            component[2] = Integer.parseInt(data.substring(6, 10));
            break;
        }
       }
       if(data.charAt(4) == separador[0])
        {
            component[2] = Integer.parseInt(data.substring(0, 4));
            component[1] = Integer.parseInt(data.substring(5, 7));
            component[0] = Integer.parseInt(data.substring(8, 10));
        }
       
       boolean consist = consistData();
    }
    
    private boolean consistData()
    {
        boolean consistMes = component[1] < 13 && component[1] > 0;
        boolean consistAno = component[2] > 1900 && component[2] < 2100;
        
        if(!consistMes)
            return false;
        if(!consistAno)
            return false;
        
        if(component[1] == 1 || component[1] == 3 || component[1] == 5 || component[1] == 7 || component[1] == 8 || component[1] == 10 || component[1] == 12)
        {
                if(component[0] > 0 && component[0] < 32)
                        return true;
        }
        if(component[1] == 4 || component[1] == 6 || component[1] == 9 || component[1] == 11 )
        {
                if(component[0] > 0 && component[0] < 31)
                        return true;
        }
        if(component[1] == 2)
        {
                if(component[0] > 0 && component[0] < (29 + bissexto(component[2])))
                        return true;
        }

        return false;
    }
    
    public int bissexto(int ano)
    {
        if((ano%4 == 0) && (ano%100 != 0) || (ano%400 == 0))
        {
            return 1;
        }
        return 0;
    }
}
