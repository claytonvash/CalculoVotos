package votacao;

import java.applet.Applet;
import java.awt.*;

public class Votacao extends Applet{

	public static void main(String[] args) {
		Votacao e = new Votacao();
		e.start();
	}

	public void start() {
		super.start();
		TelaVotacao votacao = new TelaVotacao();
		votacao.setLocation(5,5);

	}

}
