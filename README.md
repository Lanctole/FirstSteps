# Утилита для фильтрации файлов

## Технологии
- **Java 21**
- **Gradle 8.10**
- Плагин **io.freefair.lombok** версии **8.12.1**

## Запуск
1. Скачайте или клонируйте проект с Git.
2. Перейдите в папку проекта.
3. Для сборки проекта используйте Gradle.
4. Выполнить команду в корне проекта
    ```bash
   ./gradlew clean build
    ```
5. Запустить jar файл с необходимыми аргументами. input1.txt input2.txt должны находиться в папке проекта. Либо укажите к ним путь. 
   ```bash
   java -jar build/libs/FirstSteps.jar <args> input1.txt input2.txt
   ```
6. В случае проблем с кодировкой в Windows введите в консоль:
    ```bash
    chcp 65001
    ```

## Аргументы
- `-a` — Вставка в конец файла
- `-p` — Префикс имени файла
- `-o` — Директория для записи результатов
- `-s` — Показ короткой статистики
- `-f` — Показ полной статистики
