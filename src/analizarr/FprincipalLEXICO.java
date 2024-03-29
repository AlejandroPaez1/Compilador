package analizarr;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class FprincipalLEXICO extends javax.swing.JFrame {


    /*
 etapa de analizador sintactico
    
    |analizador lexico|  |A. sintactico| |A. Semantico|
    ________________                  ______________
    |  Cod, normal |       =>         | Resultado   |
    
                      | errores |
    
    
                  
     */
    AnalizadorLexico analizador = new AnalizadorLexico();
    NumeroLinea numeroLinea;
    public String Arreglo[];

String datos_guardados = "";
String dato_entero = "";
String dato_decimal = "";
String dato_texto = "";

String dato_operE = "";
String dato_operDec = "";

String palabra_reservada = "entero|presentar|decimal|texto|mientras|si";

    public FprincipalLEXICO() {
        initComponents();
        this.setLocationRelativeTo(null);
        numeroLinea = new NumeroLinea(txt_entrada);
        jScroll_entrada.setRowHeaderView(numeroLinea);
        numeroLinea = new NumeroLinea(txt_errores);
        jScrollPaneErrores.setRowHeaderView(numeroLinea);
        icono();
    }
    
    private void icono() {
        Toolkit laPantalla = Toolkit.getDefaultToolkit();
        Dimension medidas = laPantalla.getScreenSize();
        //ubicacion del archivo desde la url que se encuentra por arriba
        Image iconito = laPantalla.getImage("src/Imagenes/estres.png");
        //insertamos el icono 
        setIconImage(iconito);
        txt_entrada.grabFocus();

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bt_sintactico = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        tabb = new javax.swing.JTabbedPane();
        todo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_salida = new javax.swing.JTextArea();
        jScrollPaneErrores = new javax.swing.JScrollPane();
        txt_errores = new javax.swing.JTextArea();
        jScroll_entrada = new javax.swing.JScrollPane();
        txt_entrada = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btn_lex = new javax.swing.JButton();
        bt_semantico = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador RHA");
        setMinimumSize(new java.awt.Dimension(850, 500));

        jPanel1.setBackground(new java.awt.Color(0, 113, 233));

        bt_sintactico.setBackground(new java.awt.Color(255, 255, 255));
        bt_sintactico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bt_sintactico.setForeground(new java.awt.Color(0, 0, 51));
        bt_sintactico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tocar.png"))); // NOI18N
        bt_sintactico.setText("Analizador sintactico");
        bt_sintactico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        bt_sintactico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_sintactico.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        bt_sintactico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_sintactico.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        bt_sintactico.setName(""); // NOI18N
        bt_sintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sintacticoActionPerformed(evt);
            }
        });

        btn_regresar.setBackground(new java.awt.Color(255, 255, 255));
        btn_regresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_regresar.setForeground(new java.awt.Color(0, 0, 51));
        btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/online-test.png"))); // NOI18N
        btn_regresar.setText("Codigo prueba");
        btn_regresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_regresar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btn_regresar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_regresar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_regresar.setName(""); // NOI18N
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        btn_limpiar.setBackground(new java.awt.Color(255, 255, 255));
        btn_limpiar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        tabb.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel4.setBackground(new java.awt.Color(0, 113, 233));

        txt_salida.setEditable(false);
        txt_salida.setColumns(20);
        txt_salida.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        txt_salida.setForeground(new java.awt.Color(0, 0, 51));
        txt_salida.setRows(5);
        txt_salida.setSelectedTextColor(new java.awt.Color(0, 51, 204));
        txt_salida.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(txt_salida);

        txt_errores.setBackground(new java.awt.Color(232, 232, 232));
        txt_errores.setColumns(20);
        txt_errores.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txt_errores.setForeground(new java.awt.Color(255, 0, 0));
        txt_errores.setRows(5);
        jScrollPaneErrores.setViewportView(txt_errores);

        txt_entrada.setBackground(new java.awt.Color(195, 221, 250));
        txt_entrada.setColumns(20);
        txt_entrada.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txt_entrada.setRows(5);
        txt_entrada.setToolTipText("");
        txt_entrada.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(60, 63, 65), new java.awt.Color(60, 63, 65), null, new java.awt.Color(60, 63, 65)));
        txt_entrada.setSelectedTextColor(new java.awt.Color(102, 0, 102));
        txt_entrada.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScroll_entrada.setViewportView(txt_entrada);

        jLabel2.setText("ALEJANDRO PAEZ PEREZ Y ...");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/warning.png"))); // NOI18N
        jLabel1.setText("E r r o r e s ");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScroll_entrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
                    .addComponent(jScrollPaneErrores))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll_entrada, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneErrores, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout todoLayout = new javax.swing.GroupLayout(todo);
        todo.setLayout(todoLayout);
        todoLayout.setHorizontalGroup(
            todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, todoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        todoLayout.setVerticalGroup(
            todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todoLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        tabb.addTab("ejecucion de codigo", todo);

        jPanel3.setBackground(new java.awt.Color(0, 113, 233));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(1);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setTabSize(1);
        jTextArea1.setText("Seccion ayuda\nanalizador lexico y sintactico hecho por\n--el codigo siempre tiene que iniciar por\n\tinicio codigo RHA;:\n---RESPETAR ESTRICTAMENTE LOS ESPACIOS\n\n--para declarar variables siempre se inicia el valor sea entero, decimal, texto seguido de el nombre de la\n variable\n\tentero aux2 = 12:\n\n--al declarar se inicializa el valor en entero decimal y texto \n \tdecimal dec = 1.4:\n\ttexto txtVar = 'hello word':\n\tentero Nvar = 12;\n--Para imprimir en pantalla se usa \n\tpresentar = txtVar:\n  -Si el dato esta correcto imprimira \n\t = 'hello word':\n--usar el si es facil siempre y cuando detecte bien los espacios para poder diferenciar\n     si ( aux2 = dec ) {:\n        \n     }:\n\t\n--usar el mientras hay que respetar si o si los cambios de mientras\n\tmientras ( aux2 = dec ) {:\n\t\n         }:\n\n");
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/informacion.png"))); // NOI18N
        jButton1.setText("Mas informacion");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addGap(273, 273, 273))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabb.addTab("Seccion ayuda", jPanel2);

        btn_lex.setBackground(new java.awt.Color(255, 255, 255));
        btn_lex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_lex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-de-play 2.png"))); // NOI18N
        btn_lex.setText("Analizador lexico");
        btn_lex.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_lex.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_lex.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btn_lex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_lex.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btn_lex.setName(""); // NOI18N
        btn_lex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lexActionPerformed(evt);
            }
        });

        bt_semantico.setBackground(new java.awt.Color(255, 255, 255));
        bt_semantico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bt_semantico.setForeground(new java.awt.Color(0, 0, 51));
        bt_semantico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton-de-play (2).png"))); // NOI18N
        bt_semantico.setText("Analizador semantico");
        bt_semantico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        bt_semantico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_semantico.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        bt_semantico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_semantico.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        bt_semantico.setName(""); // NOI18N
        bt_semantico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_semanticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabb)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_lex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_sintactico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_semantico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_regresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_sintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_semantico, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_lex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabb)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
                         

        
    /**
     *
     * @return
     */
    public void botonSintactico() {
  
        
        txt_errores.setText("");
        txt_salida.setText("");
        
        String Entrada = txt_entrada.getText();//.replaceAll("", "\n");// para sustituir el ; por un enter
        Entrada = Entrada.trim();//ignora los espacios
        Arreglo = Entrada.split(":");//que despues del : se guarda en el siguiente arreglo

        int n = Arreglo.length;
    List<String> lista_operadores = new ArrayList<>();
        lista_operadores.add("==");
        lista_operadores.add(">");
        lista_operadores.add("<");
        lista_operadores.add("!<");
        lista_operadores.add("!>");
        lista_operadores.add("yy");
        lista_operadores.add("oo");
            
        //txt_salida.setText("los datos guardados de sintactico son: \n");
        //txt_salida.append("el total de arreglo es " + n + "\n");
//        se pide el tamaño para el for a utilizar
        int tamño = lista_operadores.size();
                
                
        boolean enterobien = false;
        boolean decimalbien = false;
        boolean textobien = false;
        boolean sibien = false;
        boolean mientrasbien = false;
        boolean sinobien = false;
        boolean presentarbien = false;
        boolean operacionbien = false;
        boolean falloSI = false;
  //      boolean enterobien = false;
        
String numnum = "([0-9]* [\\+|\\-|\\*|\\/] [0-9]*)*";
String letranum = "([a-z]*[0-9]* [\\+|\\-|\\*|\\/] [0-9]*)*";
String numletra = "([0-9]* [\\+|\\-|\\*|\\/] [a-z]*[0-9]*)*";
String letraletra = "([a-z]*[0-9]* [\\+|\\-|\\*|\\/] [a-z]*[0-9]*)*";

String Dnumnum = "([0-9]*[.][0-9]* [\\+|\\-|\\*|\\/] [0-9]*[.][0-9]*)*";
String Dletranum = "([a-z]*[0-9]* [\\+|\\-|\\*|\\/] [0-9]*[.][0-9]*)*";
String Dnumletra = "([0-9]*[.][0-9]* [\\+|\\-|\\*|\\/] [a-z]*[0-9]*)*";
String Dletraletra = "([a-z]*[0-9]* [\\+|\\-|\\*|\\/] [a-z]*[0-9]*)*";

String operacionE = "[\\s]*entero [a-z]*[0-9]* = ("+numletra+"|"+numnum+"|"+letranum+"|"+letraletra+")";
String operacionDe = "[\\s]*decimal [a-z]*[0-9]* = ("+Dnumletra+"|"+Dnumnum+"|"+Dletranum+"|"+Dletraletra+")";







if (Arreglo[0].contains("inicio codigo RHA;")) {
     for (int i = 1; i < n; i++) {
         
               System.out.println("el dato num: " + i + " es:: " + Arreglo[i].replaceAll("\n", ""));

// DECLARACION ENTERO y Operaciones
          if(Arreglo[i].contains("entero ")){
                  if(Arreglo[i].matches("([\\s]*entero [a-zA-Z]*[0-9]* = ([a-zA-Z]*[0-9]*))|("+operacionE+")")){
                     txt_salida.append("declaracion correcta del entero perfect \n");
                    enterobien = true;
                   
                    }else {
                        txt_errores.append("no has declarado bien el valor ent:  "+Arreglo[i].replaceAll("\n","")+"\n");
                         enterobien = false;
                    }
            }
  
// declaracion decimal y la operacion decimal                                                                       
              if(Arreglo[i].contains("decimal ")){
                    if(Arreglo[i].matches("([\\s]*decimal [a-zA-Z]*[0-9]* = (([a-zA-Z]*[0-9]*)|[0-9]*[.][0-9]*))|("+operacionDe+")")){
                        txt_salida.append("declaracion correcta del decimal perfect \n");

                         decimalbien= true;
                        }else{
                        txt_errores.append("no has declarado bien el valordec :  "+Arreglo[i].replaceAll("\n","")+"\n");
                        decimalbien = false;
                      }
                }
              
// DECLARACION texto                                           
            if(Arreglo[i].contains("texto ")){
                   if(Arreglo[i].matches("[\\s]*texto [a-zA-Z]*[0-9]* = '[a-zA-Z|0-9|\\s]*'")){
                                txt_salida.append("declaracion correcta del texto perfect \n");
                                textobien = true;
                                }else{
                                txt_errores.append("no has declarado bien el valor txt:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                textobien = false;
                   }
            }
            
// Mostrar datos en pantalla                                                                       
          if(Arreglo[i].contains("presentar ")){
                          if(Arreglo[i].matches("[\\s]*presentar = ([a-zA-Z]*[0-9]*)")){
                                txt_salida.append("has mostrado bien los datos:  "+Arreglo[i].replaceAll("presentar ","").replaceAll("\n", "")+" \n");
                                presentarbien = true;
                                }else{
                                 txt_errores.append("no has declarado bien el valor presentar:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                 presentarbien = false;
                          }
            
            }
       
// asiganacion while                                           
            if(Arreglo[i].contains("mientras ")){
                   if(Arreglo[i].matches("[\\s]*mientras \\( ([a-zA-Z]*[0-9]*)* [<|>|=] ([a-zA-Z]*[0-9]*)* \\) \\{")){
                       for (int j = i; j < n; j++) {
                                       if(Arreglo[j].contains("}")){
                                            txt_salida.append("si esta el } mientras \n");
                                            mientrasbien = true;
                                       }else{
                                           txt_errores.append("tamal el while PERO SI APARECE EL 'si esta el } mientras' IGNORAR ji\n");
                                       }
                       }
                                }else{
                                txt_errores.append("no has declarado bien el valor:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                mientrasbien= false;
                   }
            }
            

// pruba iff
 // asignacion iff
    if(Arreglo[i].contains("si ")){
           if(Arreglo[i].matches("[\\s]*si \\( ([a-zA-Z]*[0-9]*) [<|>|=] ([a-zA-Z]*[0-9]*)* \\) \\{")){
                 for (int j = i+1; j < n; j++) {
                                       if(Arreglo[j].contains("}")){
                                            txt_salida.append("esta cerrado el si \n");
                                            mientrasbien = true;
                                       }else{
                                           txt_errores.append("algun error PERO SI MUESTRA 'esta cerrado el si' ignorar el error \n");
                                       }
                       }
            }else{
                txt_errores.append("no has declarado bien el valor:  "+Arreglo[i].replaceAll("\n","")+"\n");
                sibien = false;
           }
    }     
    
            
    }//termino del Arreglo[i]
                 if(enterobien==true && decimalbien==true&& textobien== true && sibien ==true && mientrasbien ==true && presentarbien==true && operacionbien == true ){
                txt_salida.append("compilo bien ooo");
                System.out.println("compilooo ibien ");
            }else{
                System.out.println("compilo mal");
            }
            
      }else{//del arreglo 0 que esta bien
       txt_errores.append("no has iniciado el codigo es 'inicio codigo RHA;:' y tienes el valor: "+Arreglo[0]);
      }
      

}//termino del void

private void siiiuuu(){
    int n = Arreglo.length;
    for (int i = 0; i < n; i++) {
             if(Arreglo[i].contains("si ")){
                if(Arreglo[i].matches("[\\s]*si \\( ([a-zA-Z]*[0-9]*)* [<|>|=\\=] ([a-zA-Z]*[0-9]*)* \\) \\{")){
                    System.out.println("el numero i es "+i);
                    for (int j = i; j < n; j++) {
                        System.out.println("ADENTRO de si ( [as] < [as]\n");
                        System.out.println("el numero j es "+j);
                        if(Arreglo[j].contains("}sino{")){
                            //if(Arreglo[j].matches("[\\s]*\\}sino\\{")){
                                System.out.println("paso el regex del sino { \n");
                                for (int k = j+1; k < n; k++) {
                                    System.out.println("el numero k es "+k);
                                    if(Arreglo[k].contains("}")){
                                    System.out.println("entro a }");
//                                  if(Arreglo[k].matches("[\\s]\\}")){
                                    txt_salida.append("declaracion correcta del sinoJUNTO\n");
                                    //                                    }
                                }else{
                                    txt_errores.append("falta el {} ignorar algo xd:  "+Arreglo[j].replaceAll("\n","")+"\n");
                                    }                    
                                } //fin del for k
                        }else{ //if del else sino
//                            for (int x = j+2; x < n; x++) {
//                                System.out.println("el numero x es "+x);
//                                    if(Arreglo[x].matches("[\\s]*\\}")){
//                                    System.out.println("entro a }");
////                                  if(Arreglo[k].matches("[\\s]\\}")){
////                                    txt_salida.append("declaracion correcta del sinoJUNTO del fallo sino \n");
////                                    }
//                                }else{
//                                    txt_errores.append("error segun deñl {} j  "+Arreglo[j].replaceAll("\n","")+"\n");
//
////                                    txt_errores.append("falta el {} creo:  "+Arreglo[j].replaceAll("\n","")+"\n");
                                    }                                    
                        }
                }
                        
                
            
                        
                               
//                } else{
//                    txt_errores.append("la variable del if ta mal creo:  "+Arreglo[i].replaceAll("\n","")+"\n");
//                }
            }//fin del asignacion if

                

    }
}
    
    
    
    private void bt_sintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sintacticoActionPerformed

        botonSintactico();
        txt_entrada.grabFocus();
        siiiuuu();

    }//GEN-LAST:event_bt_sintacticoActionPerformed


    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
    
btnsintac();
        
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btnsintac(){
     txt_entrada.setText("inicio codigo RHA;:\n" +
"\n" +
"entero aux2 = 1:\n" +
"entero aux4 = aux2:\n" +
"\n" +
"opEntero sum1 = aux2 + aux4:\n" +
"opEntero sum2 = aux2 + aux4:\n" +
"\n" +
"decimal aux3 = 1.2:\n" +
"decimal bb = aux3:\n" +
"\n" +
"opDecimal sum3 = aux3 + bb:\n" +
"opDecimal sum4 = aux3 + bb:\n" +
"\n" +
"texto txt = 'hello word':\n" +
"presentar = txt:\n" +
"\n" +
"mientras ( sum1 < sum2 ) {:\n" +
"  entero uwu = 123:\n" +
"}:\n" +
"\n" +
"si ( sum1 > sum2 ) {:\n" +
"  entero xd = 42:\n" +
"}:");
    }
    
    private void btn(){
        // TODO add your handling code here:
            analizador.setBuffer(txt_entrada.getText());
            List<Token> listaToken = analizador.siguienteToken();
            Proceso_analizar(listaToken);
            
            String pruba = "si 8 a mas bs 8 9";
            System.out.println(pruba.matches("si 8 [a-z] mas [a-z] 8 9"));
           
            String comparadores = "<|>|==|!<|!>";
            if((Arreglo[1].matches("[\\s]*si[\\s]*[(][\\s]*[a-z]*[\\s]*["+comparadores+"][\\s]*[a-z]*[\\s]*[)][\\s]*[{]"))){
                    System.out.println("coinicidio");
                }else{
                System.out.println("nel");
            }
    
    }
    
    
    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
            txt_salida.setText("");
            txt_errores.setText("");      
            
    }//GEN-LAST:event_btn_limpiarActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Desktop.getDesktop().browse(new URI("https://github.com/alejandro911pa"));
        } catch (IOException | URISyntaxException e1) {
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_lexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lexActionPerformed
        // TODO add your handling code here:      
         String auxiliar2 = "......................";

        analizador.setBuffer(txt_entrada.getText());
        List<Token> listaToken = analizador.siguienteToken();
        txt_salida.append(auxiliar2);

        Proceso_imprimirlista(listaToken);
        
              
        
        auxiliar2 = "";
    }//GEN-LAST:event_btn_lexActionPerformed

    private void bt_semanticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_semanticoActionPerformed
        // TODO add your handling code here: 
        txt_entrada.grabFocus();
        txt_errores.setText("");
        txt_salida.setText("");
        
        String Entrada = txt_entrada.getText();//.replaceAll("", "\n");// para sustituir el ; por un enter
        Entrada = Entrada.trim();//ignora los espacios
        Arreglo = Entrada.split(":");//que despues del : se guarda en el siguiente arreglo

        int n = Arreglo.length;
        List<String> lista_operadores = new ArrayList<>();
        lista_operadores.add("==");
        lista_operadores.add(">");
        lista_operadores.add("<");
        lista_operadores.add("!<");
        lista_operadores.add("!>");
        lista_operadores.add("yy");
        lista_operadores.add("oo");
            
        //txt_salida.setText("los datos guardados de sintactico son: \n");
        //txt_salida.append("el total de arreglo es " + n + "\n");
//        se pide el tamaño para el for a utilizar
        int tamño = lista_operadores.size();
                
        boolean enterobien = false;
        boolean decimalbien = false;
        boolean textobien = false;
        boolean sibien = false;
        boolean mientrasbien = false;
        boolean sinobien = false;
        boolean presentarbien = false;
        boolean operacionbien = false;
        boolean falloSI = false;
  //      boolean enterobien = false;
        
String numnum2 = "([0-9]* [\\+|\\-|\\*|\\/] [0-9]*)*";
String letranum2 = "([a-z]*[0-9]* [\\+|\\-|\\*|\\/] [0-9]*)*";
String numletra2 = "([0-9]* [\\+|\\-|\\*|\\/] [a-z]*[0-9]*)*";
String letraletra2 = "([a-z]*[0-9]* [\\+|\\-|\\*|\\/] [a-z]*[0-9]*)*";

String operacionE  = "[\\s]*opentero [a-z]*[0-9]* = ("+numletra2+"|"+numnum2+"|"+letranum2+"|"+letraletra2+")";


String Dnumnum = "([0-9]*[.][0-9]* [\\+|\\-|\\*|\\/] [0-9]*[.][0-9]*)*";
String Dletranum = "([a-z]*[0-9]* [\\+|\\-|\\*|\\/] [0-9]*[.][0-9]*)*";
String Dnumletra = "([0-9]*[.][0-9]* [\\+|\\-|\\*|\\/] [a-z]*[0-9]*)*";
String Dletraletra = "([a-z]*[0-9]* [\\+|\\-|\\*|\\/] [a-z]*[0-9]*)*";

String operDecimal = "[\\s]*opdecimal [a-z]*[0-9]* = ("+Dnumletra+"|"+Dnumnum+"|"+Dletranum+"|"+Dletraletra+")";

if (Arreglo[0].contains("inicio codigo RHA;")) {
     for (int i = 1; i < n; i++) {
           System.out.println("el dato num: " + i + " es:: " + Arreglo[i].replaceAll("\n"," "));


// DECLARACION ENTERO 
        if(Arreglo[i].contains("entero ")){
            if(Arreglo[i].matches("([\\s]*entero ([a-zA-Z]*[0-9]*) = ([a-zA-Z]*[0-9]*))|("+operacionE+")")){
//                if(Arreglo[i].matches("([\\s]*entero (("+palabra_reservada+")|("+dato_decimal+")|("+dato_texto+")|("+dato_entero+")) = ("+dato_entero+"))|("+operacionE+")")){
                if(Arreglo[i].matches("[\\s]*entero (("+palabra_reservada+")|("+dato_decimal+")|("+dato_texto+")|("+dato_entero+")) = (("+palabra_reservada+")|("+dato_decimal+")|("+dato_texto+"))")){
                    txt_errores.append("es una palabra reservada o ya declarada num:  "+Arreglo[i].replaceAll("\n","")+"\n");
                    
                    }else{
                        if(Arreglo[i].matches("[\\s]*entero ([a-zA-Z]*[0-9]*) = ("+dato_entero+")")){
                            txt_salida.append("declaracion correct asignacion Variable num\n");
                        }else{
                                if(Arreglo[i].matches("[\\s]*entero ([a-zA-Z]*[0-9]*) = ("+dato_entero+"|([0-9]*))")){
                              
                                }else{
                                    txt_errores.append("esta mal la variale no existe num?:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                }                            

//para checar si solo es un numero cualquiera sin valor
                            if(Arreglo[i].matches("[\\s]*entero ([a-zA-Z]*[0-9]*) = ([0-9]*)")){
                                    if(Arreglo[i].matches("[\\s]*entero (("+palabra_reservada+")|("+dato_decimal+")|("+dato_texto+")|("+dato_entero+")) = ([0-9]*)")){
                                        txt_errores.append("es un dato ya usado o reservado "+Arreglo[i].replaceAll("\n","")+"\n");
                                    }else{
                                        txt_salida.append("declaracion correcta del numero simple \n");

                                    }
                                
                            }else{
//                                txt_errores.append("no es numero valido:  "+Arreglo[i].replaceAll("\n","")+"\n");
                            }
                        
                        }
                        
//                        txt_salida.append("declaracion correcta del entero perfect \n");
                        
                        dato_entero +=(Arreglo[i].replaceAll("\\s*"+"entero ","").replaceAll(" = ([a-zA-Z]*[0-9]*)|("+operacionE +")","")+"|");
                        enterobien = true;
                    }  
            }else {
                txt_errores.append("no has declarado bien el valor ent:  "+Arreglo[i].replaceAll("\n","")+"\n");
                enterobien = false;
                }
        }
  
        
        
        
// declaracion decimal                                                                       
        if(Arreglo[i].contains("decimal ")){
            if(Arreglo[i].matches("([\\s]*decimal [a-zA-Z]*[0-9]* = (([a-zA-Z]*[0-9]*)|[0-9]*[.][0-9]*))|("+operDecimal+")")){
                if(Arreglo[i].matches("[\\s]*decimal (("+palabra_reservada+")|("+dato_decimal+")|("+dato_texto+")|("+dato_entero+")) = (("+palabra_reservada+")|("+dato_entero+")|("+dato_texto+"))")){
                    txt_errores.append("es una palabra reservada o ya declarada dec ó no compatible :  "+Arreglo[i].replaceAll("\n","")+"\n");
                }else{
                      if(Arreglo[i].matches("[\\s]*decimal ([a-zA-Z]*[0-9]*) = ("+dato_decimal+")")){
                            txt_salida.append("declaracion correcta de asignacion dec\n");
                        }else{
                                if(Arreglo[i].matches("[\\s]*decimal ([a-zA-Z]*[0-9]*) = ("+dato_decimal+"|([0-9]*[.][0-9]*))")){
                              
                                }else{
                                    txt_errores.append("esta mal la variale no existe dec:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                }                            

//para checar si solo es un numero cualquiera sin valor
                            if(Arreglo[i].matches("[\\s]*decimal ([a-zA-Z]*[0-9]*) = ([0-9]*[.][0-9]*)")){
                                if(Arreglo[i].matches("[\\s]*decimal (("+palabra_reservada+")|("+dato_decimal+")|("+dato_texto+")|("+dato_entero+")) = ([0-9]*[.][0-9]*)")){
                                        txt_errores.append("es un dato ya usado o reservado "+Arreglo[i].replaceAll("\n","")+"\n");
                                    }else{
                                        txt_salida.append("declaracion correcta del decimal simple \n");

                                    }
                                
                                
                            }else{
//                                txt_errores.append("no es numero valido:  "+Arreglo[i].replaceAll("\n","")+"\n");
                            }
                        
                        }
                    
//                    txt_salida.append("declaracion correcta del decimal perfect \n");
                    dato_decimal +=(Arreglo[i].replaceAll("\\s*"+"decimal ","").replaceAll(" = ([a-zA-Z]*[0-9]*)|[0-9]*[.][0-9]*|("+operDecimal+")","")+"|");
                    decimalbien= true;
                }        
                
            }else{
                
                    txt_errores.append("no has declarado bien el valordec :  "+Arreglo[i].replaceAll("\n","")+"\n");
                    decimalbien = false;
                  }
        }
              
// DECLARACION texto                                           
        if(Arreglo[i].contains("texto ")){
            if(Arreglo[i].matches("[\\s]*texto [a-zA-Z]*[0-9]* = '[a-zA-Z|0-9|\\s]*'")){
                if(Arreglo[i].matches("([\\s]*texto (("+palabra_reservada+")|("+dato_decimal+")|("+dato_texto+")|("+dato_entero+")) = '[a-zA-Z|0-9|\\s]*')")){
                    txt_errores.append("valor usado o palabra reservada txt:  "+Arreglo[i].replaceAll("\n","")+"\n");
                    textobien = false;
                }else{
                    txt_salida.append("declaracion correcta del texto perfect \n");
                    dato_texto +=(Arreglo[i].replaceAll("\\s*"+"texto ","").replaceAll(" = '[a-zA-Z|0-9|\\s]*'","")+"|");
                    textobien = true;
                    }                
            }else{
                txt_errores.append("no has declarado bien el valor txt:  "+Arreglo[i].replaceAll("\n","")+"\n");
                textobien = false;
                }
        }
            
   
    }//termino del Arreglo[i]

     
     if(enterobien==true && decimalbien==true&& textobien== true && sibien ==true && mientrasbien ==true && presentarbien==true && operacionbien == true ){
                txt_salida.append("compilo bien ooo");
                System.out.println("compilooo ibien ");
            }else{
                System.out.println("compilo mal");
            }
            
      }else{//del arreglo 0 que esta bien
       txt_errores.append("no has iniciado el codigo es 'inicio codigo RHA;:' y tienes el valor: "+Arreglo[0]);
      }
      
               System.out.println("Datos guardado entero son: "+ dato_entero+"\n");
               System.out.println("Datos guardado decimal son: "+ dato_decimal+"\n");
               System.out.println("Datos guardado TEXTO son: "+ dato_texto+"\n");
               System.out.println("datos de oper ENTERO:  "+dato_operE+"\n");
               System.out.println("datos de operacion DEC:  "+dato_operDec+"\n");

// otro for para buscar mas datos 
for (int i = 1; i < n; i++) {
        String numnum = "([0-9]* [\\+|\\-|\\*|\\/] [0-9]*)*";
        String letranum = "(("+dato_entero+") [\\+|\\-|\\*|\\/] [0-9]*)*";
        String numletra = "([0-9]* [\\+|\\-|\\*|\\/] ("+dato_entero+"))*";
        String letraletra = "(("+dato_entero+") [\\+|\\-|\\*|\\/] ("+dato_entero+"))*";

        String operEntero = "[\\s]*opEntero [a-z]*[0-9]* = ("+numletra+"|"+numnum+"|"+letranum+"|"+letraletra+")";

        
        String numnumIF = "((([0-9]*)|([0-9]*[.][0-9]*)) [<|>|=|=>] (([0-9]*)|([0-9]*[.][0-9]*)))*";
        String letranumIF = "(("+dato_entero+dato_operE+dato_decimal+") [<|>|=|=>] (([0-9]*)|([0-9]*[.][0-9]*)))*";
        String numletraIF = "((([0-9]*)|([0-9]*[.][0-9]*)) [<|>|=|=>] ("+dato_entero+dato_operE+dato_decimal+"))*";
        String letraletraIF = "(("+dato_entero+dato_operE+dato_decimal+") [<|>|=|=>] ("+dato_entero+dato_operE+dato_decimal+"))*";

        String delIF = "("+numletraIF+"|"+numnumIF+"|"+letranumIF+"|"+letraletraIF+")";

        
        String numnumD = "([0-9]*[.][0-9]* [\\+|\\-|\\*|\\/] [0-9]*[.][0-9]*)*";
        String letranumD = "(("+dato_decimal+") [\\+|\\-|\\*|\\/] [0-9]*[.][0-9]*)*";
        String numletraD = "([0-9]*[.][0-9]* [\\+|\\-|\\*|\\/] ("+dato_decimal+"))";
        String letraletraD = "(("+dato_decimal+") [\\+|\\-|\\*|\\/] ("+dato_decimal+"))*";

        String operDecimal2 = "[\\s]*opDecimal [a-z]*[0-9]* = ("+numletraD+"|"+numnumD+"|"+letranumD+"|"+letraletraD+")";


//operacion entero
        if(Arreglo[i].contains("opEntero ")){
           if(Arreglo[i].matches("("+operEntero+")")){
                                    txt_salida.append("operacion Ent correct\n");
                                    dato_operE +=(Arreglo[i].replaceAll("\\s*"+"opEntero ","").replaceAll(" = ([a-zA-Z]*[0-9]*)|(("+numletra+"|"+numnum+"|"+letranum+"|"+letraletra+"))","")+"|");
                                    System.out.println("dato operacion es: "+ dato_operE);
                                }else{
                                    txt_errores.append("no esta declarado algun valor ent:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                }
                }else{

                }  
        
//operacion decimal
        if(Arreglo[i].contains("opDecimal ")){
           if(Arreglo[i].matches("("+operDecimal2+")")){
                                    txt_salida.append("operacion DECimal correct\n");
                                dato_operDec +=(Arreglo[i].replaceAll("\\s*"+"opDecimal ","").replaceAll(" = ([a-zA-Z]*[0-9]*)|(("+numletraD+"|"+numnumD+"|"+letranumD+"|"+letraletraD+"))","")+"|");
                                    System.out.println("dato operacion decimal es:  "+dato_operDec);
                                }else{
                                    txt_errores.append("no esta declarado algun valor dec:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                }
                }else{

                }           
          
// asignacion iff
    if(Arreglo[i].contains("si ")){
           if(Arreglo[i].matches("[\\s]*si \\( ("+delIF+") \\) \\{")){
               for (int j = i+1; j < n; j++) {
                  if(Arreglo[j].contains("}")){
                      txt_salida.append("ta bien  if: \n");
                      
                  }else{
                      txt_errores.append(" te falta el valor } PERO si aparece 'ta bien  if:' IGNORAR :)\n");     
                  }
               }
               
           }else{
               txt_errores.append(" no hay valor asignado del if:  "+Arreglo[i].replaceAll("\n","")+"\n");
           }        

    }        
        
// asiganacion while                                           
            if(Arreglo[i].contains("mientras ")){
                   if(Arreglo[i].matches("[\\s]*mientras \\( ("+delIF+") \\) \\{")){
                       for (int j = i+1; j < n; j++) {
                                       if(Arreglo[j].contains("}")){
                                            txt_salida.append("declaracion correcta del mientras \n");
                                            mientrasbien = true;
                                       }else{
                                           txt_errores.append("tamal el while mexicaon PERO SI APARECE EL 'declaracion correcta del mientras' IGNORAR ji\n");
                                       }
                       }
                                }else{
                                txt_errores.append("no has declarado bien el valor:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                mientrasbien= false;
                   }
            }        
          
            
// Mostrar datos en pantalla                                                                       
          if(Arreglo[i].contains("presentar ")){
                  if(Arreglo[i].matches("[\\s]*presentar = ([a-zA-Z]*[0-9]*)")){
                                                    
                      if(Arreglo[i].matches("[\\s]*presentar = (("+palabra_reservada+"))")){
                                  txt_errores.append("es una palabra reservada no puedes imprimir. \n" );
                              }else{
                                   
                                  if(Arreglo[i].matches("[\\s]*presentar = ("+dato_entero+""+dato_decimal+""+dato_texto+""+dato_operE+")")){
                                    txt_salida.append("has mostrado bien los datos:  "+Arreglo[i].replaceAll("presentar ","").replaceAll("\n", "")+" \n");
                                    presentarbien = true;
                                   }else{
                                      txt_errores.append("no existe la variable:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                  
                                  }
                                  
                                   
                                   
                              }
                              
                               
                    }else{
                         txt_errores.append("no has declarado bien el valor presentar:  "+Arreglo[i].replaceAll("\n","")+"\n");
                         presentarbien = false;
                  }
            
            }
                      
            

}//For

        

//operaciones();
           dato_entero = "";
           dato_decimal = "";
           dato_texto = "";
           dato_operDec = "";
           dato_operE = "";


    }//GEN-LAST:event_bt_semanticoActionPerformed
//
    
    
  public void operaciones(){
      System.out.println("dato "+dato_entero+"\n");
      int n = Arreglo.length;
   for (int i = 1; i < n; i++) {

        String numnum = "([0-9]* [\\+|\\-|\\*|\\/] [0-9]*)*";
        String letranum = "(("+dato_entero+") [\\+|\\-|\\*|\\/] [0-9]*)*";
        String numletra = "([0-9]* [\\+|\\-|\\*|\\/] ("+dato_entero+"))*";
        String letraletra = "(("+dato_entero+") [\\+|\\-|\\*|\\/] ("+dato_entero+"))*";

        String operEntero = "[\\s]*opEntero [a-z]*[0-9]* = ("+numletra+"|"+numnum+"|"+letranum+"|"+letraletra+")";

        
String numnumD = "([0-9]*[.][0-9]* [\\+|\\-|\\*|\\/] [0-9]*[.][0-9]*)*";
String letranumD = "(("+dato_decimal+") [\\+|\\-|\\*|\\/] [0-9]*[.][0-9]*)*";
String numletraD = "([0-9]*[.][0-9]* [\\+|\\-|\\*|\\/] ("+dato_decimal+"))";
String letraletraD = "(("+dato_decimal+") [\\+|\\-|\\*|\\/] ("+dato_decimal+"))*";

        String operDecimal = "[\\s]*opDecimal [a-z]*[0-9]* = ("+numletraD+"|"+numnumD+"|"+letranumD+"|"+letraletraD+")";

//         System.out.println("el dato entero qeu tiene hassta ahora es: " +dato_entero+"\n");
//         System.out.println("el dato entero qeu tiene hassta ahora es: " +dato_decimal+"\n");
         
        
        //operacion entero
        if(Arreglo[i].contains("opEntero ")){
           if(Arreglo[i].matches("("+operEntero+")")){
                                    txt_salida.append("operacion Ent correct\n");
                                    dato_operE +=(Arreglo[i].replaceAll("\\s*"+"opEntero ","").replaceAll(" = ([a-zA-Z]*[0-9]*)|(("+numletra+"|"+numnum+"|"+letranum+"|"+letraletra+"))","")+"|");
                                    System.out.println("dato operacion es: "+ dato_operE);
                                }else{
                                    txt_errores.append("no esta declarado algun valor ent:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                }
                }else{

                }                        

           
   
        //operacion decimal
        if(Arreglo[i].contains("opDecimal ")){
           if(Arreglo[i].matches("("+operDecimal+")")){
                                    txt_salida.append("operacion DECimal correct\n");
                                dato_operDec +=(Arreglo[i].replaceAll("\\s*"+"opDecimal ","").replaceAll(" = ([a-zA-Z]*[0-9]*)|(("+numletraD+"|"+numnumD+"|"+letranumD+"|"+letraletraD+"))","")+"|");
                                    System.out.println("dato operacion decimal es:  "+dato_operDec);
                                }else{
                                    txt_errores.append("no esta declarado algun valor dec:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                }
                }else{

                }                        

   
       }// for del arreglo
   
  }//void operaciones
    
    
    
private void Proceso_analizar(List<Token> listaToken) {
        String auxiliar = " ";

        for (int i = 0; i < listaToken.size(); i++) {
            auxiliar += listaToken.get(i).getNombre() + " -> " + listaToken.get(i).getValor() + "\n";
        }
        txt_salida.setText(auxiliar);
        //

    }

 private void Proceso_imprimirlista(List<Token> listaToken) {

     String auxiliar = "  Valor - - - - - - - - - - Tokens\n";
        for (int i = 0; i < listaToken.size(); i++) {
                      txt_salida.setText("");

            auxiliar += "Es " + listaToken.get(i).getNombre() + " -> -> -> con valor de " + listaToken.get(i).getValor() + "\n";
            
        }
        txt_salida.setText(auxiliar);

auxiliar = "";
    }

    
    
 

    private void proceso_regex(List<Token> listaToken) {
        String auxiliar = "   - Tokens\n";

        for (int i = 0; i < listaToken.size(); i++) {
            auxiliar += "Es " + listaToken.get(i).getNombre() + " -> -> -> con valor de " + listaToken.get(i).getValor() + "\n";
            Pattern patron = Pattern.compile("^[0-9]{0,}[a-zA-Z]{0,}$");
            Matcher matcher = patron.matcher(listaToken.get(i).getValor());
            boolean resultado = matcher.matches();
            txt_errores.setText("el error es " + resultado);

        }
        txt_errores.setText("el error es " + auxiliar);

    }  

 

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
                new FprincipalLEXICO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_semantico;
    private javax.swing.JButton bt_sintactico;
    private javax.swing.JButton btn_lex;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneErrores;
    private javax.swing.JScrollPane jScroll_entrada;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTabbedPane tabb;
    private javax.swing.JPanel todo;
    private javax.swing.JTextArea txt_entrada;
    private javax.swing.JTextArea txt_errores;
    private javax.swing.JTextArea txt_salida;
    // End of variables declaration//GEN-END:variables
}
