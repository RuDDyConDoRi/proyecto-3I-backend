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
 * Persistent class for entity stored in table "cierre"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="cierre", catalog="plaproc" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Cierre.countAll", query="SELECT COUNT(x) FROM Cierre x" )
} )
public class Cierre implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="nroCie", nullable=false)
    private Integer    nroCie       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="nroArt")
    private Integer    nroArt       ;

    @Column(name="motivo", length=100)
    private String     motivo       ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaIngresoDoc")
    private Date       fechaIngresoDoc ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaEmiRes")
    private Date       fechaEmiRes  ;

	// "codCas" (column "codCas") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="codCas", referencedColumnName="codCas")
    private Caso caso        ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Cierre() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setNroCie( Integer nroCie ) {
        this.nroCie = nroCie ;
    }
    public Integer getNroCie() {
        return this.nroCie;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : nroArt ( INT ) 
    public void setNroArt( Integer nroArt ) {
        this.nroArt = nroArt;
    }
    public Integer getNroArt() {
        return this.nroArt;
    }

    //--- DATABASE MAPPING : motivo ( VARCHAR ) 
    public void setMotivo( String motivo ) {
        this.motivo = motivo;
    }
    public String getMotivo() {
        return this.motivo;
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
        sb.append(nroCie);
        sb.append("]:"); 
        sb.append(nroArt);
        sb.append("|");
        sb.append(motivo);
        sb.append("|");
        sb.append(fechaIngresoDoc);
        sb.append("|");
        sb.append(fechaEmiRes);
        return sb.toString(); 
    } 

}
