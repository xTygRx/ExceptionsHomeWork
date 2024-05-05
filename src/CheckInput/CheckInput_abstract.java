package CheckInput;




public abstract class CheckInput_abstract  {
    protected boolean flagCheck = false;
    public boolean checkLength(String input) {
        String[] data = input.split(" ");


        //Проверка ввода по количеству данных
        if (data.length < 6) {
            System.out.println("Вы ввели недостаточно данных или пропустили пробел");
            return true;
        } else if (data.length > 6) {
            System.out.println("Вы ввели избыточные данные или лишний пробел");
            return true;
        } else  return checkDataInput(data);
    }
    public boolean checkDataInput(String[] data){
        //Проверка что в ФИО нет чисел
        // Фамилия 0, Имя 1, Отчество 2 - индексы в массиве
        for (int i = 0; i < 3; i++) {
            check(data[i]);
            if (check(data[i])) flagCheck = true;
        }




        //Проверка формата даты рождения
        //Индекс в массиве 3
        //Проверка точек
        String dateTest = data[3];
        try {
            if ((dateTest.indexOf('.') != 2) && (dateTest.lastIndexOf('.') != 5))
                throw new InvalidInput("Error");
        } catch (InvalidInput e)
         {
             System.out.println("Вы ввели неверную дату рождения или \n " +
                    "она не соответствует формату dd.mm.yyyy");
             flagCheck = true;
        }

        //Проверка отсутствия букв в дате рождения


        for (char c : dateTest.toCharArray()) {
            try {
                if (!Character.isDigit(c) && c != '.')
                    throw new InvalidInput("Error date");
            } catch (InvalidInput e)
             {
                System.out.println("Дата рождения не соответствует формату");
                flagCheck = true;
            }
        }



        //Проверка номера телефона
        //Индекс в массиве 4
        String phoneNumber = data[4];

        for (char c : phoneNumber.toCharArray()) {
            try {
                if (!Character.isDigit(c))
                    throw new InvalidInput("Error date");
            } catch (InvalidInput e)
             {
                 flagCheck = true;
                 System.out.println("Номер телефона должен быть целым беззнаковым числом");
            }
        }


        //Проверка пола
        //Индекс в массиве 5
        String male = data[5];
        try {
            if (male.length() != 1) throw new InvalidInput("Error Gender");
            else if (!male.equalsIgnoreCase("f") && !male.equalsIgnoreCase("m")) {
               throw new InvalidInput("Error Gender");
            }
        }catch (InvalidInput e){
            System.out.println("Пол введен не в соответствии с форматом ввода");
            flagCheck = true;
        }
        return flagCheck;
    }
    public  boolean check(String name){
        boolean flag = false;

        for (char c : name.toCharArray()) {
            try {
                if ((!Character.isLetter(c))) throw new InvalidInput("ErrorName");
            } catch (InvalidInput e){
                flag = true;
                System.out.println("В Фамилии Имени или Отчестве не должно других символов кроме букв\n " +
                        "или вы ввели данные не в правильной последовательности");

            }

        }
        return flag;
    }

}
