package Soal2;

import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {

        QueueLL<String> queue = new QueueLL<>();
        Scanner s = new Scanner(System.in);
        boolean run = true;

        while(run) {
            System.out.println("Pilih operasi: \n1. Tambahkan tugas \n2. Tampilkan tugas pertama \n3. Hapus tugas \n4. Tampilkan seluruh isi to-do list \n5. keluar");
            int pilihan = s.nextInt();
            s.nextLine();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan nama tugas: ");
                    String tugas = s.nextLine();

                    queue.enqueue(tugas);
                    System.out.println("Tugas " + tugas + " berhasilkan ditambahkan ke to-do list");
                break;
                case 2:
                    queue.printTugas1();
                break;
                case 4:
                    if(queue.isEmpty()) {
                        System.out.println("To-Do list kosong");
                    } else {
                        queue.printQueue();
                        System.out.println();
                    }  
                break;
                case 3:
                    if(queue.isEmpty()) {
                        System.out.println("To-Do list kosong");
                    } else {
                        String hapus = queue.dequeue();
                        // queue.dequeue();
                        System.out.println("Tugas " + hapus + " telah selesai dikerjakan");
                    }
                break;
                case 5:
                    s.close();
                    run = false;
                break;
            }
        }
    }
}