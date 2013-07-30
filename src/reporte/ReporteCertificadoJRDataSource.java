/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;
import dao.imp.PersonaDAOImp;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.List;
import modelo.Certificado;
import modelo.Persona;
import util.FechaUtil;

/**
 *
 * @author alumno
 */
public class ReporteCertificadoJRDataSource implements JRDataSource{
    
    int index =-1;
    Certificado a;
    List<Certificado> listaCertificado = new ArrayList<Certificado>();
    
   public boolean next() throws JRException {
        
        return ++index < listaCertificado.size();
    }

    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor=null;
       Persona padrino = new PersonaDAOImp().getPersona(listaCertificado.get(index).getIdPadrino());
       Persona cura = new PersonaDAOImp().getPersona(listaCertificado.get(index).getIdCura());
       Persona madrina = new PersonaDAOImp().getPersona(listaCertificado.get(index).getIdMadrina());
       Persona tutor = new PersonaDAOImp().getPersona(listaCertificado.get(index).getIdTutor());
       Persona tutora = new PersonaDAOImp().getPersona(listaCertificado.get(index).getIdTutora());
       Persona bautizado = new PersonaDAOImp().getPersona(listaCertificado.get(index).getIdAhijado());
        if ("libro".equals(jrf.getName())) {
            valor =  listaCertificado.get(index).getLibro();
        
        } else if ("folio".equals(jrf.getName())) {
           valor =  listaCertificado.get(index).getFolio();

        }else if("partida".equals(jrf.getName())){
            valor = listaCertificado.get(index).getPartida();
        }else if("ciudad".equals(jrf.getName())){
            // falta la ciudad dela iglesia.!! de donde se va a bautizar
            valor = "San Salvador de Jujuy";
        }else if("dia".equals(jrf.getName())){
            
            valor = FechaUtil.getDia(listaCertificado.get(index).getFechaBautizmo());
        }
        else if("mes".equals(jrf.getName())){
            valor = FechaUtil.getMesString(listaCertificado.get(index).getFechaBautizmo());
        }
        else if("anio".equals(jrf.getName())){
            valor = FechaUtil.getAnio(listaCertificado.get(index).getFechaBautizmo());
        }
        else if("cura".equals(jrf.getName())){
            valor = cura.getApellido()+" "+cura.getNombre();
        }
        else if("baut".equals(jrf.getName())){
            valor = bautizado.getApellido()+" "+bautizado.getNombre();
        }
        else if("dniBaut".equals(jrf.getName())){
            valor = bautizado.getDni();
        }
        else if("lugarNacimBaut".equals(jrf.getName())){
            valor = bautizado.getLugarNacimiento();
        }
        else if("provinciaNacimBaut".equals(jrf.getName())){
            valor = bautizado.getProvNacimiento();
        }
        else if("nacionBaut".equals(jrf.getName())){
            valor = bautizado.getNacionalidad();
        }
        else if("diaNacimBaut".equals(jrf.getName())){
            valor = FechaUtil.getDia(bautizado.getFechaNaciemiento());
        }
        else if("mesNacimBaut".equals(jrf.getName())){
            valor = FechaUtil.getMesString(bautizado.getFechaNaciemiento());
        }
        else if("anioNacimBaut".equals(jrf.getName())){
            valor = FechaUtil.getAnio(bautizado.getFechaNaciemiento());
        }
        else if("hijo".equals(jrf.getName())){
            // ver si este es el filtro 
            valor = bautizado.getTipoDeHijo();
           
            
        }
        else if("padreBaut".equals(jrf.getName())){
            valor = tutor.getApellido()+" "+tutor.getNombre();
        }
        else if("nacionPadre".equals(jrf.getName())){
            valor = tutor.getNacionalidad();
        }
        else if("madreBaut".equals(jrf.getName())){
            valor = tutora.getApellido()+" "+tutora.getNombre();
        }
        else if("nacionMadre".equals(jrf.getName())){
            valor = tutora.getNacionalidad();
        }
        else if("domicilioPadres".equals(jrf.getName())){
           
            valor = listaCertificado.get(index).getDomicilioPadres();
        }
        else if("nombrePadrino".equals(jrf.getName())){
            valor = padrino.getApellido()+" "+padrino.getNombre();
        }
        else if("nombreMadrina".equals(jrf.getName())){
            valor = madrina.getApellido()+" "+madrina.getNombre();
        }
        else if("parroquia".equals(jrf.getName())){
            valor = listaCertificado.get(index).getNombreParroquia();
        }
        else if("fechaNacimBaut".equals(jrf.getName())){
            valor = FechaUtil.getDateDD_MM_AAAA(bautizado.getFechaNaciemiento());
        }
        else if("fechaBautismo".equals(jrf.getName())){
            valor = FechaUtil.getDateDD_MM_AAAA(listaCertificado.get(index).getFechaBautizmo());
        }
               
       return valor;
    
    }
     public void addCertificado(Certificado a)
    {
        this.a=a;
    }
    
     public void setListCertificado(List<Certificado> e){
         this.listaCertificado = e;
     }
    
}






