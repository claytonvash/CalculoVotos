package votacao.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import votacao.model.*;

public class TelaVotacao extends Frame implements VotacaoListener{


	private Collection <String>botoes = new ArrayList();

	private ActionListener controller;

	public TelaVotacao(ActionListener controller){
		super("Tela de Votação - Votacao");
		this.setSize(300,360);
		this.setLayout(new GridLayout(0,1)); 
		this.controller = controller;
	    this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	        	e.getWindow().hide();
	        	System.exit(0);
	        }
	    });
	}

	
	public void novaOpcao(VotacaoEvent event) {
		String opcao = event.getOpcao();
		Button botao;

		if(!botoes.contains(opcao)){
			botoes.add(opcao);
			botao = new Button(opcao);
			botao.setActionCommand(opcao);
			botao.addActionListener(controller);
			this.add(botao);
		}
	}

	
	public void novoVoto(VotacaoEvent event) {
		
	}

}
