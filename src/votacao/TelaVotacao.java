package votacao;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.List;


public class TelaVotacao extends Frame implements ActionListener{

	private TelaResultado telaResult;
	private TelaResultadoPercentual telaResultPerc;

	private Map opcoes;
	private List listaOpcoes;

	public TelaVotacao(){
		super("Tela de Votação - Votacao");

		telaResult = new TelaResultado(this);
		telaResult.setLocation(120,5);

		telaResultPerc = new TelaResultadoPercentual(this);
		telaResultPerc.setLocation(250,5);


		listaOpcoes = new Vector();
		this.opcoes = new HashMap();

		this.adicionaOpcao("Opção 1");
		this.adicionaOpcao("Opção 2");
		this.adicionaOpcao("Opção 3");
		this.adicionaOpcao("Opção 4");
		criarBotoes();

		telaResult.inicializar(listaOpcoes.iterator());
		telaResultPerc.inicializar(listaOpcoes.iterator());


		this.setSize(100,120);
		this.setLayout(new GridLayout(0,1));
	    this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	        	e.getWindow().hide();
	        	System.exit(0);
	        }
	    });
		this.show();
		telaResult.show();
		telaResultPerc.show();
	}

	private void adicionaOpcao(String opcao){
		listaOpcoes.add(opcao);
		this.opcoes.put(opcao,new Integer(0));
	}

	public void criarBotoes() {
		Iterator it = listaOpcoes.iterator();
		String opcao;
		Button botao;
		while(it.hasNext()){
			opcao = (String)it.next();
			botao = new Button(opcao);
			botao.setActionCommand(opcao);
			botao.addActionListener(this);
			this.add(botao);
		}
	}


	public void actionPerformed(ActionEvent event) {
		String opcao = event.getActionCommand();
		this.votar(opcao); 

		telaResult.novoVoto(opcao,getVotos(opcao));

		telaResultPerc.novoVoto(opcao,getVotos(opcao),getTotalVotos());
	}

	public void votar(String opcao){
		int votoAtual = ((Integer)this.opcoes.get(opcao)).intValue();
		this.opcoes.put(opcao,new Integer(++votoAtual));
	}

	public int getTotalVotos(){
		Iterator votos = this.opcoes.values().iterator();
		int total = 0;
		while(votos.hasNext()){
			total+= ((Integer)votos.next()).intValue();
		}
		return total;
	}


	public int getVotos(String opcao){
		return ((Integer)this.opcoes.get(opcao)).intValue();
	}

}
