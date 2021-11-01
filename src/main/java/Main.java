
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.welcomePlayer();
        gameController.createBattlefield();
        gameController.prepareField();
        gameController.startGame();
    }
}
