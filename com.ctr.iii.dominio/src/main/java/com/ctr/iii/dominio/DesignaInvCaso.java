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
 * Persistent class for entity stored in table "designainvcaso"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="designainvcaso", catalog="plaproc" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="DesignaInvCaso.countAll", query="SELECT COUNT(x) FROM DesignaInvCaso x" )
} )
public class DesignaInvCaso implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="nroDes", nullable=false)
    private Integer    nroDes       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaIni")
    private Date       fechaIni     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaFin")
    private Date       fechaFin     ;

    @Column(name="accion", length=30)
    private String     accion       ;

    @Column(name="tipoRes", length=50)
    private String     tipoRes      ;

	// "codCas" (column "codCas") is not defined by itself because used as FK in a link 
	// "codInv" (column "codInv") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="codInv", referencedColumnName="codInv")
    private Investigador investigador;

    @ManyToOne
    @JoinColumn(name="codCas", referencedColumnName="codCas")
    private Caso caso        ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public DesignaInvCaso() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setNroDes( Integer nroDes ) {
        this.nroDes = nroDes ;
    }
    public Integer getNroDes() {
        return this.nroDes;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : fechaIni ( DATETIME ) 
    public void setFechaIni( Date fechaIni ) {
        this.fechaIni = fechaIni;
    }
    public Date getFechaIni() {
        return this.fechaIni;
    }

    //--- DATABASE MAPPING : fechaFin ( DATETIME ) 
    public void setFechaFin( Date fechaFin ) {
        this.fechaFin = fechaFin;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }

    //--- DATABASE MAPPING : accion ( VARCHAR ) 
    public void setAccion( String accion ) {
        this.accion = accion;
    }
    public String getAccion() {
        return this.accion;
    }

    //--- DATABASE MAPPING : tipoRes ( VARCHAR ) 
    public void setTipoRes( String tipoRes ) {
        this.tipoRes = tipoRes;
    }
    public String getTipoRes() {
        return this.tipoRes;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setInvestigador( Investigador investigador ) {
        this.investigador = investigador;
    }
    public Investigador getInvestigador() {
        return this.investigador;
    }

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
        sb.append(nroDes);
        sb.append("]:"); 
        sb.append(fechaIni);
        sb.append("|");
        sb.append(fechaFin);
        sb.append("|");
        sb.append(accion);
        sb.append("|");
        sb.append(tipoRes);
        return sb.toString(); 
    } 

}
