package votacao.model;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VotacaoSimples {

	private Map <String, Integer> opcoes;
	private List <VotacaoListener>votacaoListeners = new LinkedList();

	public VotacaoSimples(){
		opcoes = new HashMap<String, Integer>();
	}

	
	public void addOpcao(String opcao){
		opcoes.put(opcao,new Integer(0));
		this.disparaNovaOpcao(opcao);
	}

	
	public Set <String> getOpcoes(){
		return opcoes.keySet();
	}

	
	public void votar(String opcao){
		int votoAtual = (opcoes.get(opcao)).intValue();
		opcoes.put(opcao,new Integer(++votoAtual));
		this.disparaNovoVoto(opcao);
	}

	
	public int getTotalVotos(){
		int total = 0;
		for(Integer votos : opcoes.values()){
			total+= votos.intValue();
		}
		return total;
	}

	
	public int getVotos(String opcao){
		return (opcoes.get(opcao)).intValue();
	}


	
	public synchronized void addEnqueteListener(VotacaoListener listener){
		if(votacaoListeners.contains(listener)){ return; }
		this.votacaoListeners.add(listener);
	}

	
	private synchronized void disparaNovoVoto(String opcao){		
		for(VotacaoListener listeners : this.votacaoListeners){
			listeners.novoVoto(new VotacaoEvent(this,opcao));
		}
	}

	
	private synchronized void disparaNovaOpcao(String opcao){		
		for(VotacaoListener listeners : this.votacaoListeners){
			listeners.novaOpcao(new VotacaoEvent(this,opcao));
		}
	}

}
