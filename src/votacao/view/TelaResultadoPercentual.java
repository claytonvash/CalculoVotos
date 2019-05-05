package votacao.view;

import java.awt.*;
import java.util.*;

import votacao.model.VotacaoEvent;
import votacao.model.VotacaoListener;
import votacao.model.VotacaoSimples;

public class TelaResultadoPercentual extends Window implements VotacaoListener{

	private Map <String,Label>labels = new HashMap();

	public TelaResultadoPercentual(Frame parent){
		super(parent);
		this.setSize(180,360);
		this.setLayout(new GridLayout(0,2)); 
		this.add(new Label("Percentual"));
		this.add(new Label());
	}



	
	public void novaOpcao(VotacaoEvent event) {
		String opcao = event.getOpcao();

		Label label;
		Label votos;
		if(!labels.containsKey(opcao)){
			label = new Label(opcao+" - ");
			votos = new Label(""+event.getVotos()+" %");
			labels.put(opcao,votos);
			this.add(label);
			this.add(votos);
		}
	}

	
	public void novoVoto(VotacaoEvent event) {
		String opcao = event.getOpcao();

		Label votos;
		votos = labels.get(opcao);
		votos.setText(""+(event.getVotos()*100/event.getTotalVotos())+" %");
	}


}
