package DZ5;

import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Необходимо разделить на горизонтальный уровни "Редактор 3D графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     * 
     * Что видит пользователь, как взаимодействует? (панель загрузки, блок редактирования, блок просмотра).
     * Какие задачи можно делать - функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую, 
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * Какие и где хранить данные? (файлы 3D моделей, рендеры, анимация ..., в файловой системе компьютера).
     * 
     * Предложить варианты связывания всех уровней - сценарии использования. 3-4 сценария.
     * Сквозная функция - создать новую 3D модель, сделать рендер для печати на принтере. 
     */

    
    public static void main(String[] args) {

        Editor3D editor3d = new Editor3D();
        boolean f = true;
        while (f) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("***********************");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
            System.out.println("8. Выполнить удаление модели");
            System.out.println("9. Выполнить удаление текстуры");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if(scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения.");
                            f=false;
                            break;
                        case 1:
                            System.out.println("Укажите наименование файла проекта: ");
                            String Filename = scanner.nextLine();
                            editor3d.openProject(Filename);
                            System.out.println("Проект успешно открыт.");
                            break;
                        case 2:
                            editor3d.saveProject();
                            break;
                        case 3:
                            editor3d.showProjectSettings();
                            break;
                        case 4:
                            editor3d.printAllModels();
                            break;
                        case 5:
                            editor3d.printAllTextures();
                            break;
                        case 6:
                            editor3d.renderAll();
                            break;
                        case 7:
                            System.out.println("Укажите номер модели: ");
                            if (scanner.hasNextLine()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3d.renderModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        case 8:
                            System.out.println("Укажите номер модели: ");
                            if (scanner.hasNextLine()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3d.removeModels(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        case 9:
                            System.out.println("Укажите номер текстуры: ");
                            if (scanner.hasNextLine()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3d.removeTextures(modelNo);
                            } else {
                                System.out.println("Номер текстуры указан некорректно.");
                            }
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню.");
                            break;
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }
    
}