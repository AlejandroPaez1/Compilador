package analizarr;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


///chingon

public class AnalizadorLexico {
    
    private Queue buffer;
    private Integer estado;
    private Character caracter;
    private StringBuilder identificador;
    private StringBuilder cifra;

    private Integer linea;
    private List<Token> listaTokens;
    private List<Error> listaErrores;
    
    private Hashtable tablaReservada; //variables, imprimir, capturar
    
    private Hashtable tablaCondicionales;// while else, if 
    
    private Hashtable tablaOperadores;
    
    
   private Hashtable tablaOperLogicos;
    private Hashtable tablaDelimitadores;
    
    //para declarar variables para poder anaizar
    public String Entero= "entero";
    
    
    public AnalizadorLexico() {
        this.buffer = new LinkedList();
        this.listaTokens = new ArrayList<>();
        this.listaErrores = new ArrayList<>();
        this.estado = 0;
        this.caracter = ' ';
        
        this.tablaReservada = new Hashtable();
        this.tablaOperadores = new Hashtable();
        this.tablaOperLogicos = new Hashtable();
        this.tablaDelimitadores = new Hashtable();
                this.tablaCondicionales = new Hashtable();

                
                
        this.linea = 0;
        
         
        
    //...se escriben las palabras reservadas..
        reservar(new Token("Palabra Reservada", "variable"));//id
        reservar(new Token("Palabra Reservada", "texto"));  // String
        reservar(new Token("Palabra Reservada", "capturar")); //scanner
        reservar(new Token("Palabra Reservada", "presentar"));//print
        reservar(new Token("Palabra Reservada", "decimal"));//double
        
        reservar(new Token("Palabra Reservada", Entero ));//entero
        reservar(new Token("Palabra Reservada", "atras"));//
        reservar(new Token("Palabra Reservada", "importar"));//import
        reservar(new Token("terrmino : ", ":"));//import
        reservar(new Token("diferente de : ", "difDe"));//import
        
        
        
        OperLogicos(new Token("terrmino : ", ":"));//import
        
    
        
    //...condicionales if,else,while,do while       
        reservar(new Token("Sentencia    ", "si"));     //if
        reservar(new Token("Sentencia        ", "sino"));//else
        reservar(new Token("Ciclo       ", "mientras")); //while
        reservar(new Token("Ciclo       ", "repetir"));//
        reservar(new Token("Ciclo       ", "hasta_que"));//do
    
    //...operadores aritmeticos
         operadores(new Token ("backslash       ","\""));
         operadores(new Token ("resta           ","-"));
         operadores(new Token ("Dvision         ","/"));
         operadores(new Token ("Multiplicacion  ","*"));
         operadores(new Token ("suma           ","+"));
         
 /*   //operadores relacionales
        operadores(new Token ("Mayor que  ",">"));
        operadores(new Token ("Menor que  ","<"));
        operadores(new Token ("Menor igual  ","<="));
        operadores(new Token ("Mayor igual  ",">="));
        operadores(new Token ("Mayor igual  ",">="));
   */     
    //operadoresLogicos
        OperLogicos(new Token ("operLogico and","and"));
        OperLogicos(new Token ("operLogico or","oo"));
        OperLogicos(new Token ("operLogico not","Nel"));
        OperLogicos(new Token ("operLogico not","abcd"));
        
    //booleanos    
        OperLogicos(new Token ("booleanos ","verdad"));
        OperLogicos(new Token ("booleanos ","falso"));
          
    //puntoComaFinal     
         OperLogicos(new Token ("punto y coma",";"));    //final instruccion    
 
    //delimitadores         
         OperLogicos(new Token ("parentesis","("));
         OperLogicos(new Token ("parentesis",")"));
    
    //delimitadoresSecundarios
        OperLogicos(new Token ("corcheteAbierto","{"));
        OperLogicos(new Token ("corcheteCerrado","}"));
        
    //puntoDecimal     
         OperLogicos(new Token ("punto           ","."));
    
    }

    private void reservar(Token token) {
        //.se agrega ala tabla simbolos
        tablaReservada.put(token.getValor(), token);
    }

  
    private void OperLogicos(Token token){
        tablaOperLogicos.put(token.getValor(),token);
    }

    private void operadores(Token token) {
        //.se agrega ala tabla
        tablaOperadores.put(token.getValor(), token);
    }
  
    public Queue getBuffer() {
        return buffer;
    }

    public void setBuffer(String texto) {

        for (int i = 0; i < texto.length(); i++) {
            buffer.add(texto.charAt(i));
        }
        buffer.add(Character.MIN_VALUE);
    }

    private char siguienteCaracter() {
        return (Character) buffer.peek();
    }

    private void removerCaracter() {
        buffer.remove();
    }

    private Integer fallo(Integer estado) {
        // en caso no detecte alguna tipo de letra manda hacia el fallo y regresa otro estado a analizar
        Integer estadoRetorno = 0;
        switch (estado) {
            case 0:
                estadoRetorno = 9;
                break;
            case 1:
                estadoRetorno = 12;
                break;
        }

        return estadoRetorno;
    }
public List<Token> siguienteToken() {
    while (!buffer.isEmpty()) {
        switch (estado) {
            case 0:
    //automata del libro de operadores
                  caracter = siguienteCaracter();
                    if (caracter == '<') {
                        estado = 1;
                        removerCaracter();
                                                                                   
                    }else if (caracter == '=') {      
                        estado = 5;
                       // caracter = siguienteCaracter();
                           System.out.println("estadoigual");
                    }            
                    
                    else if (caracter == '>') {
                        estado = 6;
                        removerCaracter();
                    } else if (Character.isDigit(caracter)) {
                        estado = 17;
                    } else {
                   
                        estado = fallo(0);
                    }
                    break;
            case 1:
                    caracter = siguienteCaracter();
                    if (caracter == '=') {
                        estado = 2;
                        if (caracter == '='){
                            System.out.println("es igual igual");
                            removerCaracter();
                        }
                    } else if (caracter == '>') {
                        estado = 3;
                        removerCaracter();
                    } else {
                        estado = 4;
                    }
                    break;
            case 2:
                    listaTokens.add(new Token("operador", "Menor Igual"));
                    estado = 0;
                    break;

            case 3:
                    listaTokens.add(new Token("operador", "Diferente"));
                    estado = 0;
                    break;

            case 4:
                    listaTokens.add(new Token("operador", "menor que"));
                    estado = 0;
                    break;

            case 5:
                    caracter = siguienteCaracter();
                    if(caracter== '='){
                        removerCaracter();
                        caracter=siguienteCaracter();
                        if(caracter =='='){
                            listaTokens.add(new Token("comparador igual ala dos","=="));
                            removerCaracter();
                        }else{
                            listaTokens.add(new Token("operador", "igual"));

                        }
                    }
                    estado = 0;
                    break;

            case 6:
                    caracter = siguienteCaracter();
                    if (caracter == '=') {
                        estado = 7;
                    } else {
                        estado = 8;
                    }
                    break;
            case 7:
                    listaTokens.add(new Token("operador", "mayor igual"));
                    removerCaracter();
                    estado = 0;
                    break;
            case 8:
                    listaTokens.add(new Token("operador", "mayor"));
                    estado = 0;
                    break;
            case 9:
                    caracter = siguienteCaracter();
       //necesita verificar si el caracter es una letra
                    if (Character.isLetter(caracter)) {
                        estado = 10;
                        identificador = new StringBuilder();
               //concatenar
                        identificador.append(caracter);
                        removerCaracter();
                    } else if (Character.isWhitespace(caracter)) {
                        estado = fallo(1);
                    } else {
                        estado = 13;
                    }
                    break;
            case 10:
                    caracter = siguienteCaracter();
                    if (Character.isLetterOrDigit(caracter)) {
                        estado = 10;
                        identificador.append(caracter);
                        removerCaracter();
                    } else {
                        estado = 11;
                    }
                    break;
            case 11:
    //convertir el identificador a una variable de tipo de string
                    String palabraReservada = identificador.toString();
    //se busca en la tabla de simobolo la palabra reservada       
                    Token tokenPalabraReservada = (Token) tablaReservada.get(palabraReservada);
    //si lo encontro por eso se dice si es diferente de nulo
                    if (tokenPalabraReservada != null) {
                        listaTokens.add(tokenPalabraReservada);
                        //removerCaracter();
                        estado = 0;
                        break;
                    }
                    if (caracter == ';') {
                        System.out.println("estado 12");
                        estado = 12;
                    }
                    
                    tablaReservada.put(palabraReservada, new Token("Identificador", palabraReservada));
                    listaTokens.add(new Token("Identificador", identificador.toString()));
                    estado = 0;
                    break;
            case 12:
                    caracter = siguienteCaracter();
                    if (caracter == '\n') {
                        linea++;
                    }
                    removerCaracter();
                    estado = 0;
                    break;          
                    
            case 13:
                System.out.println("estado 13");
                    caracter = siguienteCaracter();
                    Token tokenOperadorLogico = (Token) tablaOperLogicos.get(caracter.toString());
                    if (tokenOperadorLogico != null) {
                        listaTokens.add(tokenOperadorLogico);
                    } else {
                        System.out.println("pal 14");
                        estado = 14;
                        
                        //break;
                    }
                    estado = 0;
                    removerCaracter();
                break;
                    
            case 14:
                    Token tokenSimboloAritmetico = (Token) tablaOperadores.get(caracter.toString());
                    if (tokenSimboloAritmetico != null) {
                        listaTokens.add(tokenSimboloAritmetico);
                    } else if (Character.isDigit(caracter)) {
                        estado = 15;
                        break;
                    }

                    estado = 0;
                    removerCaracter();
                    break;
            case 15:
                    caracter = siguienteCaracter();
                    estado = 16;
                    cifra = new StringBuilder();
                    cifra.append(caracter);
                    removerCaracter();
                    break;

            case 16:
                    caracter = siguienteCaracter();
                    cifra.append(caracter);
                    removerCaracter();
                    caracter = siguienteCaracter();
                    if (!Character.isDigit(caracter)) {
                        estado = 17;
                    }else if(Character.isLetter(caracter)){
                   
                    }
                    break;
            case 17:
                    caracter = siguienteCaracter();
                    if (Character.isDigit(caracter)) {
                        cifra = new StringBuilder();
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 18;
                    }
                    break;
            case 18:
                    caracter = siguienteCaracter();
                    if (Character.isDigit(caracter)) {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 18;
                    } else if (caracter == '.') {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 19;
                    } else if (caracter == 'E') {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 21;
                    } else if (Character.isLetter(caracter)) {
                        listaTokens.add(new Token("Cifra", cifra.toString()));
                        estado = fallo(0);
                    } else {
                        estado = 25;
                    }
                    break;
            case 19:
                    caracter = siguienteCaracter();
                    if (Character.isDigit(caracter)) {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 20;
                    } else {
                        estado = 24;
                    }
                    break;
            case 20:
                    caracter = siguienteCaracter();
                    if (Character.isDigit(caracter)) {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 20;
                    } else if (caracter == 'E') {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 21;
                    } else if (caracter == '.') {
                            estado = 26;
                    } else {
                        estado = 26;
                    }
                    break;
            case 21:
                    caracter = siguienteCaracter();
                    if (caracter == '-' || caracter == '+') {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 22;
                    } else if (Character.isDigit(caracter)) {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 23;
                    }
                    break;
            case 22:
                    caracter = siguienteCaracter();
                    if (Character.isDigit(caracter)) {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 23;
                    }
                    break;
            case 23:
                    caracter = siguienteCaracter();
                    if (Character.isDigit(caracter)) {
                        cifra.append(caracter);
                        removerCaracter();
                        estado = 23;
                    } else {
                        estado = 24;
                    }
                    break;
            case 24:
                    //si es un decimal pero solo con el punto, el programa agrega un 0
                    listaTokens.add(new Token("Decimal         ", cifra.toString()+"0"));
                    estado = 0;
                    break;
            case 25:
                    //si detecta que es un numero entero
                    listaTokens.add(new Token("Entero           ", cifra.toString()));
                    estado = 0;
                    break;
            case 26:
                    //si detecta que es un numero de tipo decimal
                    listaTokens.add(new Token("Decimal           ", cifra.toString()));
                    estado = 0;
                    break;
            case 27:
                    caracter = siguienteCaracter();
                    if (caracter == '.') {
                        listaTokens.add(new Token("operadores", caracter.toString()));
                        removerCaracter();
                        estado = 27;
                    } else if (Character.isDigit(caracter)) {
                        estado = 17;
                    } else {
                        estado = 18;
                        removerCaracter();
                    }
                    break;

            }
        }

        return listaTokens;

    }

    public List<Error> getListaErrores() {
        return listaErrores;
    }

}
