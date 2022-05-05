# compiladorPaez👩‍💻
un analizador lexico y sintactico sin jflex
se guarda en un arreglo despues de un ":" para luego ser analizados por el metodo matches

```java   
//para guardar los datos que se ingresa en el area de texto        
        txt_errores.setText("");
        txt_salida.setText("");
        
        String Entrada = txt_entrada.getText();//.replaceAll("", "\n");// para sustituir el ; por un enter
        Entrada = Entrada.trim();//ignora los espacios
        Arreglo = Entrada.split(":");//que despues del : se guarda en el siguiente arreglo


```


```java
            if(Arreglo[i].contains("texto ")){
                   if(Arreglo[i].matches("[\\s]*texto [a-zA-Z]*[0-9]* = '[a-zA-Z|0-9|\\s]*'")){
                                txt_salida.append("declaracion correcta del texto perfect \n");
                                textobien = true;
                                }else{
                                txt_errores.append("no has declarado bien el valor:  "+Arreglo[i].replaceAll("\n","")+"\n");
                                textobien = false;
                   }
            }
   ```

##pantalla principal tiene una pestaña de seccion de ayuda en la parte de abajo
![por_si_acaso](pantallaprin.png)

