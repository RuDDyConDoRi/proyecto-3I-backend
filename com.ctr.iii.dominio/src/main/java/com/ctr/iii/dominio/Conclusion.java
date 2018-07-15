/*
 * Created on 15 jul 2018 ( Time 15:07:20 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.ctr.iii.dominio;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "conclusion"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="conclusion", catalog="plaproc" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Conclusion.countAll", query="SELECT COUNT(x) FROM Conclusion x" )
} )
public class Conclusion implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="codCas", nullable=false, length=15)
    private String     codCas       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="tipoResol", length=50)
    private String     tipoResol    ;

    @Column(name="accion", length=50)
    private String     accion       ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaIngresoDoc")
    private Date       fechaIngresoDoc ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaEmiRes")
    private Date       fechaEmiRes  ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="codCas", referencedColumnName="codCas", insertable=false, updatable=false)
    private Caso caso        ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Conclusion() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCodCas( String codCas ) {
        this.codCas = codCas ;
    }
    public String getCodCas() {
        return this.codCas;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : tipoResol ( VARCHAR ) 
    public void setTipoResol( String tipoResol ) {
        this.tipoResol = tipoResol;
    }
    public String getTipoResol() {
        return this.tipoResol;
    }

    //--- DATABASE MAPPING : accion ( VARCHAR ) 
    public void setAccion( String accion ) {
        this.accion = accion;
    }
    public String getAccion() {
        return this.accion;
    }

    //--- DATABASE MAPPING : fechaIngresoDoc ( DATETIME ) 
    public void setFechaIngresoDoc( Date fechaIngresoDoc ) {
        this.fechaIngresoDoc = fechaIngresoDoc;
    }
    public Date getFechaIngresoDoc() {
        return this.fechaIngresoDoc;
    }

    //--- DATABASE MAPPING : fechaEmiRes ( DATETIME ) 
    public void setFechaEmiRes( Date fechaEmiRes ) {
        this.fechaEmiRes = fechaEmiRes;
    }
    public Date getFechaEmiRes() {
        return this.fechaEmiRes;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setCaso( Caso caso ) {
        this.caso = caso;
    }
    public Caso getCaso() {
        return this.caso;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(codCas);
        sb.append("]:"); 
        sb.append(tipoResol);
        sb.append("|");
        sb.append(accion);
        sb.append("|");
        sb.append(fechaIngresoDoc);
        sb.append("|");
        sb.append(fechaEmiRes);
        return sb.toString(); 
    } 

}