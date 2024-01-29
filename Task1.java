package com.javacurse.ce.Seminar5;


//Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
// во вновь созданную папку ./backup

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Task1 {
    public static void createBackup(String sourceDirectory) {

        Path currentDirectory = Path.of(sourceDirectory);  // путь к текущей
        Path backupDirectory = Path.of("./backup");   // путь к резервной

        try {
            Files.createDirectories(backupDirectory);         // Создаем новую директорию для резервной копии
            File[] files = currentDirectory.toFile().listFiles();
            if (files != null) {
                for (File file : files) {
                    Path sourceFilePath = file.toPath();
                    Path backupFilePath = backupDirectory.resolve(file.getName());

                    Files.copy(sourceFilePath, backupFilePath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Резервная копия, созданная для: " + file.getName());
                }
                System.out.println("Резервное копирование успешно завершено. ");

            } else {
                System.out.println("Исходный каталог пуст");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка создания резервной копии: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        createBackup("C:\\Users\\Admin\\Desktop\\It\\Java\\Baza_java\\src\\main\\java\\com\\javacurse");
    }
}
