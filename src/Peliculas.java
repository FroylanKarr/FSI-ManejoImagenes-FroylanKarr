
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import javax.swing.ImageIcon;


public class Peliculas implements Serializable{
    private String clave, titulo;
    private ImageIcon cartel;

    public Peliculas(String clave, String titulo, ImageIcon cartel) {
        this.clave = clave;
        this.titulo = titulo;
        this.cartel = cartel;
    }
    
    public int Insertar(Conexion cnx){
    try {
        String sql = "INSERT INTO peliculas VALUE(?,?,?)";
        PreparedStatement ps = (PreparedStatement) cnx.con.prepareStatement(sql);
        ps.setString(1, clave);
        ps.setString(2, titulo);
        ps.setBinaryStream(3, cnx.ImagenBytes(cartel));
        return ps.executeUpdate();
    } catch (Exception e) {
        System.out.println("Error al insertar: " + e.getMessage());
        return 0;
    }

}
    
}
