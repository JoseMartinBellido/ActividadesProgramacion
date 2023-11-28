package prog.unidad04.actividad402.ejercicio04;

public class Lavadora {

  // ------------------------------ Constantes de la clase ------------------------------
  
  // Constantes de color
  
  /**
   * Color de lavadora: Blanco
   */
  public static final String COLOR_BLANCO = "blanco";
  
  /**
   * Color de lavadora: Blanco
   */
  public static final String COLOR_AZUL = "azul";
  
  /**
   * Color de lavadora: Negro
   */
  public static final String COLOR_NEGRO = "negro";
  
  /**
   * Color de lavadora: Gris
   */
  public static final String COLOR_GRIS = "gris";
  
  /**
   * Color de lavadora: Rojo
   */
  public static final String COLOR_ROJO = "rojo";
  
  // Constantes del consumo energético
  
  private static final char CONSUMO_A = 'A';
  private static final char CONSUMO_B = 'B';
  private static final char CONSUMO_C = 'C';
  private static final char CONSUMO_D = 'D';
  private static final char CONSUMO_E = 'E';
  private static final char CONSUMO_F = 'F';
  
  
  
  // ------------------------------ Bloque de atributos ------------------------------
  /**
   * Precio base de la lavadora. Establecido en euros (€). Por defecto, será de 200€.
   */
  public double precioBase;
  
  /**
   * Color de la lavadora. Debe ser blanco, negro, azul, gris o rojo. Por defecto, será blanco.
   */
  public String color;
  
  /**
   * Consumo energético de la lavadora. Es una letra de la A a la F, siendo la A la que tiene un menor consumo y la F la que más.
   * Por defecto, será F.
   */
  public char consumoEnergetico;
  
  /**
   * Peso de la lavadora. Establecido en kilogramos (kg). Por defecto, serán 15kg.
   */
  public double peso;
  
  /**
   * Carga de la lavadora. Establecido en kilogramos (kg). Por defecto, serán 5kg.
   */
  public double carga;
  
  // ------------------------------ Bloque de constructores ------------------------------
  
  /**
   * Constructor por defecto. Tiene como valores:
   * Precio base: 200€
   * color: Blanco
   * Consumo energético: F
   * Peso: 15kg
   * Carga: 5kg
   */
  public Lavadora() {
    precioBase = 200;
    color = COLOR_BLANCO;
    consumoEnergetico = CONSUMO_F;
    peso = 15;
    carga = 5;
        
  }
  
  /**
   * Constructor Lavadora con dos parámetros: Precio base y peso
   * Para el resto de atributos, se usan los valores por defecto:
   * Color: Blanco
   * Consumo Energético: F
   * Carga: 5kg
   * @param precioBase Precio base de la lavadora en euros (€). Si es negativo, se tomará el valor por defecto.
   * @param peso Peso de la lavadora en kilogramos (kg). Si es negativo, se tomará el valor por defecto.
   */
  public Lavadora(double precioBase, double peso) {
    this();
    
    if (precioBase < 0)
      System.out.println("El valor del precio base no puede ser negativo. Se tomará el valor por defecto: 200");
    else
      this.precioBase = precioBase;
    
    if(peso < 0)
      System.out.println("El valor del peso no puede ser negativo. Se tomará el valor por defecto: 15");
    else
      this.peso = peso;
  }
  
  /**
   * Constructor con todos los atributos
   * @param precioBase Precio base de la lavadora en euros (€). Si es negativo, se tomará el valor por defecto.
   * @param color Color de la lavadora. Si no es un color predeterminado, se tomará el valor por defecto: Blanco
   * @param consumoEnergetico Consumo energético de la lavadora. Es una letra de la 'A' a la 'F'. 
   * Si no es correcto, se tomará el valor por defecto: 'F'
   * @param peso Peso de la lavadora en kilogramos (kg). Si es negativo, se tomará el valor por defecto.
   * @param carga Carga de la lavadora en kilogramos (kg). Si es negativo, se tomará el valor por defecto.
   */
  public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
    
    this(precioBase, peso);
    
    this.color = compruebaColor(color);
    
    this.consumoEnergetico = compruebaConsumo(consumoEnergetico);
     
    if(peso < 0)
      System.out.println("El valor de la carga no puede ser negativo. Se tomará el valor por defecto: 5");
    else
      this.carga = carga;
    
    
    
  }
  
  // ------------------------------ Bloque de métodos ------------------------------
  
  
  // Métodos públicos
  
  /**
   * Obtiene el precio base.
   * @return El precio base
   */
  public double getPrecioBase() {
    return precioBase;
  }

  /**
   * Obtiene el color de la lavadora.
   * @return El color de la lavadora
   */
  public String getColor() {
    return color;
  }

  /**
   * Obtiene el consumo energético.
   * @return El consumo energético
   */
  public char getConsumoEnergetico() {
    return consumoEnergetico;
  }

  /**
   * Obtiene el peso de la lavadora.
   * @return El peso de la lavadora
   */
  public double getPeso() {
    return peso;
  }

  /**
   * Obtiene la carga de la lavadora.
   * @return La carga de la lavadora
   */
  public double getCarga() {
    return carga;
  }
  
  /**
   * Obtiene el precio final de la lavadora en euros (€) , que se calculará sumándole al precio base un extra 
   * por el consumo energético, la carga y el peso.
   * @return El precio final de la lavadora, en euros (€).
   */
  public double getPrecioFinal() {
    // Partimos del precio base 
    double precioFinal = precioBase;
    
    // Sumamos un extra dependiendo del consumo energético
    if (consumoEnergetico == CONSUMO_A)
      precioFinal += 100;
    else if (consumoEnergetico == CONSUMO_B)
      precioFinal += 80;
    else if (consumoEnergetico == CONSUMO_C)
      precioFinal += 60;
    else if (consumoEnergetico == CONSUMO_D)
      precioFinal += 50;
    else if (consumoEnergetico == CONSUMO_E)
      precioFinal += 30;
    else 
      precioFinal += 10;
    
    // Sumamos un extra dependiendo del peso de la lavadora
    if (peso < 20)
      precioFinal += 10;
    else if (peso < 50)
      precioFinal += 50;
    else if (peso < 80)
      precioFinal += 80;
    else
      precioFinal += 100;
    
    // Sumamos un extra dependiendo de la carga de la lavadora
    if (carga > 30)
      precioFinal += 50;
    
    // Devolvemos el precio final
    return precioFinal;
    
  }
  
  // Métodos privados
  
  // Método que comprueba el consumo energético de la lavadora al ser introducido
  
  private char compruebaConsumo (char consumoEnergetico) {
    
    if (consumoEnergetico != CONSUMO_A && consumoEnergetico != CONSUMO_B && consumoEnergetico != CONSUMO_C 
        && consumoEnergetico != CONSUMO_D && consumoEnergetico != CONSUMO_E && consumoEnergetico != CONSUMO_F) {
      System.out.println("El consumo energético introducido no se encuentra entre las variedades disponibles. "
          + "Se establecerá el consumo energético por defecto: F");
      return CONSUMO_F;
    } else
      return consumoEnergetico;
  }
  
  // Método que comprueba el color de la lavadora al ser introducido
  private String compruebaColor (String color) {
    
    if (!color.equals(COLOR_BLANCO) && !color.equals(COLOR_NEGRO) && !color.equals(COLOR_AZUL) && !color.equals(COLOR_GRIS) 
        && !color.equals(COLOR_ROJO)) {
      System.out.println("El color indicado no se encuentra entre la variedad disponible. Se pondrá el valor por defecto: blanco");
      return COLOR_BLANCO;
    }

    else
      return color;
  }
  
}
