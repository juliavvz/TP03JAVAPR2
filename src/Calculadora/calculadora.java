import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora extends JFrame implements ActionListener {
    private JTextField display;
    private double valorAtual = 0;
    private String operador = "";
    private boolean novoNumero = true;

    public calculadora() {
        // Configuração do Form (Janela)
        setTitle("Calculadora");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Campo de texto para o resultado
        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4, 5, 5));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.addActionListener(this);
            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        try {
            if ("0123456789".contains(comando)) {
                if (novoNumero) {
                    display.setText(comando);
                    novoNumero = false;
                } else {
                    display.setText(display.getText() + comando);
                }
            } else if ("C".equals(comando)) {
                // Limpa a memória e o text field
                valorAtual = 0;
                operador = "";
                display.setText("0");
                novoNumero = true;
            } else if ("=".equals(comando)) {
                calcular();
                operador = "";
                novoNumero = true;
            } else {
                // Operadores: +, -, *, /
                calcular();
                operador = comando;
                novoNumero = true;
            }
        } catch (ArithmeticException ex) {
            display.setText("Erro: Div/0");
            valorAtual = 0;
            operador = "";
        } catch (Exception ex) {
            display.setText("Erro");
        } finally {
            // Bloco finally sempre executa, independentemente de erros
            System.out.println("Comando processado no Form: " + comando);
        }
    }

    private void calcular() throws ArithmeticException {
        if (!operador.isEmpty() && !novoNumero) {
            double valorDisplay = Double.parseDouble(display.getText());
            if (operador.equals("+")) valorAtual += valorDisplay;
            else if (operador.equals("-")) valorAtual -= valorDisplay;
            else if (operador.equals("*")) valorAtual *= valorDisplay;
            else if (operador.equals("/")) {
                if (valorDisplay == 0) throw new ArithmeticException("Divisão por zero");
                valorAtual /= valorDisplay;
            }
            display.setText(String.valueOf(valorAtual));
        } else {
            valorAtual = Double.parseDouble(display.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new calculadora().setVisible(true);
        });
    }
}
