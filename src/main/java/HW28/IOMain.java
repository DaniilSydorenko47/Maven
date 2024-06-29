package HW28;

import java.io.*;
import java.util.Scanner;

public class IOMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file1 = new File("src/main/java/HW28/output.txt");
        String userSentence = sc.nextLine();
        try(FileWriter fw = new FileWriter("src/main/java/HW28/output.txt")) {
            file1.createNewFile();
            fw.write(userSentence);
            fw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/HW28/output.txt"))){
            System.out.println("========================");
            int i;
            while((i = br.read()) != -1){
                System.out.print((char) i);
            }
            System.out.println();
        } catch (IOException e){
            e.printStackTrace();
        }
        String someText = "Some text";
        File file2 = new File("src/main/java/HW28/source.txt");
        try(FileWriter fw = new FileWriter("src/main/java/HW28/source.txt")){
            file2.createNewFile();

            fw.write(someText);
            fw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader("src/main/java/HW28/source.txt")){
            System.out.println("========================");
            int i;
            while((i = fr.read()) != -1){
                System.out.print((char) i);
            }

            File file3 = new File("src/main/java/HW28/destination.txt");
            FileWriter fw = new FileWriter("src/main/java/HW28/destination.txt");
            file3.createNewFile();
            System.out.println();
            fw.write(someText);


            fw.flush();
        } catch(IOException e){
            e.printStackTrace();
        }


        Person person = new Person("Daniil");
        try(ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream("src/main/java/HW28/serialize.txt"))){
            outputStream.writeObject(person);
        } catch(IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream("src/main/java/HW28/serialize.txt"))){
            Person person1 = (Person) inputStream.readObject();
            System.out.println("========================");
            System.out.println(person1);
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
