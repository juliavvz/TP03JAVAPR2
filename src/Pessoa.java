

public class Pessoa {
    protected static int kp;
    protected String nome;
    protected char sexo;
    protected int  idade;

    public Pessoa(){

    }

    public Pessoa(String nome, char sexo, int idade){
        setNome(nome);
        setIdade(idade);
        setSexo(sexo);
        setKp();
    }

    public void setKp(){kp ++;}

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

     public String getNome() {
        return nome;
    }
 
    public char getSexo() {
        return sexo;
    }
 
    public int getIdade() {
        return idade;
    }

    public int getKp(){
        return kp;
    }

}

    
