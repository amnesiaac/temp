package entidades;
import java.awt.*;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class Jogador{
   private int x,y,altura,largura;
   private Image Jsprite;
   //private BufferedImage Jsprite;
   private boolean visivel;
   private int Velocidade = 5;
  private boolean morto;
   private ArrayList<Projetil>balas;
   
   public Jogador() {
	   this.morto=false;
	   this.visivel=true;
	   ImageIcon nave =new ImageIcon("recursos//naveplayer.png");
       Jsprite=nave.getImage();
	  /* try {
		Jsprite = ImageIO.read(getClass().getResourceAsStream("/naveplayer.png"));
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("não funciona");
	}*/
	   balas = new ArrayList<Projetil>();
	   this.altura=Jsprite.getHeight(null)-10;
	   this.largura=Jsprite.getWidth(null)-10;
	   this.x=100;
	   this.y=100;
   }
   public void draw(Graphics g) {
	   g.drawImage(this.getSprite(),this.getX(),this.getY(), null); 
	   }
   public void move(int dx, int dy) {
	//	System.out.println("dx"+dx+" dy:"+dy);

	   x+=dx;
	   y+=dy;
	
   }
   public int getVelocidade() {
	   return Velocidade;
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
   public Image getSprite() {
	   return Jsprite;
   }
   public boolean isVisible() {
	   return visivel;
   }
   public boolean isMorto() {
	   return morto;
   }
   public void setVisivel(boolean Visivel) {
	   this.visivel=Visivel;
   }
   public void setMorto(boolean morto) {
	   this.morto=morto;
   }
   public void shoot() {
	   this.balas.add(new Projetil(this.x+largura,this.y+altura/2));
   }
   public Rectangle getBounds() {
	   return new Rectangle(x,y,largura-5,altura-10);
   }

}
