import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Cadastro_Cliente extends JFrame {

    //! Definindo cada elemento
    private JComboBox<String> TipoJComboBox;
    private JTextField digiteSeuCPFOuTextField;
    private JCheckBox FornecedorCheck;
    private JTextField NomeField;
    private JTextField RGField;
    private JTextField ExpeditorField;
    private JTextField EmailField;
    private JComboBox<String> PaisComboBox;
    private JTextField UFField;
    private JComboBox<String> MunicipioCombobox;
    private JTextField LogradouroField;
    private JTextField NumeroField;
    private JTextField ComplementoField;
    private JTextField BairroField;
    private JTextField TelefoneField;
    private JRadioButton AtivoRadioButton;
    private JRadioButton InativoRadioButton;
    private JButton ConfirmarButton;
    private JButton ExcluirButton;
    private JButton LimparButton;
    private JLabel cadastroLabel, tipoLabel, cpfLabel, fornecedorLabel, nomeLabel,
            rgLabel, expeditorLabel, emailLabel, cepLabel, paisLabel,
            ufLabel, municipioLabel, logradouroLabel, numeroLabel,
            complementoLabel, bairroLabel, telefoneLabel, situacaoLabel, senhaLabel, confirmarsenhaLabel;
    private JTextField CEPField;
    private JPanel painel;
    private JPasswordField senhaField;
    private JPasswordField confirmarsenhaField;

    private void limparCampos() { //! Limpa todos os campos, colocando valores null em Campos String e false em Campos de selecionar, além de retornar a origem em campos de JComboBox
        TipoJComboBox.setSelectedIndex(0);
        digiteSeuCPFOuTextField.setText(null);
        FornecedorCheck.setSelected(false);
        NomeField.setText(null);
        RGField.setText(null);
        ExpeditorField.setText(null);
        EmailField.setText(null);
        PaisComboBox.setSelectedIndex(0);
        UFField.setText(null);
        MunicipioCombobox.setSelectedIndex(0);
        LogradouroField.setText(null);
        NumeroField.setText(null);
        ComplementoField.setText(null);
        BairroField.setText(null);
        TelefoneField.setText(null);
        AtivoRadioButton.setSelected(false); InativoRadioButton.setSelected(false);
        senhaField.setText(null);
        confirmarsenhaField.setText(null);
    }

    private void SairPrograma(){ //! A função mostra uma janela, se a pessoa confirmar o programa fecha, se ela não concordar o programa continua ativo
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja Sair Do Programa?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Saindo...");
            System.exit(0);
        }
    }

    private void Salvar(){
    String senha = new String(senhaField.getPassword());
    String confirmarSenha = new String(confirmarsenhaField.getPassword());

    if(digiteSeuCPFOuTextField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo Cpf/Cnpj é obrigatorio");
        return;
    }

    if (NomeField.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "O campo Nome é obrigatório.");
        return;
    }

    if (RGField.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "O campo RG é obrigatório.");
        return;
    }

    if (ExpeditorField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo de Orgão Expeditor é obrigatorio");
        return;
    }

    if(EmailField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo de email é obrigatorio");
        return;
    }

    if(CEPField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo de CEP é obrigatorio");
        return;
    }

    if(UFField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo UF é obrigatorio");
        return;
    }

    if(LogradouroField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo Logradouro é Obrigatorio");
        return;
    }

    if(NumeroField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo Numero é Obrigatorio");
        return;
    }

    if(BairroField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo Bairro é Obrigatorio");
        return;
    }

    if (TelefoneField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "O campo Telefone é Obrigatorio");
        return;
    }

    if (senha.isEmpty() || confirmarSenha.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Os campos de senha são obrigatórios.");
        return;
    }

    if (!senha.equals(confirmarSenha)) {
        JOptionPane.showMessageDialog(this, "As senhas não coincidem.");
        return;
    }
    else{
        int resposta2 = JOptionPane.showConfirmDialog(
                this,
                "Deseja Cadastrar o usuario?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (resposta2 == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Usuario Cadastrado Com Sucesso!!");
            System.out.print("Usuario Cadastrado com Sucesso!! \n");
            limparCampos();  
        }

        else{
            JOptionPane.showMessageDialog(this, "Usuario não foi Cadastrado");
        }
           
    }
    }

    public Cadastro_Cliente() {
        super("Cadastro de Pessoa");
        inicialization();
    }

    private void inicialization() {
        painel = new JPanel();
        painel.setLayout(null);

        //! Definindo Coordenadas e Tamanhos
        cadastroLabel = new JLabel("Cadastro de Pessoa");
        cadastroLabel.setBounds(20, 10, 400, 30);
        cadastroLabel.setFont(new Font("SansSerif", Font.PLAIN, 30)); //! Decidi colocar uma fonte diferente e aumentar o tamanho do titulo
        cadastroLabel.setForeground(new Color(250, 167, 1)); //! Coloquei tambem a cor da foto de exemplo, no caso, laranja

        tipoLabel = new JLabel("Tipo");
        tipoLabel.setBounds(20, 50, 100, 20);
        TipoJComboBox = new JComboBox<>(new String[]{"Física", "Jurídica"});
        TipoJComboBox.setBounds(120, 50, 150, 25);

        cpfLabel = new JLabel("CPF / CNPJ");
        cpfLabel.setBounds(280, 50, 100, 20);
        digiteSeuCPFOuTextField = new JTextField();
        digiteSeuCPFOuTextField.setBounds(380, 50, 150, 25);

        fornecedorLabel = new JLabel("Fornecedor");
        fornecedorLabel.setBounds(540, 50, 100, 20);
        FornecedorCheck = new JCheckBox();
        FornecedorCheck.setBounds(620, 50, 25, 25);

        nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(20, 90, 100, 20);
        NomeField = new JTextField();
        NomeField.setBounds(120, 90, 525, 25);

        rgLabel = new JLabel("RG / Inscrição Estadual");
        rgLabel.setBounds(20, 130, 150, 20);
        RGField = new JTextField();
        RGField.setBounds(180, 130, 150, 25);

        expeditorLabel = new JLabel("Orgão Expeditor");
        expeditorLabel.setBounds(340, 130, 120, 20);
        ExpeditorField = new JTextField();
        ExpeditorField.setBounds(470, 130, 175, 25);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(20, 170, 100, 20);
        EmailField = new JTextField();
        EmailField.setBounds(120, 170, 250, 25);

        cepLabel = new JLabel("CEP");
        cepLabel.setBounds(380, 170, 50, 20);
        CEPField = new JTextField();
        CEPField.setBounds(430, 170, 215, 25);

        paisLabel = new JLabel("País");
        paisLabel.setBounds(20, 210, 100, 20);
        PaisComboBox = new JComboBox<>(new String[]{"Brasil", "Outro"});
        PaisComboBox.setBounds(120, 210, 250, 25);

        ufLabel = new JLabel("UF");
        ufLabel.setBounds(380, 210, 50, 20);
        UFField = new JTextField();
        UFField.setBounds(430, 210, 50, 25);

        municipioLabel = new JLabel("Município");
        municipioLabel.setBounds(490, 210, 100, 20);
        MunicipioCombobox = new JComboBox<>(new String[]{"Campinas", "São Paulo", "Americana", "Paulinia", "Outro"});
        MunicipioCombobox.setBounds(570, 210, 150, 25);

        logradouroLabel = new JLabel("Logradouro");
        logradouroLabel.setBounds(20, 250, 100, 20);
        LogradouroField = new JTextField();
        LogradouroField.setBounds(120, 250, 600, 25);

        numeroLabel = new JLabel("Número");
        numeroLabel.setBounds(20, 290, 100, 20);
        NumeroField = new JTextField();
        NumeroField.setBounds(120, 290, 150, 25);

        complementoLabel = new JLabel("Complemento");
        complementoLabel.setBounds(280, 290, 100, 20);
        ComplementoField = new JTextField();
        ComplementoField.setBounds(380, 290, 340, 25);

        bairroLabel = new JLabel("Bairro");
        bairroLabel.setBounds(20, 330, 100, 20);
        BairroField = new JTextField();
        BairroField.setBounds(120, 330, 250, 25);

        telefoneLabel = new JLabel("Telefone");
        telefoneLabel.setBounds(380, 330, 100, 20);
        TelefoneField = new JTextField();
        TelefoneField.setBounds(470, 330, 250, 25);

        situacaoLabel = new JLabel("Situação");
        situacaoLabel.setBounds(20, 370, 100, 20);
        AtivoRadioButton = new JRadioButton("Ativo");
        AtivoRadioButton.setBounds(120, 370, 80, 25);
        InativoRadioButton = new JRadioButton("Inativo");
        InativoRadioButton.setBounds(200, 370, 80, 25);
        ButtonGroup situacaoGroup = new ButtonGroup();
        situacaoGroup.add(AtivoRadioButton);
        situacaoGroup.add(InativoRadioButton);

        senhaLabel = new JLabel("Senha");
        senhaLabel.setBounds(20, 410, 100, 20);
        senhaField = new JPasswordField();
        senhaField.setBounds(120,410, 525, 25);

        confirmarsenhaLabel = new JLabel("Confirmar Senha");
        confirmarsenhaLabel.setBounds(20, 450,100, 20);
        confirmarsenhaField = new JPasswordField();
        confirmarsenhaField.setBounds(130, 450, 525, 25);

    //! Quis deixar fiel a imagem de exemplo até mesmo na cor, coloquei os dois botões na cor laranja
        ConfirmarButton = new JButton("Confirmar");
        ConfirmarButton.setBounds(20, 490, 100, 30);
        ConfirmarButton.setBackground(new Color(250, 167, 1)); 
        
        ExcluirButton = new JButton("Excluir");
        ExcluirButton.setBounds(130, 490, 100, 30);
        ExcluirButton.setBackground(new Color(250, 167, 1));

        LimparButton = new JButton("Limpar");
        LimparButton.setBounds(240, 490, 100, 30);

        //! Adicionando ao painel
        painel.add(cadastroLabel);
        painel.add(tipoLabel); painel.add(TipoJComboBox);
        painel.add(cpfLabel); painel.add(digiteSeuCPFOuTextField);
        painel.add(fornecedorLabel); painel.add(FornecedorCheck);
        painel.add(nomeLabel); painel.add(NomeField);
        painel.add(rgLabel); painel.add(RGField);
        painel.add(expeditorLabel); painel.add(ExpeditorField);
        painel.add(emailLabel); painel.add(EmailField);
        painel.add(cepLabel); painel.add(CEPField);
        painel.add(paisLabel); painel.add(PaisComboBox);
        painel.add(ufLabel); painel.add(UFField);
        painel.add(municipioLabel); painel.add(MunicipioCombobox);
        painel.add(logradouroLabel); painel.add(LogradouroField);
        painel.add(numeroLabel); painel.add(NumeroField);
        painel.add(complementoLabel); painel.add(ComplementoField);
        painel.add(bairroLabel); painel.add(BairroField);
        painel.add(telefoneLabel); painel.add(TelefoneField);
        painel.add(situacaoLabel); painel.add(AtivoRadioButton); painel.add(InativoRadioButton);
        painel.add(senhaLabel); painel.add(senhaField);
        painel.add(confirmarsenhaLabel); painel.add(confirmarsenhaField);
        painel.add(ConfirmarButton); painel.add(ExcluirButton); painel.add(LimparButton);

        //! Colocando Ações nos botões
        ConfirmarButton.addActionListener(e -> Salvar()); //! Cadastra o Usuario
        LimparButton.addActionListener(e -> limparCampos()); //! Limpa o campo com uma função
        ExcluirButton.addActionListener(actionEvent -> SairPrograma()); //! Aciona a função para sair do programa

        this.setContentPane(painel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(760, 570);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Cadastro_Cliente();
    }
}
             //! FEITO POR WILIAM KENZO AOKI DA SILVA 2-DS(AMS) 