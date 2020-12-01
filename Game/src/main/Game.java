package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import estados.Controlador;	

public class Game extends JPanel implements Runnable, KeyListener {
	public static final int WIDTH =800;
	public static final int HEIGHT = 600;
	public static final int SCALE=2;
	
	private Thread thread;
	private boolean running;
	private int FPS	= 60;
	private long targetTime = 1000/FPS;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private Controlador control;
	public int getWidth() {
		return this.WIDTH;
	}
	public int getHeight() {
		return this.HEIGHT;
	}
	public Game() {
		super();
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setFocusable(true);
		requestFocus();	
	}
	@Override
	public void run() {
		init();
		long start;
		long elapsed;
		long wait;
		while(running) {
			start = System.nanoTime();
			update();
			draw();
			drawToScreen();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed /1000000;
			if(wait<0) wait =5;
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void addNotify() {
		super.addNotify();
		if(thread ==null) {
		  thread = new Thread(this);
			addKeyListener(this);
		thread.start();	
		}
	}
	private void init() {
		image= new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		control = new Controlador();
	}
	private void update() {
		control.update();
	}
	private void draw() {
		control.draw(g);
	}
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0,WIDTH*SCALE, HEIGHT*SCALE, null);
		g2.dispose(); 
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		control.keyPressed(e.getKeyCode());
	
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		control.keyReleased(e.getKeyCode());		
		
	}
}
