package Gallhp;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.lang.Math;

import common.Simulator_Interface;
/**
 * A class that demonstrates how to draw temperature grids in Java.
 * Displays a square grid in which the cells are painted with
 *   a random intensity of the Color red.
 * 
 * @author Spencer Rugaber, January, 2009
 */
public class DrawnGrid extends JPanel {

    /**
     * Creates a DrawnGrid, which is a displayable rectangle.  
     * All units are in pixels.
     *
     * @param x X coordinate of the upper left hand corner of the
     *                 rectangle within the containing widget
     * @param y Y coordinate of the upper left hand corner of the
     *                 rectangle within the containing widget
     * @param w width of the rectangle
     * @param h height of the rectangle
     */
    public DrawnGrid(int x, int y, int w, int h, int num_rows, int num_cols, Simulator_Interface sim) {
        ulhcX = x;
        ulhcY = y;
        width = w;
        height = h;
        row_count = num_rows;
        col_count = num_cols;
        simulator = sim;
        heating_done = false;
    }

    /**
     * Informs Swing of how much space is needed for drawing.
     * 
     * @return Dimension - the size of the drawing area
     * @override getPreferredSize in JPanel
     * @see javax.swing.JComponent#getPreferredSize()
     */
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    
    /**
     * Paints one cell of the grid.
     *
     * @param aGraphics Graphics into which painting will be done
     * @param row row number of the grid cell
     * @param col column number of the grid cell
     * @param t intensity of Color red to be painted; a number from 0.0 to 1.0
     */
    private void paintSpot(Graphics aGraphics, int row, int col, double t) {
        int rowPos = ulhcY + row * cell_height();
        int colPos = ulhcX + col * cell_width();

        // Overwrite everything that was there previously
        aGraphics.setColor(Color.black);
        aGraphics.fillRect(colPos, rowPos, cell_width(), cell_height());
        
        // Color in RGB format with green and blue values = 0.0
        aGraphics.setColor(new Color((float)t, 0.f, 0.f));    
        aGraphics.fillRect(colPos, rowPos, cell_width(), cell_height());
    }

    /**
     * Informs Swing how to render in terms of subcomponents.
     * @param aGraphics Graphics - Graphs context for drawing
     * @override paintComponent in JPanel
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics aGraphics) {
        super.paintComponent(aGraphics);
        
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics anotherGraphics = bi.createGraphics();
        heating_done = simulator.heat_once(.01);
        for (int i = 0; i < row_count; i++)
            for (int j = 0; j < col_count; j++)
                paintSpot(anotherGraphics, i, j, Math.random());
        
        aGraphics.drawImage(bi, 0, 0, this);
   }
    
    /**
     * Size of the containing window in pixels
     */
    private final static int WINDOW_SIZE = 400;
    
    /**
     * Amount of border space around the DrawnGrid in pixels
     */
    private final static int BORDER_SIZE = 50;

    /**
     * Height and width of the DrawnGrid in pixels 
     */
    private int grid_size(){
    	return WINDOW_SIZE - 2 * BORDER_SIZE;
    }
    
    /**
     * The height of a cell in pixels 
     */
    private int cell_height(){
    	return grid_size() / col_count;
    }

    /**
     * The width of a cell in pixels
     */
    private int cell_width(){
    	return grid_size() / row_count;
    }

    /**
     * X-coordinate of the upper left hand corner of the rectangle
     *     within the containing widget
     */    
    private int ulhcX;
    
    /**
     * Y-coordinate of the upper left hand corner of the rectangle
     *     within the containing widget
     */
    private int ulhcY;
    
    /**
     * Width of the rectangle in pixels
     */
    private int width;
    
    /** 
     * Height of the rectangle in pixels
     */
    private int height;
    
    /**
     * Number of rows of cells in the DrawnGrid 
     */
    private int row_count;
    
    /**
     * Number of cells in a row 
     */
    private int col_count;
    
    /**
     * A simulator instance to heat and fetch values from.
     */
    private Simulator_Interface simulator;
    
    /**
     * Keeps track of whether the heating is done or not.
     */
    private boolean heating_done;
}