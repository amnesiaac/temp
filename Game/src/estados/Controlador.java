package estados;

import java.util.ArrayList;

//import estados.GameOverState;
import estados.ControleEstados;
//import estados.Level1State;
import estados.Menu;
public class Controlador {
	private ArrayList<ControleEstados> gamestates;
	 private int currentState;
	 Fase fase = new Fase(this);
	 
	 public static final int MENU=0;
	 public static final int FASE=1;	
	 public static final int GAMEOVERSTATE=2;
	 public Controlador() {
		 gamestates = new ArrayList<ControleEstados>();
		 
		 currentState = MENU;
		 gamestates.add(new Menu(this));
		 gamestates.add(new Fase(this)); 
		 //gamestates.add(new GameOverState(this));
	 }
	 public void setState (int state) {
		  currentState = state;
		  gamestates.get(currentState).init();
	 }
	 public void update() {
		 gamestates.get(currentState).update();
	 }
	 public void draw(java.awt.Graphics2D g) {
		 gamestates.get(currentState).draw(g);
	 }
	 public void keyPressed(int k) {
		 gamestates.get(currentState).keyPressed(k);
	 }
	 public void keyReleased(int k) {
		 gamestates.get(currentState).keyReleased(k);
	 }
	
	}