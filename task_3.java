@RunWith(Parameterized.class) // Напиши аннотацию для параметризованных тестов
public class CheckIsAdultTest {
  
  private final int age;
  private final boolean result;

  public CheckIsAdultTest(int age, boolean result) {
    this.age = age;  // Инициализируем поля класса в конструкторе
    this.result = result;
  }

  @Parameterized.Parameters // Пометь метод аннотацией для параметров
  public static Object[][] getTestData() {
    return new Object[][] {
      {17, false},  // Младше 18 лет
      {18, true},   // Ровно 18 лет
      {19, true},   // Старше 18 лет
      {21, true},   // Совершеннолетие в некоторых странах наступает с 21 года
    };
  }

  @Test
  public void checkIsAdultWhenAgeThenResult() {
    Program program = new Program();
    // Передаем возраст пользователя в метод
    boolean isAdult = program.checkIsAdult(age);
    // Сравниваем полученный результат с ожидаемым, добавляем сообщение об ошибке
    assertEquals("Для возраста " + age + " ожидаемый результат: " + result, result, isAdult);
  }
}
