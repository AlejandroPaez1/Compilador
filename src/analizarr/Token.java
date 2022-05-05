package analizarr;

public class Token {
    
    String nombre;
    String valor;
    private String lexema;
    private String simbolos;
    private int tnumero;
    private int fila;
    private int columna;



    public Token(){}
    public Token(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getSimbolos(){
        return simbolos;
    }
    public void setSimbolos(String simbolos){
        this.simbolos=simbolos;
    }
    public int getTnumero() {
        return tnumero;
    }

    public void setTnumero(int tnumero) {
        this.tnumero = tnumero;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
}
