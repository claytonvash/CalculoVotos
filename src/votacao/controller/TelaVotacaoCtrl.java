package votacao.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import votacao.model.VotacaoSimples;


public class TelaVotacaoCtrl implements ActionListener{

	private VotacaoSimples enquete;

	public TelaVotacaoCtrl(VotacaoSimples enquete){
		this.enquete = enquete;
	}

	public void actionPerformed(ActionEvent event) {
		enquete.votar(event.getActionCommand());
	}

}
