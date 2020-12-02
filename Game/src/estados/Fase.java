package estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entidades.Inimigo;
import entidades.Jogador;
import entidades.Projetil;

public class Fase extends ControleEstados  {
	BufferedImage bgimg;
	private Jogador jogador = new Jogador();
	int dx,dy;
	private boolean Playin;
	private int x=0;
	private ArrayList<Inimigo> inimigos;
	  private int[][] coordenadas = {
			    {760, 50}, {790, 150}, {1980, 209}, {560, 45}, {510, 70},
			    {930, 159}, {590, 80}, {530, 60}, {940, 59}, {990, 30},
			    {920, 200}, {900, 259}, {660, 50}, {540, 90}, {810, 220},
			    {860, 20}, {740, 180}, {820, 128}, {490, 170}, {700, 30},
			    {920, 300}, {856, 328}, {456, 320}};
 
 public Fase(Controlador control) {
	init();
 }
	@Override
	public void init() {
		Playin = true;
		inimigos = new ArrayList<Inimigo>();
		if(x!=0 && jogador.isMorto()==false && inimigos.size()==0) {
			int a=10;
			for(int i=0;i<coordenadas.length+a;i++) {
				inimigos.add(new Inimigo(coordenadas[i][0], coordenadas[i][1]));
				a+=10;
			}
		}
		for(int i=0;i<coordenadas.length;i++) {
			inimigos.add(new Inimigo(coordenadas[i][0], coordenadas[i][1]));
		}
		 try {
			bgimg = ImageIO.read(getClass().getResourceAsStream("/spacebackground.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("não funciona");

		}
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//System.out.println("patricio sociopata");
		if(Playin) {
		jogador.move(dx, dy);
		ArrayList<Projetil> balas = jogador.getBalas();
	     for(int i=0;i<balas.size();i++) {
	    	 Projetil p = (Projetil) balas.get(i);
	   	 if(p.isVisible()) {
	    		 p.atira();
	    	 }else {
	    		 balas.remove(i);
	    	 }
	     }
	     for (int i = 0; i < inimigos.size(); i++) {
	            Inimigo Ini = (Inimigo) inimigos.get(i);
	            if (Ini.isVisible()) {
	                Ini.move();
	            } else {
	                inimigos.remove(i);
	            }
	            
	        }
	     if (inimigos.size()==0) {
	    	 x++;
	     }
	     Colisão();
	     
	    
	    if(Playin==false) {
	    	System.out.println(control.currentState);
			   System.out.println("entrou");
			    control.setState(Controlador.GAMEOVER);
			    
		   }
}
	
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		//System.out.println("draw funciona");
       if(Playin) {
		 g.drawImage(bgimg, 0, 0, null);
	   if(jogador.isVisible()) {
		 jogador.draw(g);
	   }
	     ArrayList<Projetil> balas = jogador.getBalas();
	      for(int i=0;i<balas.size();i++) {
	   	 Projetil p = (Projetil) balas.get(i);
	   	 g.drawImage(p.getSprite(),p.getX(),p.getY(),null);
	    }
	      for (int i = 0; i < inimigos.size(); i++) {
              Inimigo ini = (Inimigo) inimigos.get(i);
              g.drawImage(ini.getSprite(), ini.getX(), ini.getY(), null);
          }
       }else {
    	   g.dispose();
       }
	     g.setColor(Color.white);
	     g.drawString("INIMIGOS:"+inimigos.size(),5,15);
	     if(x!=0 && jogador.isMorto()==false && inimigos.size()==0) {
	    	 if(Playin) {
	    		 g.drawImage(bgimg, 0, 0, null);
	    	   if(jogador.isVisible()) {
	    		 jogador.draw(g);
	    	   }
	    	     ArrayList<Projetil> balas1 = jogador.getBalas();
	    	      for(int i=0;i<balas1.size();i++) {
	    	   	 Projetil p = (Projetil) balas1.get(i);
	    	   	 g.drawImage(p.getSprite(),p.getX(),p.getY(),null);
	    	    }
	    	      for (int i = 0; i < inimigos.size(); i++) {
	                  Inimigo ini = (Inimigo) inimigos.get(i);
	                  g.drawImage(ini.getSprite(), ini.getX(), ini.getY(), null);
	              }
	    	     g.setColor(Color.white);
	    	     g.drawString("INIMIGOS:"+inimigos.size(),5,15);
	     }else {
	    	 g.dispose();
	     }
       }
       
		}
public void Colisão() {
	if(Playin) {
	Rectangle HboxJogador = jogador.getBounds();
	Rectangle HboxInimigo;
	Rectangle HboxProj;
	 for (int i = 0; i < inimigos.size(); i++) {
         Inimigo Ini = inimigos.get(i);
         HboxInimigo = Ini.getBounds();
         if (HboxJogador.intersects(HboxInimigo)) {
            //jogador.setVisivel(false);
          jogador.setMorto(true);
             //Ini.setVisivel(false);
            Playin = false;
         }
     }
	 ArrayList<Projetil> balas = jogador.getBalas();
     for(int i=0;i<balas.size();i++) {
    	 Projetil p = balas.get(i);
    	 HboxProj = p.getBounds();
    	 for (int j = 0; j < inimigos.size(); j++) {
             Inimigo Ini = inimigos.get(j);
             HboxInimigo = Ini.getBounds();
             if(HboxProj.intersects(HboxInimigo)) {
            	 Ini.setVisivel(false);
            	 p.setVisible(false);
             }
    	 }
     }
}
}
	
	

	
	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub 
		 if(k==KeyEvent.VK_UP){
	         dy=-3;
	    //     System.out.println("cima");
	     }
	     if(k==KeyEvent.VK_DOWN){
	         dy=3;
	     //    System.out.println("baixo");
	     }
	     if(k==KeyEvent.VK_LEFT){
	         dx=-3; 
	      //   System.out.println("Left");
	     }
	     if(k==KeyEvent.VK_RIGHT){
	         dx=3;
	      //   System.out.println("direita");
	     }
	     if(k==KeyEvent.VK_Z){
	         jogador.shoot();
	       //  System.out.println("atira");
	     }
	}
	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	

}

