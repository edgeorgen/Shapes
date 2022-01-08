package model;

import view.gui.BasicShape;
import view.gui.PaintCanvas;
import view.gui.ShapeAction;
import view.gui.ShapeFactory;
import model.interfaces.Strategy;

public class Redo implements Strategy {
    @Override
    public void execute(PaintCanvas canvas) {
        if (!canvas.redoList.isEmpty()) {
            ShapeAction action = canvas.redoList.remove(canvas.redoList.size()-1);
            if (action.getAction() == ShapeAction.ADDACTION) {
                BasicShape shape = ShapeFactory.getShape(action.getShape() == ShapeAction.rectangle ? ShapeType.RECTANGLE : action.getShape() == ShapeAction.ellipse ? ShapeType.ELLIPSE : ShapeType.TRIANGLE,
                        action.getStartx(), action.getStarty(), action.getEndx(), action.getEndy(), action.getPrimaryColor(), action.getEdgeColor(), action.getShapeShadingType(), canvas.getSelected(), canvas);
                canvas.gatShapes().add(shape);
                canvas.addComponent(shape);
                canvas.repaint();
            } else if (action.getAction() == ShapeAction.REMOVEACTION) {
                for (BasicShape shape : canvas.gatShapes()) {
                    if (shape.getId() == action.getId()) {
                        canvas.gatShapes().remove(shape);
                        canvas.repaint();
                        break;
                    }
                }
            } else if (action.getAction() == ShapeAction.MOVEACTION) {
                for (BasicShape shape : canvas.gatShapes()) {
                    if (shape.getId() == action.getId()) {
                        shape.setXstart(action.getStartx());
                        shape.setYstart(action.getStarty());
                        shape.setXend(action.getEndx());
                        shape.setYend(action.getEndy());
                        canvas.repaint();
                        break;

                    }
                }
            }
        }
    }
}

