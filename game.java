/*Lertas Georgios icsd11084*/

import java.util.Scanner;

public class game {

    public game() {    //dilwsi metavliton tou programmatos
        String username;
        int choice;
        System.out.println("ΚΑΛΩΣΗΡΘΑΤΕ ΣΤΟ ΠΑΙΧΝΙΔΙ «ΒΡΕΣ ΤΙΣ ΛΕΞΕΙΣ»");

        Scanner input = new Scanner(System.in);

        System.out.printf("\nΕισάγετε το όνομα σας: ");   //eisodo onomatos paixti
        username = input.nextLine();
        do {
            System.out.printf("Επιλέξτε επίπεδο δυσκολίας (1 – Εύκολο, 2 – Δύσκολο): ");

            choice = input.nextInt();       //eisagwgi epiloghs epipedou

            if (choice == 1 || choice == 2) {         //pernaei thn epilogh sthn ektelesi tou paixnidiou, stin epomeni klasi
                easyhard easy = new easyhard(choice);
            } else {
                System.out.println("Λάθος Πληκτρολόγηση!!!");
            }
        } while (choice != 1 && choice != 2);           //an h eisagwgh den einai 1 h 2 tote ksanazhtaei eisodos
    }
}
