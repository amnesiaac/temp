package entidades;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.Game;

public class Inimigo {
  private BufferedImage Isprite;
  private int x,y,largura,altura;
  private boolean visivel;
  private Game g = new Game();
  private int telaboundslargura = g.getWidth();
  private int Velocidade = 2;
  
  public Inimigo(int x, int y) {
	  this.visivel=true;
	  this.x=x;
	  this.y=y;
	  try {
		Isprite = ImageIO.read(getClass().getResourceAsStream("/inimigo.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  this.largura=Isprite.getHeight();
	  this.altura=Isprite.getWidth();
  }
  public void move() {
	  if(this.x<0) {
		  this.x=telaboundslargura;
		  
	  }else {
		  this.x-= Velocidade;
	  }
	
	  }
  public BufferedImage getSprite() {
	  return Isprite;
  }
  public void setVisivel(boolean Visivel) {
	   this.visivel=Visivel;
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
  public Rectangle getBounds() {
	  return new Rectangle(x,y,largura,altura);
  }
}
