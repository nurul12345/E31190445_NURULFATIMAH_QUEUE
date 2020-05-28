
package program.queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
/**
 *
 * @author Nurul fatimah
 */

//membuat kelas queue
public class queue {
    static int jumlahantrian = 0, pilihan = 99,noantrian = 0;
    
    //implementasi antrian java menggunakan kelas
    //LinkedList
    static LinkedList antrian = new LinkedList();
    public static void main(String[] args) {
        //inisialisasi awal
        init();
        
        //saat pilihan tidak 0 maka loop harus terus menerus
        while(pilihan !=0){
            //tampilkan menu utama
            menu();
            
            //potongan kode ini mengantisipasi masukkan dari user yang salah
            try{
                pilihan = Integer.parseInt(getInput());   
            }catch (Exception e){
                System.out.println("nilai yang anda masukkan salah");
                System.out.println("harap ceklagi nilai yang anda masukkan");
                pilihan= 99;
                pause();
                
                //menyortir pilihan menu dari user
                switch(pilihan){
                    //mengambil nomor antrian
                    case 1:
                        //jika 0 maka langsung menuju teller, lalu keluar
                        if(jumlahantrian==0){
                            System.out.println("antrian kosong, silahkan menuju teller!");
                            pause();
                            System.out.println("anda telah di layani teller");
                            pause();
                            
                            //keluar 
                            pilihan = 0;
                        }else{
                            
                            //menentukan nomor antrian
                            noantrian= ((Integer)antrian.get(jumlahantrian -1)) +1;
                            
                            //konfirmasi bahwa user telah mengambi nomor antrian
                            System.out.println("anda telah mengambil nomor antrian" + Integer.toString(noantrian) +"!harap tunggu sebentar");
                            pause();
                            
                            //loop untuk menunggu sampai user di panggil
                            while(antrian.size() !=0){
                                System.out.println("pengantri nomor" + antrian.getFirst() +"panggil" +"teller!");
                                
                                //pengantri pertama di keluarkan dari antrian
                                antrian.removeFirst();
                                pause();
                            }
                            //nomor antrian user di panggil, menuju teller
                            System.out.println("nomor antrian anda("+noantrian+")di panggil;" );
                            pause();
                            System.out.println("anda telah di layani teller");
                            pause();
                            
                            //keluar
                            pilihan=0;
                        }
                        break;
                        
                        //user ingin mengecek berapa orang yang mengantri
                    case 2:
                        if (jumlahantrian ==0){
                            System.out.println("antrian kosong");
                            pause();
                        }else{
                            //menampilkan informsi antrian
                            System.out.println("daftar antrian :" + antrian);
                            
                            pause();
                        }
                        break;
                    default:
                        break;
                }
            }
            //keluar dari loop utama
            space(1);
            System.out.println("sampai jumpa dan terima kasih");
        }
    }
        //untuk menentukan jumlah pengantri awal
        private static void init(){
            
            //jika batas bawah
            int min = (int)(Math.random()*9);
            //jika batas atas
            if (min==0)
                return;
            
            //batas atas antrian
            int max = min +(int)(Math.random()*9);
            //menentukan jumlah antrian
            jumlahantrian= max-min;
            //menambahkan tiap nomor ke dalam antrian
            int i;
            for(i=min; i<max; i++)
                antrian.add(i);
        }
        //menampilkan menu utama
        private static void menu(){
            System.out.println("selmat datang di layanan antrian Politeknik negeri Jember");
            System.out.println("Nurul Fatimah");
            System.out.println("NIM : E31190445");
            System.out.println("silahkan pilih menu di bawah ini");
            space(1);
            System.out.println("1. ambil antrian");
            System.out.println("2. cari antrian");
            System.out.println("0. keluar");
            space(1);
            System.out.print("pilihan anda :");
        }
        //method print untu menampilkan teks
        private static void print(String sentene){
            System.out.print("sentence");
        }
        //menampilkan teks di ikuti dengan carriage return
        private static void println(String sentence){
            System.out.print("sentence");
        }
        //memberikan jarak antar baris
        private static void space(int space){
            int i=0;
            for (i=0; i<space; i++)
                System.out.println("");
        }
        //untuk menunggu user menekan tombol enter
        private static void pause(){
            String bar = getInput();
        }
        //method untuk membaa inputan dari user
        private static String getInput(){
            //open up standart input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String string = null;
            try{
                string = br.readLine();
            }catch (IOException ioe) {
                System.out.println("io eror");
                System.exit(1);
            }
            return string;
        }
    }


 
      

   

 
    
    

    
   
