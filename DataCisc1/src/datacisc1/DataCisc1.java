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
        x.setData("01/01/1904");
        long d = x.dataDias();
    }
    
}

class Data
{
    int component[] = {0, 0, 0};
    static int formato = 0;
    static int termos[] = {0, 1, 2};  
    static char separador[] = {'.', '/', '-'};
  
    int diasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
        
    public boolean setData(String data)
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
       
       return consistData();
    }
    
    public long dataDias() {
            
        /* 
        01/01/1900 
        
        dia0 = 01
        mes0 = 01
        ano0 = 1900
        
        01/01/1905
        
        dia1 = 01
        mes1 = 01
        ano1 = 1905
        
        dia = 01 - 01 = 0 + 1 = 1
        mes = 01 - 01 = 0 + 1 = 1
        ano = 1905 - 1900 = 5 = 5
        
        Dias = dias + mes * 
        */
        
        int diasEntreDatas = 0;
        
        int Ano = component[2] - 1900;
        int Mes = component[1];
        int Dia = component[0];
        
        for(int i = 0; i < Ano; i++)
        {
            diasEntreDatas += (365 + bissexto(i+1900));
        }
        
        return diasEntreDatas;
        
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
