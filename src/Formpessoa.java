import java.awt.*;
import javax.swing.*;

public class Formpessoa extends JFrame {

    private JTextField txtNumero = new JTextField();
    private JTextField txtNome = new JTextField();
    private JTextField txtSexo = new JTextField();
    private JTextField txtIdade = new JTextField();

    private Pessoa UmaPessoa = new Pessoa();

    public Formpessoa() {
        setTitle("Semana 06 - Exercicio 01");
        setSize(420, 190);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtNumero.setEditable(false);

        JPanel campos = new JPanel(new GridLayout(4, 2, 2, 2));
        campos.add(new JLabel("Numero:"));
        campos.add(txtNumero);
        campos.add(new JLabel("Nome:"));
        campos.add(txtNome);
        campos.add(new JLabel("Sexo:"));
        campos.add(txtSexo);
        campos.add(new JLabel("Idade:"));
        campos.add(txtIdade);

        JButton btnOk = new JButton("OK");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnSair = new JButton("Sair");

        JPanel botoes = new JPanel(new GridLayout(1, 4, 2, 2));
        botoes.add(btnOk);
        botoes.add(btnLimpar);
        botoes.add(btnMostrar);
        botoes.add(btnSair);

        btnOk.addActionListener(e -> confirmar());
        btnLimpar.addActionListener(e -> limpar());
        btnMostrar.addActionListener(e -> mostrar());
        btnSair.addActionListener(e -> System.exit(0));

        add(campos, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);
    }

    // Botão OK: valida e transfere os dados para UmaPessoa
    private void confirmar() {
        String nome = txtNome.getText().trim();
        String sexo = txtSexo.getText().trim().toUpperCase();
        String idadeTxt = txtIdade.getText().trim();

        if (nome.isEmpty() || sexo.isEmpty() || idadeTxt.isEmpty()) {
            erro("Nome, Sexo e Idade são de preenchimento obrigatório.");
            return;
        }
        if (!sexo.equals("M") && !sexo.equals("F")) {
            erro("O campo Sexo só aceita M ou F.");
            txtSexo.requestFocus();
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeTxt);
        } catch (NumberFormatException ex) {
            erro("A idade deve ser um número inteiro.");
            txtIdade.requestFocus();
            return;
        }
        if (idade < 0) {
            erro("A idade não pode ser negativa.");
            txtIdade.requestFocus();
            return;
        }

        UmaPessoa.setNome(nome);
        UmaPessoa.setSexo(sexo.charAt(0));
        UmaPessoa.setIdade(idade);
        UmaPessoa.setKp();

        JOptionPane.showMessageDialog(this, "Dados gravados! Pessoas setadas: " + UmaPessoa.getKp());
    }

    // Botão Mostrar: descarrega os dados de UmaPessoa (inclusive kp) nos campos
    private void mostrar() {
        if (UmaPessoa.getKp() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma pessoa foi gravada ainda.");
            return;
        }
        txtNumero.setText(String.valueOf(UmaPessoa.getKp()));
        txtNome.setText(UmaPessoa.getNome());
        txtSexo.setText(String.valueOf(UmaPessoa.getSexo()));
        txtIdade.setText(String.valueOf(UmaPessoa.getIdade()));
    }

    private void limpar() {
        txtNumero.setText("");
        txtNome.setText("");
        txtSexo.setText("");
        txtIdade.setText("");
        txtNome.requestFocus();
    }

    private void erro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new Formpessoa().setVisible(true);
    }
}