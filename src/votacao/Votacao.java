package votacao;


import java.applet.Applet;
import java.awt.*;

import votacao.controller.*;
import votacao.model.*;
import votacao.view.*;


public class Votacao extends Applet{

	
	public static void main(String[] args) {
		Votacao e = new Votacao();
		e.start();
	}


	
	public void start() {
		super.start();

		
		VotacaoSimples enquete= new VotacaoSimples();

		TelaVotacaoCtrl ctrl = new TelaVotacaoCtrl(enquete);

		TelaVotacao votacao = new TelaVotacao(ctrl);
		votacao.setLocation(5,5);

		TelaResultado resultado = new TelaResultado(votacao);
		resultado.setLocation(120,5);

		TelaResultadoPercentual resultadoPerc = new TelaResultadoPercentual(votacao);
		resultadoPerc.setLocation(250,5);

		enquete.addEnqueteListener(votacao);
		enquete.addEnqueteListener(resultado);
		enquete.addEnqueteListener(resultadoPerc);

		enquete.addOpcao("Opção 1");
		enquete.addOpcao("Opção 2");
		enquete.addOpcao("Opção 3");
		enquete.addOpcao("Opção 4");

		votacao.show();
		resultado.show();
		resultadoPerc.show();
	}

}
