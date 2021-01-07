1. На компьютере должна быть установлена JDK и прописаны переменные окружения(через панель управления).
2. Если они переменные окружения не прописаны, в cmd:
JAVA_HOME=d:\java\jdk-11
path=d:\java\jdk-11\bin 
3. Скачать архивом apache maven. Распаковать.
4. В cmd set path-maven: set PATH=%PATH%;d:\java\apache-maven-3.6.3\bin 
5. Переходим в директорию, в которой будет создан проект:cd /d d:\home-work\maven01
5. Создание нового проекта:
mvn archetype:generate
Вводим параметры проекта (groupId, artifactId, version, package).
6. Откомпилировать и протестировать проект:
компиляция: mnv compile
cоздание пакета: mnv package
установка: mvn install
запуск тестов: mvn test

