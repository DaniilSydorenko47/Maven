package HW30;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File fileOut = new File("src/main/java/HW30/out.txt");
        try {
            fileOut.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String numbers ="1 2 3 4 5 6 7 8 9 10";
        File fileNumbers = new File("src/main/java/HW30/numbers.txt");
        try (FileWriter fw = new FileWriter(fileNumbers)){
            fileNumbers.createNewFile();
            fw.write(numbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String phoneNumbers = "+38012345678\n" +
                "+38098765432\n" +
                "+38021212121\n" +
                "+38034343434\n" +
                "+38055555555\n" +
                "+38077777777\n" +
                "+38099999999\n" +
                "+38066666666\n" +
                "+38000000000\n" +
                "+38047474747";
        File fileTest = new File("src/main/java/HW30/test.txt");
        try (FileWriter fw1 = new FileWriter(fileTest)){
            fileTest.createNewFile();
            fw1.write(phoneNumbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] fibonachiNumbers = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try(BufferedWriter fw = new BufferedWriter(new FileWriter(fileOut,true))) {
                    String fifteenthNumber = String.valueOf(fibonachiNumbers[15]);
                    fw.write("П'ятнадцяте число послідовності Фібоначчі: " +fifteenthNumber);
                    fw.newLine();
                    fw.flush();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });


        Thread th2 = new Thread(new Runnable() {
            ArrayList<Integer> list;
            Scanner sc;
            int sum = 0;
            @Override
            public void run() {
                try (BufferedReader br = new BufferedReader(new FileReader(fileNumbers))){
                    sc =new Scanner(fileNumbers);
                    list = new ArrayList<>();
                    while (sc.hasNextLine()){
                        list.add(sc.nextInt());
                    }
                    for (int i = 0; i < list.size(); i++) {
                        sum+= list.get(i);
                    }

                } catch (NumberFormatException | IOException | NoSuchElementException e){
                    e.printStackTrace();
                }
                try (BufferedWriter fw = new BufferedWriter(new FileWriter(fileOut, true))){
                    fw.write("Сума: " + sum);
                    fw.newLine();
                    fw.flush();

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });


        Thread th3 = new Thread(new Runnable() {
            Scanner sc;
            List<String> listNumbers;
            Random random;
            @Override
            public void run() {
                try (BufferedReader br = new BufferedReader(new FileReader(fileTest))){
                    sc =new Scanner(fileTest);
                    listNumbers = new ArrayList<>();
                    while (sc.hasNextLine()){
                        listNumbers.add(sc.nextLine());
                    }

                } catch (IOException e){
                    e.printStackTrace();
                }

                try (BufferedWriter fw = new BufferedWriter(new FileWriter(fileOut, true))){
                    random = new Random();
                    int ran;
                    fw.write("Номера: ");
                    for (int i = 0; i < 3; i++) {
                        ran = random.nextInt(listNumbers.size());
                        fw.write(listNumbers.get(ran)+" ");
                    }
                    fw.newLine();
                    fw.flush();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        th1.start();
        th2.start();
        th3.start();
        System.out.println("Всі операції завершені");
    }
}
