package entidades;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Game;
public class Projetil {
	private int x,y,largura,altura;
	private boolean visivel;
	private Game g = new Game();;
	private static final int velocidade = 5;
	private int telaboundsaltura = g.getHeight();
	private int telaboundslargura = g.getWidth();
	BufferedImage projsprite;
	
	public Projetil(int x ,int y) {
		    this.visivel=true;
	        this.x=x;
	        this.y=y;
	        try {
				projsprite = ImageIO.read(getClass().getResourceAsStream("/projetil.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("não funciona");
			}
	        this.altura=projsprite.getHeight(null);
	        this.largura=projsprite.getWidth(null);
	        
	}
	public void atira() {
		this.x+=velocidade;
		if(this.x>=telaboundsaltura||this.y>=telaboundslargura){
            visivel=false;
        }
	}
	  public BufferedImage getSprite() {
	        return projsprite;
	    }

	    public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }

	    public boolean isVisible() {
	        return visivel;
	    }
	        public void setVisible(boolean isVisible) {
	        this.visivel= isVisible;
	    }

	        public Rectangle getBounds(){
	        return new Rectangle(x,y,largura,altura); 
	        
	    }
	
	
}
