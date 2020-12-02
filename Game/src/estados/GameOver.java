package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameOver extends ControleEstados {
	private int currentChoice = 0;
	private String[] options = {
			"Tentar Novamente",
			"Voltar ao Menu Principal"
	};
	private Color titleColor;
	private Font titleFont;

	private Font font;	

   public GameOver(Controlador control) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("GAME OVER",250,70);
		g.setFont(font);
		for(int i=0;i<options.length;i++) {
			if(i==currentChoice) {
				g.setColor(Color.YELLOW);
			}else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 250, 250 + i*15);
		}
	}
	private void select() {
		if(currentChoice ==0) {
			control.setState(Controlador.FASE);
		}
		if(currentChoice ==1) {
			control.setState(Controlador.MENU);
		}
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}

}
