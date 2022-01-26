package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void writeToFile(String path, List<Student> students){
            try {
                OutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(students);
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Sang", "HP"));
        students.add(new Student(2, "Luýt", "HT"));
        students.add(new Student(3, "Lịch", "NA"));
        students.add(new Student(4, "Việt", "TH"));

        writeToFile("students.txt",students);

        List<Student> studentDataFromFile = readDataFromtFile("student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }

    }

        public static List<Student> readDataFromtFile(String path){
            List<Student> students = new ArrayList<>();
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                students = (List<Student>) ois.readObject();
                fis.close();
                ois.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return students;
        }




}
