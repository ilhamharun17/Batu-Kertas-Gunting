package org.main;

import java.util.Random;
import java.util.Scanner;

/**
 * Kelas Game untuk memainkan permainan batu, kertas, gunting antara pengguna dan komputer.
 * Pemain akan memilih salah satu dari tiga pilihan, dan komputer akan memilih secara acak.
 * Kelas ini menentukan pemenang berdasarkan aturan permainan.
 */
public class Game {

    private static final String[] CHOICE = {"batu", "kertas", "gunting"};

    /**
     * Metode utama yang menjalankan permainan.
     * Mengambil input dari pengguna, menghasilkan pilihan komputer,dan menentukan pemenang.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan pilihan Anda (batu, kertas, gunting): ");
        String userChoice = scanner.nextLine().toLowerCase();

        String computerChoice = generateComputerChoice();
        System.out.println("Komputer memilih: " + computerChoice);

        String result = winner(userChoice, computerChoice);
        System.out.println("Hasil: " + result);
    }

    /**
     * Menghasilkan pilihan acak untuk komputer.
     *
     * @return pilihan yang dipilih oleh komputer
     */
    private static String generateComputerChoice() {
        Random random = new Random();
        return CHOICE[random.nextInt(CHOICE.length)];
    }

    /**
     * Menentukan pemenang permainan berdasarkan pilihan pemain dan pilihan komputer.
     *
     * @param pemain pilihan yang dipilih oleh pemain
     * @param komputer pilihan yang dipilih oleh komputer
     * @return hasil permainan sebagai string ("Seri!", "Anda menang!", "Anda kalah!")
     */
    private static String winner(String pemain, String komputer) {
        if (pemain.equals(komputer)) {
            return "Seri!";
        } else if ((pemain.equals("batu") && komputer.equals("gunting")) ||
                (pemain.equals("kertas") && komputer.equals("batu")) ||
                (pemain.equals("gunting") && komputer.equals("kertas"))) {
            return "Anda menang!";
        } else {
            return "Anda kalah!";
        }
    }
}