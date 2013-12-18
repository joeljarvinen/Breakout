/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import breakout.Breakout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import util.PaddleKeyListener;
import util.PaddleMouseMotionListener;

/**
 *
 * @author Joel
 */
public class Gui implements Runnable {
    private JFrame frame;
    private Canvas canvas;
    private final Breakout breakout;

    public Gui(Breakout breakout) {
        this.breakout = breakout;
    }

    
    
    @Override
    public void run() {
        frame = new JFrame("Breakout");
        frame.setPreferredSize(new Dimension(800, 640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        canvas = new Canvas(breakout.getPaddle(), breakout.getBall());
        container.add(canvas);
        
        PaddleKeyListener pkl = new PaddleKeyListener(breakout.getPaddle());
        frame.addKeyListener(pkl);
        
        PaddleMouseMotionListener pmml = new PaddleMouseMotionListener(breakout.getPaddle());
        frame.addMouseMotionListener(pmml);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Updatable getUpdatable() {
        return this.canvas;
    }

}
