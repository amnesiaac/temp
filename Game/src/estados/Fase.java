package estados;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


import entidades.Jogador;
import entidades.Projetil;

public class Fase extends ControleEstados  {
	BufferedImage bgimg;
	private Jogador jogador = new Jogador();
	int dx,dy;
	
 
 public Fase(Controlador control) {
	init();
 }
	@Override
	public void init() {
		
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
	
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		 g.drawImage(bgimg, 0, 0, null);
	     g.drawImage(jogador.getSprite(),jogador.getX(),jogador.getY(), null);
	     ArrayList<Projetil> balas = jogador.getBalas();
	      for(int i=0;i<balas.size();i++) {
	   	 Projetil p = (Projetil) balas.get(i);
	   	 g.drawImage(p.getSprite(),p.getX(),p.getY(),null);
	    }
	     g.dispose();
	     g.setColor(Color.white);
	     g.drawString("INIMIGOS:",5,15);
		}

     
	
	

	
	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub 
		 if(k==KeyEvent.VK_UP){
	         dy=-3;
	         System.out.println("cima");
	     }
	     if(k==KeyEvent.VK_DOWN){
	         dy=3;
	         System.out.println("baixo");
	     }
	     if(k==KeyEvent.VK_LEFT){
	         dx=-3;
	         System.out.println("Left");
	     }
	     if(k==KeyEvent.VK_RIGHT){
	         dx=3;
	         System.out.println("direita");
	     }
	     if(k==KeyEvent.VK_Z){
	     //    jogador.shoot();
	         System.out.println("atira");
	     }
	}
	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	

}

