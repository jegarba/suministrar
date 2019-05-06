package Modelos;

import Conexion.Conexion;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class PdfBo {

    Conexion C = new Conexion();

    public ArrayList<PdfVo> Listar_PdfVo() {

        ArrayList<PdfVo> list = new ArrayList<PdfVo>();
        try {
            String ConsultaListar = "SELECT * FROM pdf;";
            Statement Puente = C.Conectar().createStatement();
            ResultSet rs = Puente.executeQuery(ConsultaListar);
            DefaultComboBoxModel Combo = new DefaultComboBoxModel();
            Combo.addElement("Seleccione Una Drogeria");
            while (rs.next()) {
                PdfVo vo = new PdfVo();
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setArchivopdf(rs.getBytes(3));
                vo.setValorpdf(rs.getInt(4));
                vo.setFechaemi(rs.getDate(5));
                vo.setFechavenci(rs.getDate(6));
                vo.setDrogeria(rs.getInt(7));
                vo.setProveedor(rs.getInt(8));
                list.add(vo);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    /*Metodo agregar*/
    public void Agregar_PdfVO(PdfVo vo) {
        String sql = "INSERT INTO pdf (codigopdf, nombrepdf, archivopdf, valorpdf, fechaemision , fechavencimiento, drogeriapdf , proveedorpdf) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = C.Conectar().prepareStatement(sql);
            ps.setInt(1, vo.getCodigopdf());
            ps.setString(2, vo.getNombrepdf());
            ps.setBytes(3, vo.getArchivopdf());
            ps.setInt(4, vo.getValorpdf());
            ps.setDate(5, vo.getFechaemi());
            ps.setDate(6, vo.getFechavenci());
            ps.setInt(7, vo.getDrogeria());
            ps.setInt(8, vo.getProveedor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                C.desconectar();
            } catch (Exception ex) {
            }
        }
    }


    /*Metodo Modificar*/
    public void Modificar_PdfVO(PdfVo vo) {
        String sql = "UPDATE pdf SET nombrepdf = ?, archivopdf = ? , valorpdf = ? , fechaemision = ? , fechavencimiento = ? , drogeriapdf = ? , proveedorpdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = C.Conectar().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setBytes(2, vo.getArchivopdf());
            ps.setInt(3, vo.getValorpdf());
            ps.setDate(4, vo.getFechaemi());
            ps.setDate(5, vo.getFechavenci());
            ps.setInt(6, vo.getDrogeria());
            ps.setInt(7, vo.getProveedor());
            ps.setInt(8, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                C.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    public void Modificar_PdfVO2(PdfVo vo) {
        String sql = "UPDATE pdf SET nombrepdf = ? , valorpdf = ? , fechaemision = ? , fechavencimiento = ? , drogeriapdf = ? , proveedorpdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = C.Conectar().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setInt(2, vo.getValorpdf());
            ps.setDate(3, vo.getFechaemi());
            ps.setDate(4, vo.getFechavenci());
            ps.setInt(5, vo.getDrogeria());
            ps.setInt(6, vo.getProveedor());
            ps.setInt(7, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                C.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    /*Metodo Eliminar*/
    public void Eliminar_PdfVO(PdfVo vo) {
        String sql = "DELETE FROM pdf WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = C.Conectar().prepareStatement(sql);
            ps.setInt(1, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                C.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    //Permite mostrar PDF contenido en la base de datos
    public void ejecutar_archivoPDF(int id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = C.Conectar().prepareStatement("SELECT archivopdf FROM pdf WHERE codigopdf = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
            C.desconectar();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }

}
