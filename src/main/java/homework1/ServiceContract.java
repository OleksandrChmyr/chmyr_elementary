package homework1;

import java.io.IOException;

public interface ServiceContract {
// Контракт состоит из следующих методов:

//3.1. "Проверить пользователя": Метод принимает входящим параметром пользователя(User или Admin) - вспоминаем про
// Динамическую диспетчеризацию (кто забыл). В ходе выполнения данного метода идет вычитка из файлика данных и сверка
// есть ли в этом файлике почта, как у пользователя которого передали в этот метод. (Файлик с данными необходимо
// подготовить самостоятельно заранее. Для удобства каждое значение пишите с новой строки в файлике). Подсказка:
// Чтобы вычитать данные из файла используем FileReader. И после проверки метод возвращает нашел или нет (true/false).
// Данная логика одинакова как для UserService, так и для AdminService.

    boolean checkUser(Human human) throws IOException;

//   3.2. "Записать данные пользователя": Метод принимает входящим параметром пользователя(User или Admin) - как метод
//   выше. В ходе выполнения вычитывает все данные по переданному пользователю и записывает в файлик(для удобства каждое
//   значение с новой строки). И ничего не возвращает в ответ. Данный метод доступен только в AdminService, в
//   UserService просто выводить сообщение о недоступности данного метода в сервисе.

    void writeUserData(Human human) throws IOException;

}
