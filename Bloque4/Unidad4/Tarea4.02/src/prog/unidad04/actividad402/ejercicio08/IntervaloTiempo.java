package prog.unidad04.actividad402.ejercicio08;

public class IntervaloTiempo {
  
  // ------------------------------ Bloque de atributos ------------------------------
  /**
   * Horas del intervalo
   */
  private int horas;
  
  /**
   * Minutos del intervalo
   */
  private int minutos;
  
  /**
   * Segundos del intervalo
   */
  private int segundos;
  
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Construye un intervalo de tiempo con horas, minutos y segundos.
   * @param horas Las horas del intervalo. Debe ser un número mayor que cero. Su valor por defecto es 0.
   * @param minutos Los minutos del intervalo. Debe ser un número entre 0 y 59. Su valor por defecto es 0.
   * @param segundos Los segundos del intervalo. Debe ser un número entre 0 y 59. Su valor por defecto es 0.
   */
  public IntervaloTiempo(int horas, int minutos, int segundos) {
    
    if (horas < 0) {
      horas = 0;
      System.out.println("El número de horas no puede ser menor que cero. Se pondrá cero por defecto.");
    }
    
    this.horas = horas;
    this.minutos = compruebaMinutosSegundos(minutos);
    this.segundos = compruebaMinutosSegundos(segundos);
  }
  
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  /**
   * Devuelve una cadena descriptiva del intervalo de tiempo en formato "AAh BBm CCs", 
   * siendo AA las horas, BB los minutos y CC los segundos.
   * @return Cadena de caractéres con formato "AAh BBm CCs".
   */
  public String obtenerCadena() {
    return horas + "h " + minutos + "m " + segundos + "s";
  }
  
  /**
   * Método que suma dos intervalos de tiempo.
   * @param intervalo Intervalo que sumaremos al objeto sobre el que llamamos el método.
   * @return Un nuevo intervalo de tiempo que sea la suma de los dos anteriores.
   */
  public IntervaloTiempo suma(IntervaloTiempo intervalo) {
        
    // Con esta variable contamos si "nos llevamos una" en la suma 
    int contadorCuenta = 0;
    
    // Sumamos los segundos
    int segundos = this.segundos + intervalo.getSegundos();
    if(segundos > 59) {
      segundos -= 60;
      contadorCuenta++;
    }
    
    // Sumamos los minutos
    int minutos = this.minutos + intervalo.getMinutos() + contadorCuenta;
    // Reiniciamos el contador
    contadorCuenta = 0;
    if (minutos > 59) {
      minutos -= 60;
      contadorCuenta++;
    }
    
    // Sumamos las horas
    int horas = this.horas + intervalo.getHoras() + contadorCuenta;
    
    return new IntervaloTiempo(horas, minutos, segundos);
    
  }
  
  public IntervaloTiempo resta(IntervaloTiempo intervalo) {
    
    // Comprobamos que se pueden restar. Si no pueden, devolvemos un intervalo de tiempo 0.
    if (this.horas < intervalo.getHoras() || (this.horas == intervalo.getHoras() && this.minutos < intervalo.getMinutos()) 
        || (this.horas < intervalo.getHoras() && this.minutos == intervalo.getMinutos() && this.segundos == intervalo.getSegundos())){
      
      System.out.println("No se pueden restar los intervalos indicados puesto que no puede haber un intervalo de tiempo negativo."
          + " Devolvemos el intervalo por defecto: 0H 0M 0S");
      return new IntervaloTiempo(0,0,0);
    }else {
      // Si se pueden restar hay que considerar los casos en los que haya que mover dígitos para restar segundos
      if (this.segundos < intervalo.getSegundos() && this.minutos != 0) {
        minutos--;
        segundos += 60;

      } else if (this.segundos < intervalo.getSegundos() && this.minutos == 0) {
        horas--;
        minutos += 59;
        segundos += 60;
      }
      
      // Consideramos los casos para restar los minutos
      if (this.minutos < intervalo.getMinutos()) {
        horas--;
        minutos += 60;
      }
      
      int segundos = this.segundos - intervalo.getSegundos();
      int minutos = this.minutos - intervalo.getMinutos();
      int horas = this.horas - intervalo.getHoras();
      
      return new IntervaloTiempo(horas, minutos, segundos);
      
    }
    
  }
  
  
  // Comprobación de horas y minutos
  private int compruebaMinutosSegundos(int cantidad) {
    if (cantidad < 0 || cantidad > 59) {
      cantidad = 0;
      System.out.println("La cantidad de minutos o segundos no se encuentra en el intervalo. Por defecto, se establecerá en 0.");
    }

    return cantidad;
  }

  
  // Getters de los intervalos
  
  public int getHoras() {
    return horas;
  }


  public int getMinutos() {
    return minutos;
  }


  public int getSegundos() {
    return segundos;
  }
  
}
