package estados;
import java.awt.*;
import java.awt.event.KeyEvent;
public class Menu  extends ControleEstados{
	private int currentChoice = 0;
	private String[] options = {
			"Iniciar Jogo",
			"Como Jogar",
			"Sair"
	};
	private Color titleColor;
	private Font titleFont;

	private Font font;	
	 public Menu(Controlador control) {
		 this.control = control;
		 try {
			 titleColor = new Color(128,0,0);
			 titleFont = new Font("Century Gothic",Font.PLAIN,28);
			 font = new Font ("Arial", Font.PLAIN,12);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }

	@Override
	public void init() {
		
	}

	@Override
	public void update() {
	
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("???game",50,70);
		
		g.setFont(font);
		for(int i=0;i<options.length;i++) {
			if(i==currentChoice) {
				g.setColor(Color.YELLOW);
			}else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 140 + i*15);
		}
	}
	private void select() {
		if(currentChoice ==0) {
			control.setState(Controlador.FASE);
		}
		if(currentChoice ==1) {
			control.setState(Controlador.GAMEOVER);
		}
		if(currentChoice ==2) {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_ENTER) {
			select();
		}
		if(k==KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice==-1) {
				currentChoice = options.length -1;
			}
		}
		if(k==KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice =0;
				 
			}
		}
	}

	@Override
	public void keyReleased(int k) {

	}
	}


