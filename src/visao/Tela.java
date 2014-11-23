package visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class Tela {
	
	private JFrame janela;
	private JPanel painelPrincipal;
	private JTable campo;
	
	public void montaTela(){
		preparaJanela();
		preparaPainelPrincipal();
		preparaCampo();
		preparaBotaoJogar();
		preparaBotaoSair();
		mostraJanela();
	}

	private void preparaJanela(){
		janela = new JFrame("Game");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void mostraJanela() {
	    janela.pack();
	    janela.setSize(700, 700);
	    janela.setVisible(true);
	}
	
	private void preparaPainelPrincipal() {
		  painelPrincipal = new JPanel();
		  janela.add(painelPrincipal);
	}
	
	private void preparaBotaoJogar() {
		JButton botaoJogar = new JButton("Jogar");
		botaoJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				preparaCampo();
				//Sistema.inciarPartida();
			}
		});
		painelPrincipal.add(botaoJogar);
	}
	
	private void preparaBotaoSair() {
	  JButton botaoSair = new JButton("Sair");
	  botaoSair.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	      System.exit(0);
	    }
	  });
	  painelPrincipal.add(botaoSair);
	}
	
	private void preparaCampo(){
		campo = new JTable();
		InterfaceCampo ui = new InterfaceCampo();
		campo.setModel(ui);
	}
	
}
