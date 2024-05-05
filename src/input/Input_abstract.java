package input;

import CheckInput.CheckInput;

import Save.SaveToTxt;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Input_abstract {
    boolean flag = false;
    Scanner scanner = new Scanner(System.in);


    public void menu(){

        System.out.println("Нажмите 1 для получения инструкции");
        System.out.println("Нажмите 2 для ввода данных сотрудника");
        System.out.println("Нажмите 3 для выхода");





    }
    public void input() throws InputMismatchException{
        System.out.println("Здравствуйте");
        System.out.println("Для выбора действия нажмите соответствующую цифру и клавишу Ввод");
        System.out.println();

        String input = "";
        byte choice = 0;
        while (!input.equals("3")){
            menu();
            System.out.println();
            input = scanner.nextLine();
            try {
                choice = Byte.parseByte(input);
            } catch (NumberFormatException e){
                System.out.println("Введите цифру для действия");
                input = "";
            }
            switch (choice){
                case 1:
                    instruction();
                    break;
                case 2:
                    CheckInput checkInput = new CheckInput();
                    System.out.println("Введите данные согласно инструкции");

                    String inputMan = scanner.nextLine().strip();
                    flag = checkInput.checkLength(inputMan);
                    if (flag) System.out.println("Данные введены с ошибками, перечисленными выше\n" +
                            "Запись невозможна");
                    else {
                        System.out.println("Данные успешно проверены, начинаю запись");
                        SaveToTxt saveToTxt = new SaveToTxt();
                        saveToTxt.saveToTxt(inputMan, inputMan.split(" ")[0]);
                        //SaveAbstract.saveToTxt();
                    }

                    break;
                case 3:
                    System.out.println("Bye");
                    scanner.close();
                    break;


            }




        }

    }
    public void instruction(){
        System.out.println("Введите Фамилию Имя Отчество Дату рождения номер телефона и пол по следующему формату через пробел");
        System.out.println("Фамилия Имя Отчество - текстом через пробел");
        System.out.println("Дата рождения в формате dd.mm.yyyy");
        System.out.println("номер телефона - целое беззнаковое число без форматирования");
        System.out.println("Пол - символ латиницей f - женский или m - мужской");
        System.out.println("Обратите внимание - данные вводятся одной строкой через пробел");
        System.out.println("После корректного ввода данные будут записаны в файл");
        System.out.println();

    }

}
