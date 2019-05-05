package votacao.model;

import java.util.EventObject;

public class VotacaoEvent extends EventObject {

	private String opcao = null;
	private int votos = 0;

	public VotacaoEvent(VotacaoSimples source){
		super(source);
	}
	public VotacaoEvent(VotacaoSimples source,String opcao){
		this(source);
		this.opcao = opcao;
	}

	public String getOpcao() {
		return opcao;
	}

	
	public int getVotos() {
		return ((VotacaoSimples)this.source).getVotos(opcao);
	}

	public int getTotalVotos() {
		return ((VotacaoSimples)this.source).getTotalVotos();
	}

}
