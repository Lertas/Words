/*Lertas Georgios icsd11084*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class easyhard {

    public static HashMap<String, String> words = new HashMap<String, String>();  //hashmap me lekseis kai perigrafes
    public static ArrayList<String> k = new ArrayList<>();         //arraylist pou krataei tis 3 random lekseis
    public Scanner in = new Scanner(System.in);
    public Random random = new Random();

    public easyhard(Integer choice) {

        String w1, w2, w3;         //dilonoume 3 metavlites gia tis 3 random lekseis
        int x, count = 1, c = 1;    //metavlti epilogis epipedou, counter gia prospathies paixti, counter gia gurous

        //eisodo lekseon sti hashmap
        words.put("upologistis", "Έχει οθόνη και ποντίκι");
        words.put("roloi", "Έχει ώρες και λεπτά");
        words.put("molibi", "Σχετικο με ξύστρα και γόμα");
        words.put("barka", "Είναι ξύλινο, ταξιδεύει στη θάλασσα");
        words.put("sokolata", "Είναι γλυκό και νόστιμο");
        words.put("mpanana", "Τροπικό φρούτο, πολύ ωφέλιμο, με πολλές βιταμίνες");
        words.put("xtapodi", "Μαλάκιο, δίχως καθόλου όστρακο");
        words.put("katsarida", "Βλαττοειδές έντομο");
        words.put("drepani", "Αγροτικό εργαλείο");

        //an h hashmap exei lekseis paei ston epomeno guro kai an oi prospathies einai panw apo 0
        while (count > 0 && !(words.isEmpty())) {

            //arraylist pou krataei oles tis lekseis pou exei i words
            ArrayList<String> keys = new ArrayList<>(words.keySet());

            //kratame 3 random lekseis
            w1 = keys.get(random.nextInt(keys.size()));
            w2 = keys.get(random.nextInt(keys.size()));
            w3 = keys.get(random.nextInt(keys.size()));

            //an oi lekseis einai idies vazei alles sti thesi tous
            while (w2.equals(w1) || w2.equals(w3)) {
                w2 = keys.get(random.nextInt(keys.size()));
            }
            while (w3.equals(w1) || w3.equals(w2)) {
                w3 = keys.get(random.nextInt(keys.size()));
            }

            //tis 3 lekseis tis vazoume kai stin arraylist
            k.add(w1);
            k.add(w2);
            k.add(w3);
            System.out.printf("\n\n" + c + "ος ΓΥΡΟΣ ΠΑΙΧΝΙΔΙΟΥ");
            display(choice); //sunartisi emfanisis lekseon, perigrafon

            count = 3;
            //an h arraylist exei lekseis paei stin epomeni leksi kai an oi prospathies einai panw apo 0
            while (count > 0 && !(k.isEmpty())) {
                stirring();     //sinartisi pou anakateuei ta grammata ton lekseon
                do {
                    System.out.printf("\nΕπιλέξτε λέξη που θέλετε να μαντέψετε : ");  //eisodo epilogis
                    x = in.nextInt();
                    if (x == 1) {
                        count = round(w1, count);  //sinartisi pou epistrefei enapominsntes prospathies
                    } else if (x == 2) {           //kai dexetai apo xristi tis lekseis pou manteuei
                        count = round(w2, count);
                    } else if (x == 3) {
                        count = round(w3, count);
                    } else {
                        System.out.println("Λάθος Πληκτρολόγηση!!!");
                    }
                } while (x != 1 && x != 2 && x != 3);
            }
            c++;  //auksanei to guro
        }
        if (count > 0) { 
            System.out.println("\n\nΚερδίσατε το παιχνίδι.Συγχαρητήρια!!!\n");
        } else {
            System.out.println("\n\nΔυστυχώς χάσατε. Ξαναπαίξτε!!!\n");
        }

    }

    //sinartisi emfanisis lekseon kai perigrafon
    private static void display(int c) {
        int leg;
        if (c == 1) {
            for (String key : k) {
                System.out.printf("\n" + words.get(key));    //emfanizei tin perigrafi
                System.out.printf("     " + key.charAt(0));   //emfanizei to 1o gramma tis leksis
                leg = key.length();    //metraei ta grammata tis leksis

                for (int i = 0; i < (leg - 2); i++) {   //gia ola ektos tou 1ou kai tou teleutaiou emfanizei paules
                    System.out.printf(" _ ");
                }
                System.out.printf(" " + key.charAt(leg - 1));   //emfanizei to teleutaio gramma tis leksis
            }
        } else {
            for (String key : k) {
                System.out.printf("\n" + words.get(key));   //emfanizei tin perigrafi
                System.out.printf("     ");
                leg = key.length();           //metraei ta grammata tis leksis

                for (int i = 0; i < (leg); i++) {
                    System.out.printf(" _ ");      //gia ola emfanizei paules
                }
            }
        }
        System.out.println("");

    }

    //anakateuei ta grammata ton lekseon pou exoun apominei
    private static void stirring() {
        
        String list = "";

        for (String s : k)    //oles tis lekseis tis vazoume se ena string
        {
            list += s;
        }

        //dimiourgo arraylist me xaraktires kai pernaei ekei tous xaraktires tou list
        ArrayList<Character> ch = new ArrayList<>();
        for (char c : list.toCharArray()) {
            ch.add(c);
        }
        //dimiourgei StringBuilder opou tha apothikeusei ta grammata me tuxaia seira
        StringBuilder displ = new StringBuilder(list.length());
        while (!ch.isEmpty()) {     //oso i arraylist me ta grammata exei mesa grammata
            int r = (int) (Math.random() * ch.size());  //pairnei tuxaio arithmo apo to 0 mexri megethos ths arraylist
            displ.append(ch.remove(r));        //afairei to gramma apo tuxaia thesi tis array
        }                                      //kai to prosthetei sti StringBuilder
        System.out.println("\n" + displ.toString());   //emfanizei ta anakatemena grammata apo to stringBuilder

    }

    //sinartisi pou dexetai tin mantepsia tou xristi kai emfanizei an vrike ti leksi i oxi
    private int round(String w, int count) {

        System.out.printf("Εισάγετε τη λέξη : ");
        String word = in.next();           //eisodo leksis

        if (word.equals(w) && count > 0) {   //ean i leksi einai mesa sti hashmap sunexizei, prospathies > 0
            k.remove(w);    //afairei ti leksi apo ton pinaka ton 3 tuxaion lekseon
            words.remove(w);     //afairei ti leksi apo ti hashmap
            System.out.println("Μπράβο. Μαντέψατε σωστά!!!");
            return count;
        } else {  //alliws afairei mia prospathia kai emfanizei tis enapominantes
            count--;
            System.out.println("Λάθος. Έχετε ακόμα " + count + " προσπάθειες.");
            return count;
        }

    }

}
