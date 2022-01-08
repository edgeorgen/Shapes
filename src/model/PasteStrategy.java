package model;

import view.gui.*;
import model.interfaces.Strategy;

public class PasteStrategy implements Strategy {
    @Override
    public void execute(PaintCanvas canvas) {
        CopyShape copy = canvas.getCopy();
        if(copy.getType() == 1){
            BasicShape shape = new RectangularShape(copy.getXstart(),copy.getYstart(), copy.getXend(),copy.getYend(),copy.getPrimaryColor(),copy.getEdgeColor(),
                    copy.getShapeShadingType(), canvas.getSelected() ,canvas);
            canvas.gatShapes().add(shape);
            ShapeAction action = new ShapeActionBuilder().setId(shape.getId()).setAction(ShapeAction.ADDACTION).setShape(ShapeAction.rectangle).setStartx(shape.getXstart()).setStarty(shape.getYstart()).setEndx(shape.getXend()).setEndy(shape.getYend()).setPrimaryColor(shape.getPrimaryColor()).setEdgeColor(shape.getEdgeColor()).setShapeShadingType(shape.getShapeShadingType()).createShapeAction();
            canvas.addComponent(shape);
            canvas.undoList.add(action);

        }
        if(copy.getType() == 2){
            BasicShape shape = new EllipseShape(copy.getXstart(), copy.getYstart(),copy.getXend(),copy.getYend(),copy.getPrimaryColor(),copy.getEdgeColor(),
                    copy.getShapeShadingType(), canvas.getSelected() ,canvas);
            canvas.gatShapes().add(shape);
            ShapeAction action = new ShapeActionBuilder().setId(shape.getId()).setAction(ShapeAction.ADDACTION).setShape(ShapeAction.ellipse).setStartx(shape.getXstart()).setStarty(shape.getYstart()).setEndx(shape.getXend()).setEndy(shape.getYend()).setPrimaryColor(shape.getPrimaryColor()).setEdgeColor(shape.getEdgeColor()).setShapeShadingType(shape.getShapeShadingType()).createShapeAction();
            canvas.addComponent(shape);
            canvas.undoList.add(action);

        }
        if(copy.getType() == 3){
            BasicShape shape = new TriangleShape(copy.getXstart(),copy.getYstart(),copy.getXend(), copy.getYend(),copy.getPrimaryColor(),copy.getEdgeColor(),
                    copy.getShapeShadingType(), canvas.getSelected() ,canvas);
            canvas.gatShapes().add(shape);
            ShapeAction action = new ShapeActionBuilder().setId(shape.getId()).setAction(ShapeAction.ADDACTION).setShape(ShapeAction.triangle).setStartx(shape.getXstart()).setStarty(shape.getYstart()).setEndx(shape.getXend()).setEndy(shape.getYend()).setPrimaryColor(shape.getPrimaryColor()).setEdgeColor(shape.getEdgeColor()).setShapeShadingType(shape.getShapeShadingType()).createShapeAction();
            canvas.addComponent(shape);
            canvas.undoList.add(action);

        }
        canvas.repaint();
    }
}
