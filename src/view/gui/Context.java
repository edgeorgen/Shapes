package view.gui;

import model.interfaces.Strategy;

public class Context {
    private Strategy strategy;
private PaintCanvas canvas;

    public Context(PaintCanvas canvas, Strategy strategy) {
        this.strategy = strategy;
        this.canvas = canvas;
    }

    public void executeStrategy(){
        strategy.execute(canvas);
    }
}
