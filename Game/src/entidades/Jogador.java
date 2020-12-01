package entidades;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
public class Jogador{
   private int x,y,altura,largura;
 
   private BufferedImage Jsprite;
   private boolean visivel;
 
   private ArrayList<Projetil>balas;
   
   public Jogador() {
	   try {
		Jsprite = ImageIO.read(getClass().getResourceAsStream("/naveplayer.png"));
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("não funciona");
	}
	   balas = new ArrayList<Projetil>();
	   this.altura=Jsprite.getHeight();
	   this.largura=Jsprite.getWidth();
	   this.x=100;
	   this.y=100;
   }
   public void move(int dx, int dy) {
	   x+=dx;
	   y+=dy;
	   if(this.x<1) {
		   x=1;
	   }
	   if(this.x>800) {
		   x=800;
	   }
	   if(this.y<1) {
		  y=1;
	   }
	  if(this.y>600) {
		  y=600;
	   }
   }
   public ArrayList<Projetil> getBalas(){
	   return balas;
  }
   public int getX() {
       return x;
   }

   public int getY() {
       return y;
   }
   public BufferedImage getSprite() {
	   return Jsprite;
   }
   public boolean isVisible() {
	   return visivel;
   }
   public void shoot() {
	   this.balas.add(new Projetil(this.x+largura,this.y+altura/2));
   }
   public Rectangle getBounds() {
	   return new Rectangle(x,y,largura-5,altura-10);
   }

}
