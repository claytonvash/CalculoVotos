package votacao;


import java.awt.*;
import java.util.*;

public class TelaResultadoPercentual extends Window{

	private Map labels = new HashMap();

	public TelaResultadoPercentual(Frame parent){
		super(parent);
		this.setSize(180,120);
		this.setLayout(new GridLayout(0,2)); 
		this.add(new Label("Percentual"));
		this.add(new Label());
	}


	public void inicializar(Iterator opcoes) {
		String opcao;

		Label label;
		Label votos;
		while(opcoes.hasNext()){
			opcao = (String)opcoes.next();
			if(!labels.containsKey(opcao)){
				label = new Label(opcao+" - ");
				votos = new Label(""+0+"%");
				labels.put(opcao,votos);
				this.add(label);
				this.add(votos);
			}
		}
	}

	public void novoVoto(String opcao, int nvotos, int total) {
		Label votos;
		votos = (Label)labels.get(opcao);
		votos.setText(""+(nvotos*100/total)+" %");
	}

}
