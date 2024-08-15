package designpatterns.behavioral;

abstract class GameTemplate {
    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play(){
        initialize();
        start();
        end();
    }
}

class CSGOGame extends GameTemplate{
    @Override
    void initialize() {
        System.out.println("CSGO Game Initialized");
    }

    @Override
    void start() {
        System.out.println("CSGO Game Started");
    }

    @Override
    void end() {
        System.out.println("CSGO Game Ended");
    }
}

class ChessGame extends GameTemplate{
    @Override
    void initialize() {
        System.out.println("Chess Game Initialized");
    }

    @Override
    void start() {
        System.out.println("Chess Game Started");
    }

    @Override
    void end() {
        System.out.println("Chess Game Ended");
    }
}
public class TemplatePattern {
    public static void main(String[] args) {
        GameTemplate gameTemplate = new CSGOGame();
        gameTemplate.play();
        gameTemplate = new ChessGame();
        gameTemplate.play();
    }
}
