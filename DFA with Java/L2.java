/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_kelompok1;

/**
 *
 * @author ASUS
 */
public class L2 {
    //fungsi delta
    private char delta(char st, char var){
        switch(st){
            case 'A' : //berguna untuk mendefinisikan setiap state pada L2 beserta transisinya
                switch(var){
                    case '1' : 
                        return 'B';
                    case '0' : 
                        return 'E';
                }
            case 'B' :
                switch(var){
                    case '1' : 
                        return 'E';
                    case '0' : 
                        return 'C';
                }
           case 'C' :
                switch(var){
                    case '1' : 
                        return 'D';
                    case '0' : 
                        return 'E';
                }
            case 'D' :
                switch(var){
                    case '1' : 
                    case '0' : 
                        return 'D';
                }
            case 'E' :
                switch(var){
                    case '1' : 
                    case '0' : 
                        return 'E';
                }
        }
        return 0;
    }
    //fungsi delta topi
    public char deltaTopi(String var, char State)
    {
        int pKata = var.length()-1; //variabel pKata berguna untuk menyimpan jumlah karakter yang diinput user
        if(pKata <= 0) //pengecekan posisi apabila sudah berada pada karakter paling awal
            return delta(State, var.charAt(0)); //jika sudah ketemu epsilon (karakter paling awal)
        State = deltaTopi(var.substring(0, pKata), State); //proses rekursif karakter sebelum karakter akhir
        return delta(State, var.charAt(pKata)); //proses menyelesaikan karakter akhir
        
    }
}
