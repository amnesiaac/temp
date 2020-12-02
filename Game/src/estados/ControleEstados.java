package estados;

import java.awt.Graphics;

public abstract class ControleEstados {
	protected Controlador control;
	public abstract void init();
	public abstract void update();	
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
}
