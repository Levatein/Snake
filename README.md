# Snake

<b>Класс Point:</b>
  Класс с полями int x и int y, класс точек(координат, скорее)
  
<b>Класс Snake:</b>
  Содержит в себе поле snake, представляющее собой лист точек. Метод movement реализует её передвижение путём переставления
  последнего эллемента листа в начало. eatingFood добавляет в хвост змеи новый элемент и определяет его положение. snakeDie проверяет
  столкновение со стеной. snakeEatItself сокращает длину змеи если та "перекусывает" сама себя.
  
<b>Класс Food:</b>
  Содержит в себе Point coordinate и int value=1, которое показывает её цену. createFood создаёт еду в случайной точке, не пересекающейся
  со змеёй и находящейся в пределах карты
  
<b>Тесты FoodTest и SnakeTest:</b>
  FoodTest проверяет, чтобы еда никогда не создавалась вне карты и не пересекалась со змеёй.
  SnakeTest проверяет правильное перемещение змеи, увеличение её длины при поедании еды, столкновение со стеной при координатах больше
  её размера и при отрицательных координатах. Так же проверяет snakeEatItself
  
<b>Main:</b>
  Написала эту штуку, чтобы иметь лучшее представление о происходящем. Генерирует карту 16х11 и выводит её на консоль в виде матрицы.
  Голова змеи обозначена "H", её тело "0", еда обозначена "8"
