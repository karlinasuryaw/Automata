/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfa_kelompok1;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class main {
    public static void main (String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        //inisialisasi
        String var;
        int pilihan;
        char FinalState[] = new char[5];
        boolean loop = true;
        while(loop){
            char StartState = 'A'; //state awal
            System.out.print("- IMPLEMENTASI DFA -\n");
            System.out.println("[1] Himpunan semua string yang mengandung substring 101\n"
                    + "[2] Himpunan semua string yang mengandung prefiks 101\n"
                    + "[3] Himpunan semua string yang mengandung sufiks 101\n"
                    + "[4] Himpunan semua string yang mengandung jumlah simbol 0 genap\n"
                    + "[5] Himpunan semua string yang mengandung jumlah simbol 1 ganjil");
            System.out.print("Masukkan pilihan : ");
            pilihan = Integer.parseInt(in.nextLine()); //harus menggunakan parse Integer agar tidak error, jika memakai nextInt akan error
            System.out.print("String yang diuji : ");
            //var = in.nextLine();
            boolean inputSalah;
            do{
                //proses untuk mengecek input dari user
                var = in.nextLine();
                inputSalah = false;
                for(int i=0; i<var.length(); i++)
                    if(var.charAt(i) != '0' && var.charAt(i) != '1'){
                        System.out.print("Inputan Invalid, Silahkan Ulang Input : ");
                        //proses ini akan terus berulang hingga inputan user sudah sesuai yaitu hanya mengandung 1 dan 0
                        inputSalah = true;
                        break;
                    }
            }while(inputSalah);
            switch(pilihan){
                case 1 :
                    FinalState[0] = 'D'; //inisialisasi final state sesuai hasil yg dicari secara manual
                    L1 l1 = new L1(); //memanggil fungsi L1
                    StartState = l1.deltaTopi(var, StartState); //memindah/mengubah startState sesuai dengan inputan user
                    if(new String(FinalState).indexOf(StartState) != -1) //ngecek apakah StartState dengan final state sama, jika iya maka string VALID
                        System.out.println("String VALID ! ");
                    else
                        System.out.println("String INVALID ! ");
                    break;
                case 2 :
                    FinalState[0] = 'D';
                    L2 l2 = new L2();
                    StartState = l2.deltaTopi(var, StartState);
                    if(new String(FinalState).indexOf(StartState) != -1)
                        System.out.println("String VALID ! ");
                    else
                        System.out.println("String INVALID ! ");
                    break;
                case 3 :
                    FinalState[0] = 'D';
                    L3 l3 = new L3();
                    StartState = l3.deltaTopi(var, StartState);
                    if(new String(FinalState).indexOf(StartState) != -1)
                        System.out.println("String VALID ! ");
                    else
                        System.out.println("String INVALID ! ");
                    break;
                case 4 :
                    FinalState[0] = 'A';
                    FinalState[1] = 'C';
                    L4 l4 = new L4();
                    StartState = l4.deltaTopi(var, StartState);
                    if(new String(FinalState).indexOf(StartState) != -1)
                        System.out.println("String VALID ! ");
                    else
                        System.out.println("String INVALID ! ");
                    break;
                case 5 :
                    FinalState[0] = 'B';
                    L5 l5 = new L5();
                    StartState = l5.deltaTopi(var, StartState);
                    if(new String(FinalState).indexOf(StartState) != -1)
                        System.out.println("String VALID ! ");
                    else
                        System.out.println("String INVALID ! ");
                    break;
                default :
                    System.out.println("Pilihan Salah");
                    break;
            }
            System.out.print("Ingin ulang program? (y/n): ");//mengecek apakah user ingin mengulang program atau tidak
            String ulang = in.nextLine();
            switch(ulang){
                case "y":
                case "Y":
                    loop = true;
                    break;
                case "n":
                case "N":
                    loop = false;
                    break;
            }
        }
    }
}
