package view.gui;

import model.*;
import model.persistence.ApplicationState;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import static model.ShapeShadingType.FILLED_IN;
import static model.ShapeShadingType.OUTLINE;
import static model.ShapeShadingType.OUTLINE_AND_FILLED_IN;

public class PaintCanvas extends JComponent {
    public ArrayList<ShapeAction> undoList = new ArrayList<ShapeAction>();
    public ArrayList<ShapeAction> redoList = new ArrayList<ShapeAction>();
    private ApplicationState state;
    private int[] selected = {0};
    private PaintCanvas instance;
    private CopyShape copy = CopyShape.getInstance();
    public Context undoContext = new Context(this, new Undo());
    public Context redoContext = new Context(this, new Redo());
    public Context deleteContext = new Context(this, new DeleteStrategy());
    public Context copyContext = new Context(this, new CopyStrategy());
    public Context pasteContext = new Context(this, new PasteStrategy());

    
    ArrayList<BasicShape> shapes = new ArrayList<BasicShape>();
    int initialx = 0;
    int initialy = 0;
    int dragx = 0;
    int dragy = 0;
    private ShapeColor shapecolor;

    public ArrayList<BasicShape> gatShapes() {
        return shapes;
    }

    public ApplicationState getState() {
        return state;
    }
    public void setState(ApplicationState state) {
        this.state = state;
        state.setCanvas(this);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        if (state == null) {
            return;
        }
        if (state.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
            if (state.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
                RectangularShape.drawOutline(g, initialx, initialy, dragx, dragy);
            }
            if (state.getActiveShapeType().equals(ShapeType.ELLIPSE)) {
                EllipseShape.drawOutline(g, initialx, initialy, dragx, dragy);
            }
            if (state.getActiveShapeType().equals(ShapeType.TRIANGLE)) {
                TriangleShape.drawOutline(g, initialx, initialy, dragx, dragy);
            }
        }
        for (BasicShape s : shapes) {
            if (s.getShapeShadingType().equals(FILLED_IN)) {
                s.drawFilled(g);
            }
            if (s.getShapeShadingType().equals(OUTLINE)) {
                s.drawOutline(g);
            }
            if (s.getShapeShadingType().equals(OUTLINE_AND_FILLED_IN)) {
                s.drawBoth(g);
            }
        }

    }

    public PaintCanvas() {

        instance = this;
        
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (state.getActiveStartAndEndPointMode() != StartAndEndPointMode.DRAW) {
                    repaint();
                    return;
                }
                initialx = e.getX();
                initialy = e.getY();
                repaint();
                System.out.println("mousePressed");
            }

            public void mouseReleased(MouseEvent e) {
                selected[0] = 0;
                if (state.getActiveStartAndEndPointMode() != StartAndEndPointMode.DRAW) {
                    repaint();
                    return;
                }
                
                System.out.println( "PaintCanvas : " + selected );
                

                BasicShape r = ShapeFactory.getShape(state.getActiveShapeType(), initialx, initialy, dragx, dragy,
                        state.getActivePrimaryColor().getColor(), state.getActiveSecondaryColor().getColor(), state.getActiveShapeShadingType(),
                         selected, instance);
                ShapeAction action2 = new ShapeActionBuilder().setId(r.getId()).setAction(ShapeAction.ADDACTION).setShape(instance.getState().getActiveShapeType().ordinal()).setStartx(r.getXstart()).setStarty(r.getYstart()).setEndx(r.getXend()).setEndy(r.getYend()).setPrimaryColor(r.getPrimaryColor()).setEdgeColor(r.getEdgeColor()).setShapeShadingType(r.getShapeShadingType()).createShapeAction();
                instance.undoList.add(action2);
                shapes.add(r);
                addComponent(r);
                repaint();
                System.out.println("mouse Released");
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (state.getActiveStartAndEndPointMode() != StartAndEndPointMode.DRAW) {
                    return;
                }
                dragx = e.getX();
                dragy = e.getY();
                repaint();
            }
        });

    }

    public void addComponent(JComponent comp) {
        this.add(comp);
    }
    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
    public CopyShape getCopy() {
        return copy;
    }
    public int[] getSelected() {
        return selected;
    }
}
