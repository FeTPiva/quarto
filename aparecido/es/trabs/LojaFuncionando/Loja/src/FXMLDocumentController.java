
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController implements Initializable {

    Connection conexao = ConnectionFactory.getConnection();
    @FXML
    private Tab tab1;
    @FXML
    private Button btn;
    @FXML
    private Tab tab2;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtSenha;
    @FXML
    private Tab tab3;
    @FXML
    private CheckBox PP2;
    @FXML
    private CheckBox P2;
    @FXML
    private CheckBox M2;
    @FXML
    private CheckBox G2;
    @FXML
    private CheckBox GG2;
    @FXML
    private Button btnVender;
    @FXML
    private Button btncadastar;
    @FXML
    private ToggleGroup cat;
    @FXML
    private ToggleGroup cor;
    @FXML
    private RadioButton camiseta;
    @FXML
    private RadioButton vestido;
    @FXML
    private RadioButton azul;
    @FXML
    private RadioButton branco;
    @FXML
    private RadioButton rosa;
    @FXML
    private RadioButton preto;
    @FXML
    private RadioButton blusa;
    @FXML
    private RadioButton camisa;
    @FXML
    private RadioButton calca;
    @FXML
    private RadioButton verde;
    @FXML
    private TextField cadastroNome;
    @FXML
    private TextField cadastroQuant;
    @FXML
    private TextField cadastroPreco;
    @FXML
    private TextField vendaNome;
    @FXML
    private TextField vendaQuant;
    @FXML
    private RadioButton PP;
    @FXML
    private RadioButton P;
    @FXML
    private RadioButton M;
    @FXML
    private RadioButton G;
    @FXML
    private RadioButton GG;
    @FXML
    private RadioButton Rosa1;
    @FXML
    private RadioButton Preto1;
    @FXML
    private RadioButton Branco1;
    @FXML
    private RadioButton Verde1;
    @FXML
    private RadioButton Azul1;
    @FXML
    private RadioButton Calca1;
    @FXML
    private RadioButton Vestido1;
    @FXML
    private RadioButton Camisa1;
    @FXML
    private RadioButton Camiseta1;
    @FXML
    private RadioButton Blusa1;
    @FXML
    private TextField idProduto;
    @FXML
    private Button btnpesquisa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
   

    @FXML
    private void login(ActionEvent event) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM usuarios;";
        PreparedStatement ps;

        try {
            ps = conexao.prepareStatement(sql);
            ResultSet resultadoQuery = ps.executeQuery();
            while (resultadoQuery.next()) {
                String email = resultadoQuery.getString("email");
                String senha = resultadoQuery.getString("senha");
                String cargo = resultadoQuery.getString("cargo");

                if (senha.equals(txtSenha.getText()) && email.equals(txtUser.getText())) {
                    System.out.println("logado com sucesso");
                    tab2.setDisable(false);
                    tab3.setDisable(false);
                    //jogar mensagens pra telinha depois
                } else {
                    System.out.println("Não foi possivel logar! Senha ou usuário errados");
                }
            }
            ps.close();
            //conexao.close();

        } catch (SQLException ex) {
            System.out.println("Problema na conexão com a base de dados(login): " + ex.getMessage());
            
        }

    }

    @FXML
    private void vender(ActionEvent event) {

        int id = Integer.parseInt(idProduto.getText());
        int quantidadevendas = Integer.parseInt(vendaQuant.getText());
        int quantidade = 0;
    
        // Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM estoque WHERE `idroupa`=" + id;
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ResultSet resultadoQuery = ps.executeQuery();
            while (resultadoQuery.next()) {
                quantidade = resultadoQuery.getInt("quantidade");
                //int idd = resultadoQuery.getInt("idroupa");
                String nome = resultadoQuery.getString("nomeProduto");
                
                System.out.println("nome: " + nome + " quant: " + Integer.toString(quantidade) + "\n");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Erro na conexão(select venda): "+ ex.getMessage());
            
        }

        if (quantidadevendas <= quantidade) {
           int ttl = quantidade - quantidadevendas;
            sql = "UPDATE estoque SET `quantidade` = ? WHERE `idroupa` = " + id;
            //sql = "Select `quantidade` from estoque";
            try {
                
                ps = conexao.prepareStatement(sql);
                //ResultSet resultadoQuery = ps.executeQuery();
                ps.setInt(1, ttl);
                ps.executeUpdate();
               
                 System.out.println("vendeu: " + ttl );
                
                
            } catch (SQLException ex) {
                System.out.println("Erro na conexão(update venda): "+ ex.getMessage());
              
            }
        } else {
            System.out.println("Não foi possível realizar a venda.\nVerifique se há quantidade suficiente no estoque ou se os dados da peça estão corretos");
        }

    }

    @FXML
    private void cadastrar(ActionEvent event) {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "INSERT INTO estoque (`nomeProduto`,`quantidade`,`categoria`,`preco`,`cor`,`tamanho`) VALUES (?,?,?,?,?,?)";

        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, cadastroNome.getText());
            ps.setInt(2, Integer.parseInt(cadastroQuant.getText()));
            if (camiseta.isSelected()) {
                ps.setString(3, camiseta.getText());
                System.out.println("entrei");
            }
            if (vestido.isSelected()) {
                ps.setString(3, vestido.getText());
                System.out.println("entrei2");
                System.out.println(vestido.getText());
            }
            if (blusa.isSelected()) {
                ps.setString(3, blusa.getText());
            }
            if (camisa.isSelected()) {
                ps.setString(3, camisa.getText());
            }
            if (calca.isSelected()) {
                ps.setString(3, calca.getText());
            }

            ps.setFloat(4, Float.parseFloat(cadastroPreco.getText()));

            if (rosa.isSelected()) {
                ps.setString(5, rosa.getText());
            }
            if (azul.isSelected()) {
                ps.setString(5, azul.getText());
            }

            if (preto.isSelected()) {
                ps.setString(5, preto.getText());
            }
            if (verde.isSelected()) {
                ps.setString(5, verde.getText());
            }

            if (PP2.isSelected()) {
                ps.setString(6, PP2.getText());
            }
            if (P2.isSelected()) {
                ps.setString(6, P2.getText());
            }
            if (M2.isSelected()) {
                ps.setString(6, M2.getText());
            }
            if (G2.isSelected()) {
                ps.setString(6, G2.getText());
            }
            if (GG2.isSelected()) {
                ps.setString(6, GG2.getText());
            }

            ps.execute();
            ps.close();
            System.out.println("produto cadastrado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro no cadastro(insert cadastro): "+ ex.getMessage());
           
        }

    }

    @FXML
    private void pesquisar(ActionEvent event) {

        int id = Integer.parseInt(idProduto.getText());
        // int quantidadevendas = Integer.parseInt(vendaQuant.getText());
        int quantidade = 0;
        // int vendida=0;
        // Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM estoque WHERE `idroupa`=" + id;
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ResultSet resultadoQuery = ps.executeQuery();
            while (resultadoQuery.next()) {
                quantidade = resultadoQuery.getInt("quantidade");
                //int idd = resultadoQuery.getInt("idroupa");
                String nome = resultadoQuery.getString("nomeProduto");
                //vendida = resultadoQuery.getInt("vendida");    
                System.out.println("nome: " + nome + " quant: " + Integer.toString(quantidade) + "\n");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Erro na conexão(select pesquisa): " + ex.getMessage());
         
        }

    }
}


/*

 Connection conexao = ConnectionFactory.getConnection();
 String sql = "INSERT INTO usuario (`nome`,`cpf`,`endereco`,`telefone`,`senha`,`email`) VALUES (?,?,?,?,?,?)";
        
 PreparedStatement ps;
 try {
            
 ps = conexao.prepareStatement(sql);
 ps.setString(1, txtnome.getText());
 ps.setString(2, txtcpf.getText());
 ps.setString(3, txtendereco.getText());
 ps.setString(4, txttelefone.getText());
 ps.setString(5, txtsenha.getText());
 ps.setString(6, txtemail.getText());

 ps.execute();
 ps.close();
 System.out.println("não lascou :D");
 } catch (SQLException ex) {
 System.out.println("lascouuuu ,-, lembra de olha se o nome da tab ta certo, e do esquema '-'");
 }
                
 }

 */
/* VENDER
 String sql = "SELECT * FROM estoque ;";
 PreparedStatement ps;
 try {
 ps = conexao.prepareStatement(sql);
 ResultSet resultadoQuery = ps.executeQuery();

 while (resultadoQuery.next()) {
 String nome = resultadoQuery.getString("nomeProduto");
 int quantidade = resultadoQuery.getInt(Integer.parseInt("quantidade"));
 // String tamanho = resultadoQuery.getString("tamanho");

 if (vendaNome.getText().equals(nome)) {
 System.out.println("entrei no if");
 if (Integer.parseInt(vendaQuant.getText()) >= quantidade) {

 String sql2 = " UPDATE `loja`.`estoque` SET `quantidade`=?;";
 PreparedStatement ps2;
 ps2 = conexao.prepareStatement(sql);
 ResultSet resultadoQuery2 = ps2.executeQuery();
 //  quantidade = quantidade - Integer.parseInt(vendaQuant.getText());

 ps2.setInt(1, Integer.parseInt(vendaQuant.getText()));
 //ps2.setInt(2, Integer.parseInt(cadastroQuant.getText()));

 } else {
 System.out.println("quantidade insuficiente");
 }

 } else {
 System.out.println("fail");
 }

 }

 ps.close();
 conexao.close();

 } catch (SQLException ex) {
 System.out.println("lascou");
 System.out.println(ex.getMessage());
 }

 */
