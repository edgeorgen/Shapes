package view.gui;

import model.ShapeShadingType;
import model.StartAndEndPointMode;
import view.interfaces.IDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public abstract class BasicShape extends JComponent implements IDraw {
    private static int ID = 1;
    private int width;
    private int height;
    private Color PrimaryColor;
    private Color EdgeColor;
    private ShapeShadingType shapeShadingType;
    private int[] selected;
    public PaintCanvas canvas;
    private int xstarted = -1;
    private int ystarted = -1;
    private int xstart;
    private int ystart;
    private int xend;
    private int yend;
    private int xended = -1;
    private int yended = -1;

    public int getId() {
        return id;
    }

    private int id;

    public BasicShape(int xstart, int ystart, int xend, int yend, Color PrimaryColor, Color EdgeColor, ShapeShadingType shapeShadingType,
        int[] selected, PaintCanvas canvas){
        this.id = ID++;
        this.xstart = xstart;
        this.ystart = ystart;
        this.xend = xend;
        this.yend = yend;
        this.PrimaryColor = PrimaryColor;
        this.EdgeColor = EdgeColor;
        this.shapeShadingType = shapeShadingType;
        this.selected = selected;
        this.canvas = canvas;
        this.width = Math.abs(xend - xstart);
        this.height = Math.abs(yend - ystart);
        this.setBounds(xstart,ystart,width,height);
        System.out.println("Adding " + id + " : " + selected[0] );
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setSelected(true);
            }
            public void mouseReleased(MouseEvent e){
                released(e);
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                drag(e);
            }
        });

    }

    public void setSelected( boolean f ) {
        System.out.println( "sel " + id + " " + selected[0]);
        if(canvas.getState().getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)){
            selected[0] = id;
            canvas.repaint();
        }

    }

    public void drag(MouseEvent e){

        if(canvas.getState().getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)){
            if(xstarted== -1 && ystarted == -1){
                xstarted = xstart;
                ystarted = ystart;
                xended = xend;
                yended = yend;
            }
            else{
                xstart = xstarted + e.getX();
                ystart = ystarted + e.getY();
                xend = xended + e.getX();
                yend = yended + e.getY();
            }
            canvas.repaint();
        }
    }

    public void released(MouseEvent e){
        if(canvas.getState().getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)){
            ShapeAction action2 = new ShapeActionBuilder().setId(id).setAction(ShapeAction.MOVEACTION).setShape(canvas.getState().getActiveShapeType().ordinal()).setStartx(xstarted).setStarty(ystarted).setEndx(xended).setEndy(yended).setPrimaryColor(PrimaryColor).setEdgeColor(EdgeColor).setShapeShadingType(shapeShadingType).createShapeAction();
            canvas.undoList.add(action2);
            this.width = Math.abs(xend - xstart);
            this.height = Math.abs(yend - ystart);
            this.setBounds(xstart,ystart,width,height);
            canvas.repaint();
            xstarted = -1;
            ystarted = -1;
            xended = -1;
            yended = -1;
        }
    }



    public boolean isSelected(){
        return selected[0] == id;
    }

     public int getWidth(){
         return width;
        }

     public int getHeight(){
         return height;
        }

     public Color getEdgeColor() {
        return EdgeColor;
    }

    public Color getPrimaryColor() {
        return PrimaryColor;
    }

    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }

    public int getXstart() {
        return xstart;
    }

    public void setXstart(int xstart) {
        this.xstart = xstart;
    }

    public int getYstart() {
        return ystart;
    }

    public void setYstart(int ystart) {
        this.ystart = ystart;
    }

    public int getXend() {
        return xend;
    }

    public void setXend(int xend) {
        this.xend = xend;
    }

    public int getYend() {
        return yend;
    }

    public void setYend(int yend) {
        this.yend = yend;
    }
}
