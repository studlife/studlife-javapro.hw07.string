package ua.hillel.javapro.hw07.stirng;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        // 2
        findSymbolOccurance ("I like Java", 'i');

        // 3
        findWordPosition ("Apollo", "pollo");  // 1
        findWordPosition ("Apple", "Plant");   // -1

        // 4
        String a = "Hello";
        stringReverse(a);
        //System.out.println(a);

        // 5
        System.out.println(isPalindrome ("ERE"));  // true
        System.out.println(isPalindrome ("Allo")); // false
        System.out.println(isPalindrome ("Kazak")); // true

        // 6
        System.out.println("// 6 завдання ");
        game();




    }

    // 2
    public static void findSymbolOccurance (String a, char b) {
        int count = 0;

        for (char ch : a.toCharArray()){
            if (ch == b) count++;
        }
        System.out.println("2 завдяння: " + count);
    }

    // 3
    public static void findWordPosition (String a, String b) {

        System.out.println("3 завдяння: " +  a.indexOf(b));
    }

    // 4
    public static void stringReverse(String a) {

        char[] ch = a.toCharArray();

        for (int i = 0; i < ch.length/2; i++) {

            char tmp = ch[i];
            ch[i] = ch[ch.length-1 - i];
            ch[ch.length-1 - i] = tmp;
        }

        System.out.println("4 завдяння: " +  new String(ch));
    }



    // 5
    public static boolean isPalindrome (String a) {

        // Попередньо переводимо до нижнього регістру
        // поліндром не повинно залежити від того великі літери чи маленькі
        char[] ch = a.toLowerCase().toCharArray();

        for (int i = 0; i < ch.length/2; i++) {

            if (ch[i] != ch[ch.length-1 - i]) {
                return false;
            }
        }
        return true;
    }




    // 6
    public static void game() {

        System.out.println(" - - - - Гра «Вгадай слово» - - - - ");
        System.out.println("Я загадав слово спробуй його вігадати, а я допоможу.");
        System.out.println("Поїхали: англійске слово маленькими літерами.");

        String[] words = {
                "apple", "orange", "lemon", "banana",
                "apricot", "avocado" , "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive",
                " pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"
        };
        int rand =(int) (Math.random() * words.length);  // генеруємо випадкове число в межах нашого массиву

        Scanner sc = new Scanner(System.in);

        boolean good = true;

        while (good) {
            String str = sc.nextLine();

            // Якщо все ок виходимо з циклу
            if (str.equals(words[rand]))  break;

            // Перевірки... можна ще добавити на числа чи кирилицю и т.д.
            if (str.length() == 0) {
                System.out.println("Не буває слів без літер! Спробуй ще");
                continue;
            }
            if (str.equals(" ")) {
                System.out.println("Бувають таки слова? Спробуй ще");
                continue;
            }


            for (int i = 0; i < 15; i++) {

                if(words[rand].length() > i && str.length() > i) {
                    if (words[rand].charAt(i) == str.charAt(i)){
                        System.out.print(str.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                } else {
                    System.out.print("#");
                }
            }


            System.out.println("\n Спробуй ще!");
            System.out.println("Підсказка для перевірки завдяння. Вірне слово (" + words[rand] + ")");

        }

        System.out.println("Super!");

    }



}
