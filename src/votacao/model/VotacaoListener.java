package votacao.model;

import java.util.EventListener;

public interface VotacaoListener extends EventListener {


	public void novoVoto(VotacaoEvent event);

	public void novaOpcao(VotacaoEvent event);
}
