package analizarr;

public class Error {
    
    private Integer fila;
    private Integer columna;
    private String descripcion;

    public Error() {
    }

    public Error(Integer fila, Integer columna, String descripcion) {
        this.fila = fila;
        this.columna = columna;
        this.descripcion = descripcion;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public String getDescripcion() {
        return descripcion;
    }
    
    
    
}
