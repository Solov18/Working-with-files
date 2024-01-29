package com.javacurse.ce.Seminar5;

import java.io.*;
import java.nio.file.Path;

/*Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
  и представляют собой, например, состояния ячеек поля для игры в крестикинолики,
  где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
  Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
  Записать в файл 9 значений так, чтобы они заняли три байта.*/
public class Task2 {

    public static void main(String[] args) {

        // Для ввода нужной директории
        pathNew("C:\\Users\\Admin\\Desktop\\It\\Java\\Baza_java\\src\\main\\java\\com\\javacurse\\ce\\Seminar5\\tic_tac_toe.txt");
    }
    public static void pathNew(String directory) {


        int[] values = {1, 2, 0, 3, 1, 2, 0, 0, 2};
        Path file = Path.of(directory);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.toFile()))) {
            int packedData = 0;
            for (int i = 0; i < values.length; i++) {
                packedData = (packedData << 2) | (values[i] & 0b11);

                if ((i + 1) % 4 == 0) {
                    dos.write(packedData);
                    packedData = 0;

            }



            //for (int element : values) {
                //dos.write(element);
            }
            System.out.println("Значения успешно записаны в файл");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка записи в файл: " + e.getMessage());

        }
    }
}