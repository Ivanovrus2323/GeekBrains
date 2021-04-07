import java.util.*;

/**
 *
 * Консольная игра крестики-нолики
 *
 */
public class CrossZeroConsoleGame {

    // Символы игрового поля
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    // Игровое поле
    public static char[][] map;
    public static byte size;

    public static byte gameMode;

    public static final char[] O_LINE3 = new char[] {DOT_O,DOT_O,DOT_O};
    public static final char[] X_LINE3 = new char[] {DOT_X,DOT_X,DOT_X};

    public static final char[] O_LINE4 = new char[] {DOT_O,DOT_O,DOT_O,DOT_O};
    public static final char[] X_LINE4 = new char[] {DOT_X,DOT_X,DOT_X,DOT_X};

    // Игрок
    public static byte currentPlayer = 2;
    public static char currentDot = DOT_O;

    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    public static void main(String[] args) {
        choseGameMode();
        choseMapSize();

        initMap();

        play();
        printMap();
        System.out.println("Игра закончена");
        System.exit(0);
    }

    /**
     * Выбор игрового режима
     */
    public static void choseGameMode() {
        do {
            System.out.println("Выберите режим игры:");
            System.out.println("1 - с компьютером");
            System.out.println("2 - на двоих");

            gameMode = scanner.nextByte();
        } while (!isGameModeValid());

        System.out.println((gameMode == 1) ? "Выбран режим игры с компьютером." : "Выбран режим игры на двоих");
    }

    /**
     * Проверка валидности игрового режима
     */
    public static boolean isGameModeValid() {
        return gameMode == 1 || gameMode == 2;
    }

    /**
     * Выбор размера поля
     */
    public static void choseMapSize() {
        do {
            System.out.println("Выберите размер игрового поля:");
            System.out.println("3 - 3x3");
            System.out.println("5 - 5x5");

            size = scanner.nextByte();
        } while (!isMapSizeValid());

        System.out.println((size == 3) ? "Выбран размер игрового поля 3x3.\nДля победы необходимо 3 одинаковых знака подряд." : "Выбран размер игрового поля 5x5.\nДля победы необходимо 4 одинаковых знака подряд.");
    }

    /**
     * Проверка валидности размера игрового поля
     */
    public static boolean isMapSizeValid() {
        return size == 3 || size == 5;
    }

    /**
     * Создание игрового поля
     */
    public static void initMap() {
        map = new char[size][size];

        for (char[] chars : map) {
            Arrays.fill(chars, DOT_EMPTY);
        }
    }

    /**
     * Метод проведения игры
     */
    public static void play() {
        do {
            changeCurrentPlayer();
            if (gameMode == 1 && currentPlayer == 2) {
                aiTurn();
            } else if (gameMode == 2 || currentPlayer == 1) {
                printMap();
                humanTurn();
            }
        } while (!checkWin());
    }

    /**
     * Отвечает за проверку победы
     */
    public static boolean checkWin() {
        if (size == 3) {
            // Проходимся по строкам
            for (char[] row : map) {
                if (Arrays.equals(row, X_LINE3) || Arrays.equals(row, O_LINE3)) {
                    return true;
                }
            }

            // Проходимся по столбцам
            for (int i = 0; i < map[0].length; i++) {
                char[] column = new char[size];
                for (int j = 0; j < map.length; j++) {
                    column[j] = map[j][i];
                }
                if (Arrays.equals(column, X_LINE3) || Arrays.equals(column, O_LINE3)) {
                    return true;
                }
            }

            // Получаем главную диагональ
            char[] mainDiagonal = new char[size];
            for (int i = 0; i < size; i++) {
                mainDiagonal[i] =  map[i][i];
            }
            // Проверяем главную диагональ
            if (Arrays.equals(mainDiagonal, X_LINE3) || Arrays.equals(mainDiagonal, O_LINE3)) {
                return true;
            }

            // Получаем побочную диагональ
            char[] secondaryDiagonal = new char[size];
            for (int i = size-1; i >= 0; i--) {
                secondaryDiagonal[i] =  map[i][i];
            }
            // Проверяем побочную диагональ
            return Arrays.equals(secondaryDiagonal, X_LINE3) || Arrays.equals(secondaryDiagonal, O_LINE3);

        } else if (size == 5) {
            // Проходимся по строкам
            for (char[] chars : map) {
                // Проходимся по кускам размером 4 в строках
                for (int j = 0; j <= chars.length - 4; j++) {
                    // Получаем кусок строки
                    char[] line = new char[4];
                    for (int k = 0; k < line.length; k++) {
                        line[k] = chars[k + j];
                    }
                    // Проверяем кусок строки
                    if (Arrays.equals(line, X_LINE4) || Arrays.equals(line, O_LINE4)) {
                        return true;
                    }
                }
            }

            // Проходимся по столбцам
            for (int i = 0; i < map[0].length; i++) {
                // Получаем столбец
                char[] column = new char[size];
                for (int j = 0; j < map.length; j++) {
                    column[j] = map[j][i];
                }

                // Проходимся по кускам размером 4 в столбце
                for (int j = 0; j <= column.length-4; j++) {
                    // Получаем кусок строки
                    char[] line = new char[4];
                    for (int k = 0; k < line.length; k++) {
                        line[k] = column[k+j];
                    }

                    // Проверяем кусок строки
                    if (Arrays.equals(line, X_LINE4) || Arrays.equals(line, O_LINE4)) {
                        return true;
                    }
                }
            }


            // Получаем главные диагонали размером 4
            char[][] mainDiagonals = new char[4][4];

            for (int i = 0; i <= size-4; i++) {
                for (int j = 0; j < 4; j++) {
                    mainDiagonals[i][j] = map[j+i][j+i];
                }
            }
            for (int i = 1; i < size; i++) {
                mainDiagonals[2][i-1] = map[i-1][i];
            }
            for (int i = 1; i < size; i++) {
                mainDiagonals[3][i-1] = map[i][i-1];
            }

            // Проверяем главные диагонали
            for (char[] array : mainDiagonals) {
                if (Arrays.equals(array, X_LINE4) || Arrays.equals(array, O_LINE4)) {
                    return true;
                }
            }


            // Получаем побочные диагонали размером 4
            char[][] secondaryDiagonals = new char[4][4];

            // Получаем центральную диагональ
            for (int i = 0; i <= size-4; i++) {
                char[] diagonal = new char[size];
                int j = size-1;
                for (int k = 0; k < size; k++) {
                    diagonal[k] = map[k][j];
                    j--;
                }
                j = 0;
                for (int k = i; k <= size-2+i; k++) {
                    secondaryDiagonals[i][j] = diagonal[k];
                    j++;
                }
            }
            // Получаем верхнюю диагональ
            int j = size-2;
            for (int i = 0; i < size-1; i++) {
                secondaryDiagonals[2][i] = map[i][j];
                j--;
            }
            // Получаем нижнюю диагональ
            j = 1;
            for (int i = size-1; i > 0; i--) {
                secondaryDiagonals[3][i-1] = map[i][j];
                j++;
            }

            // Проверяем побочные диагонали
            for (char[] array : secondaryDiagonals) {
                if (Arrays.equals(array, X_LINE4) || Arrays.equals(array, O_LINE4)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    /**
     * Смена игрока
     */
    public static void changeCurrentPlayer() {
        currentPlayer = (byte) (currentPlayer == 1 ? 2 : 1);
        currentDot = currentPlayer == 1 ? DOT_X : DOT_O;
    }

    /**
     * Ход компьютера
     */
    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(size-1);
            y = random.nextInt(size-1);
        } while (!isAiTurnValid(x, y));
        map[y][x] = currentDot;
        System.out.printf("Компьютер походил в точку %d %d \n", x+1, y+1);
    }

    /**
     * Проверка хода компьютера
     */
    public static boolean isAiTurnValid(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && map[y][x] == DOT_EMPTY;
    }

    /**
     * Ход человека
     */
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координату x y");

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isHumanTurnValid(x, y));
        map[y][x] = currentDot;
        System.out.printf("Вы походили в точку %d %d \n", x+1, y+1);
    }

    /**
     * Проверка хода человека
     */
    public static boolean isHumanTurnValid(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size || map[y][x] != DOT_EMPTY) {
            if (map[y][x] != DOT_EMPTY) {
                System.out.println("Точка уже занята");
            }
            return false;
        }
        return true;
    }

    public static void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.print("- x");

        System.out.println();

        for (int i = 0; i < map.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("|");
        System.out.println("y");
        System.out.println();
    }
}