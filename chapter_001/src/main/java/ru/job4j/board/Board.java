package ru.job4j.board;
/**
* @author Vasiliy Koreshkov
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * @param wight - ширина доски
     * @param height - высота доски
     * @return - возвращает доску из символов
     */
    public String paint(int wight, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= wight; j++) {
                if ((j + i) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}