package model;

import view.gui.*;
import model.interfaces.Strategy;

public class DeleteStrategy implements Strategy {
    @Override
    public void execute(PaintCanvas canvas) {
            for(BasicShape shape : canvas.gatShapes()){
                System.out.println(shape.getId() + " " + shape.isSelected());
                if(shape.isSelected()){
                    canvas.gatShapes().remove(shape);
                    int type = shape instanceof RectangularShape ? ShapeAction.rectangle:shape instanceof EllipseShape ?ShapeAction.ellipse:ShapeAction.triangle;
                    ShapeAction action = new ShapeActionBuilder().setId(shape.getId()).setAction(ShapeAction.REMOVEACTION).setShape(type).setStartx(shape.getXstart()).setStarty(shape.getYstart()).setEndx(shape.getXend()).setEndy(shape.getYend()).setPrimaryColor(shape.getPrimaryColor()).setEdgeColor(shape.getEdgeColor()).setShapeShadingType(shape.getShapeShadingType()).createShapeAction();
                    canvas.undoList.add(action);
                    canvas.repaint();
                    return;
                }
            }
        }
    }

