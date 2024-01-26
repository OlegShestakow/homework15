import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {
    @Test
    public void whenSecondPlayerWin() {

        Player Kolya = new Player(1, "Коля", 500);
        Player Masha = new Player(2, "Маша", 800);

        Game game = new Game();

        game.register(Kolya);
        game.register(Masha);
        int expected = 2;
        int actual = game.round("Коля", "Маша");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void whenFirstPlayerWin() {

        Player Kolya = new Player(1, "Коля", 500);
        Player Masha = new Player(2, "Маша", 300);

        Game game = new Game();

        game.register(Kolya);
        game.register(Masha);
        int expected = 1;
        int actual = game.round("Коля", "Маша");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void whenStrengthEquals() {

        Player Kolya = new Player(1, "Коля", 500);
        Player Masha = new Player(2, "Маша", 500);

        Game game = new Game();

        game.register(Kolya);
        game.register(Masha);
        int expected = 0;
        int actual = game.round("Коля", "Маша");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void whenFirstPlayerNotExist() {

        Player Kolya = new Player(1, "Коля", 500);
        Player Masha = new Player(2, "Маша", 500);

        Game game = new Game();

        game.register(Kolya);
        game.register(Masha);
        int expected = 0;
        int actual = game.round("Коля", "Маша");
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Оля", "Маша")
        );


    }

    @Test
    public void whenSecondPlayerNotExist() {

        Player Kolya = new Player(1, "Коля", 500);
        Player Masha = new Player(2, "Маша", 500);

        Game game = new Game();

        game.register(Kolya);
        game.register(Masha);
        int expected = 0;
        int actual = game.round("Коля", "Маша");
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Саша")
        );
    }
}